package net.loanmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoanRequest {

    @Schema(
            description = "Update Loan Request"
    )


    @Min(value=1000, message = "Loan amount must be greater or equal to 1000")
    private Double amount;

    private Double interestRate;

    @Min(value=12, message = "Minimum duration is 12 months")
    private Integer durationMonths;
}
