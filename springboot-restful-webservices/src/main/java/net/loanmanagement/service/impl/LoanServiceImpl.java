package net.loanmanagement.service.impl;

import lombok.AllArgsConstructor;
import net.loanmanagement.dto.CreateLoanRequest;
import net.loanmanagement.dto.LoanDto;
import net.loanmanagement.exception.ResourceNotFoundException;
import net.loanmanagement.mapper.AutoUserMapper;
import net.loanmanagement.model.Loan;
import net.loanmanagement.repository.LoanRepository;
import net.loanmanagement.service.LoanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public LoanDto getLoanbyId(Long id) {
        Loan loan = loanRepository.findById(id)
                .filter(l -> !l.getIsDeleted())
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "Id", id));

        LoanDto loanDto = AutoUserMapper.MAPPER.toLoanDto(loan);
        return loanDto;
    }

    @Override
    public List<LoanDto> getAllActiveLoans() {

        List<LoanDto> loanDtos = loanRepository.findAll()
                .stream()
                .filter(loan -> !loan.getIsDeleted())
                .map(AutoUserMapper.MAPPER::toLoanDto)
                .toList();

        return loanDtos;
    }

    @Override
    public void softDelete(Long id) {

        Loan loan = loanRepository.findById(id)
                .filter(l -> !l.getIsDeleted())
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "Id", id));

        loan.setIsDeleted(true);
        loanRepository.save(loan);

    }
}
