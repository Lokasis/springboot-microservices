package net.loanmanagement.service;

import net.loanmanagement.dto.CreateLoanRequest;
import net.loanmanagement.dto.LoanDto;

import java.util.List;

public interface LoanService {

    LoanDto createLoan(CreateLoanRequest request);
    LoanDto getLoanbyId(Long id);
    List<LoanDto> getAllActiveLoans();
    void softDelete(Long id);
}
