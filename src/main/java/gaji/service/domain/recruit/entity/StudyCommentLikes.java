package gaji.service.domain.recruit.entity;

import gaji.service.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyCommentLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "study_comment_likes_seq")
    @SequenceGenerator(name = "study_comment_likes_seq", sequenceName = "study_comment_likes_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private StudyComment studyComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
