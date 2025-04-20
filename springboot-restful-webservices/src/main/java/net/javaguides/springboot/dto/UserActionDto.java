package net.javaguides.springboot.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.springboot.model.UserRole;

import java.time.LocalDateTime;

@Schema(
        description = "UserActionDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserActionDto {

    private Long id;

    @Schema(
            description = "UserId"
    )
    // UserId name should not be null or empty
    @NotEmpty(message = "UserId should not be null or empty")
    private String userId;

    @NotEmpty(message = "UserRole should not be null or empty")
    private UserRole role;

    @NotEmpty(message = "UserAction should not be null or empty")
    private String actionType;

    private LocalDateTime timeStamp;
}
