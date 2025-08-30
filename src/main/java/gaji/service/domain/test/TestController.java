package gaji.service.domain.test;

import gaji.service.domain.enums.ServiceRole;
import gaji.service.domain.enums.SocialType;
import gaji.service.domain.user.entity.User;
import gaji.service.domain.user.service.UserCommandService;
import gaji.service.domain.user.service.UserQueryService;
import gaji.service.jwt.entity.RefreshEntity;
import gaji.service.jwt.filter.JWTUtil;
import gaji.service.jwt.rpository.RefreshRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final JWTUtil jwtUtil;
    private final RefreshRepository refreshRepository;
    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;


        //Get 요청으로 api 테스트
        @GetMapping("/page")
        public String test() {
            return "test ok";
        }




    /**
     * 테스트용 JWT 토큰 발급 API
     * 실제 운영환경에서는 제거해야 함
     */
    @GetMapping("/token")
    public ResponseEntity<Map<String, String>> generateTestToken(
            @RequestParam(defaultValue = "testUser") String username) {

        String usernameId = "GOOGLE " + username;

        // 테스트 유저가 없으면 생성
        User existUser = userQueryService.findByUsernameId(usernameId);
        if (existUser == null) {
            User newUser = User.builder()
                    .usernameId(usernameId)
                    .socialType(SocialType.GOOGLE)
                    .role(ServiceRole.ROLE_USER)
                    .build();
            userCommandService.save(newUser);
        }

        String role = ServiceRole.ROLE_USER.name();

        // JWT 토큰 생성
        String accessToken = jwtUtil.createJwt("access", usernameId, role, 600000000L); // 10분
        String refreshToken = jwtUtil.createJwt("refresh", usernameId, role, 86400000000L); // 24시간

        // Refresh 토큰 DB 저장
        if (!refreshRepository.existsByUsername(usernameId)) {
            addRefreshEntity(usernameId, refreshToken, 86400000000L);
        }

        Map<String, String> response = new HashMap<>();
        response.put("access_token", accessToken);
        response.put("refresh_token", refreshToken);
        response.put("username", usernameId);

        return ResponseEntity.ok(response);
    }

    private void addRefreshEntity(String username, String refresh, Long expiredMs) {
        Date date = new Date(System.currentTimeMillis() + expiredMs);
        RefreshEntity refreshEntity = new RefreshEntity();
        refreshEntity.setUsername(username);
        refreshEntity.setRefresh(refresh);
        refreshEntity.setExpiration(date.toString());
        refreshRepository.save(refreshEntity);
    }

    }
