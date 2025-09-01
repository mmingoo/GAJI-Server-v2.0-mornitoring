package gaji.service.domain.post.entity;

import gaji.service.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostFile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_file_seq")
    @SequenceGenerator(name = "post_file_seq", sequenceName = "post_file_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private CommnuityPost post;

    private String path;
}
