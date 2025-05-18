package net.loanmanagement.service;

import net.loanmanagement.dto.CreateLoanRequest;
import net.loanmanagement.dto.LoanDto;

public interface LoanService {

    LoanDto createLoan(CreateLoanRequest request);
}
