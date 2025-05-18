package net.loanmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Schema(
        description = "Email Update Request"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailUpdateRequest {

    @Schema(
            description = "User Email Address"
    )
    // User email should not be null or empty
    // Email address should be valid
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;

}
