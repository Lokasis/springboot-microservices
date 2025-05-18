package net.loanmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanRequest {

    @Schema(
            description = "Create Loan Request"
    )

    @NonNull
    private String borrowerName;

    @NonNull
    private Double amount;

    private Double interestRate;

    @NonNull
    private Integer durationMonths;
}
