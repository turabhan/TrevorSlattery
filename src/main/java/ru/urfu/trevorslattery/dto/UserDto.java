package ru.urfu.trevorslattery.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.urfu.trevorslattery.enums.Role;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Data
public class UserDto {
    Long id;

    @Email
    @NotBlank
    String email;
    @Size(min = 6)
    String password;
    Boolean deleted = false;
    Role role;
    LocalDateTime createdAt;
}
