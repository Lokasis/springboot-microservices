package net.loanmanagement.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.loanmanagement.model.UserRole;

@Schema(
        description = "Notification Request"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequestDto {

    private Long userId;

    private UserRole role;

    private String message;
}
