package gaji.service.domain.studyMate.entity;

import gaji.service.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class UserAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_assignment_seq")
    @SequenceGenerator(name = "user_assignment_seq", sequenceName = "user_assignment_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    private boolean isComplete;

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
