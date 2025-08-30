package gaji.service.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public class TestController {

    @GetMapping("/page")
    public String testController() {
        return "test ok";
    }
}
