package gaji.service.temp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GajiVote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gaji_vote_seq")
    @SequenceGenerator(name = "gaji_vote_seq", sequenceName = "gaji_vote_sequence", allocationSize = 1)
    private Long id;

    private String email;

    private String characterName;

    private int voteCount;

    public void plusVoteCount() {
        this.voteCount += 1;
    }
}
