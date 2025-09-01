package gaji.service.domain.file.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Files")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "files_seq")
    @SequenceGenerator(name = "files_seq", sequenceName = "files_sequence", allocationSize = 1)
    private Long id;

    //확장자
    private String type;

    //크기
    private Integer file_size;

    //원본이름
    private String originalName;

    //원본이름
    private String fileName;

    //파일 경로
    private String path;

    @Builder
    public Files(String type, Integer size, String originalName, String fileName, String path) {
        this.type = type;
        this.file_size = size;
        this.originalName = originalName;
        this.fileName = fileName;
        this.path = path;
    }
}
