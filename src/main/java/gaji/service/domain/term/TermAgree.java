package gaji.service.domain.term;

import gaji.service.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TermAgree {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "term_agree_seq")
    @SequenceGenerator(name = "term_agree_seq", sequenceName = "term_agree_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private Term term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean isAgree;
    private LocalDate agreeDate;


}
