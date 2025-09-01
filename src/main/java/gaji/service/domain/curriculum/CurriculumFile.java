package gaji.service.domain.curriculum;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CurriculumFile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curriculum_file_seq")
    @SequenceGenerator(name = "curriculum_file_seq", sequenceName = "curriculum_file_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    private String path;
    private String description;
}
