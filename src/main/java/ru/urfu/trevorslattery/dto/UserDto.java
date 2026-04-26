package ru.urfu.trevorslattery.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.urfu.trevorslattery.enums.Role;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
public class UserDto {
    Long id;
    String email;
    String password; // временно
    Boolean deleted = false;

    @Enumerated(EnumType.STRING)
    Role role;
    LocalDateTime createdAt;
}
