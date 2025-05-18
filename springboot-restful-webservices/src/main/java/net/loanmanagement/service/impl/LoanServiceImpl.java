package net.loanmanagement.service.impl;

import lombok.AllArgsConstructor;
import net.loanmanagement.dto.CreateLoanRequest;
import net.loanmanagement.dto.LoanDto;
import net.loanmanagement.mapper.AutoUserMapper;
import net.loanmanagement.model.Loan;
import net.loanmanagement.repository.LoanRepository;
import net.loanmanagement.service.LoanService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;

    @Override
    public LoanDto createLoan(CreateLoanRequest request) {

        Loan loan = AutoUserMapper.MAPPER.toLoan(request);
        loanRepository.save(loan);
        LoanDto loanDto = AutoUserMapper.MAPPER.toLoanDto(loan);

        return loanDto;
    }
}
