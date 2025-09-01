package gaji.service.jwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RefreshEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refresh_entity_seq")
    @SequenceGenerator(name = "refresh_entity_seq", sequenceName = "refresh_entity_sequence", allocationSize = 1)
    private Long id;

    private String username;
    private String refresh;
    private String expiration;
}