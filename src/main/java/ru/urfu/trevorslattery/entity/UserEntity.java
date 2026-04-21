package ru.urfu.trevorslattery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.urfu.trevorslattery.enums.Role;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Boolean deleted = false;

    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime createdAt;

}
