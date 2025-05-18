package net.loanmanagement.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Loan Dto for LoanService"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {

    @NonNull
    private String borrowerName;

    @NonNull
    private Double amount;

    private Double interestRate;

    @NonNull
    private Integer durationMonths;
}
