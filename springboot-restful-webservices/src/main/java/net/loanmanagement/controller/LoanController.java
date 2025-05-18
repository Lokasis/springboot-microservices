package net.loanmanagement.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.loanmanagement.dto.CreateLoanRequest;
import net.loanmanagement.dto.LoanDto;
import net.loanmanagement.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "CRUD REST APIs for Loan Management",
        description = "CRUD REST APIs - Create Loan, Update Loan, Get Loan, Get All Loans, Delete Loan"
)
@RestController
@AllArgsConstructor
@RequestMapping("api")
public class LoanController {

    private LoanService loanService;

    @PostMapping("/loans")
    public ResponseEntity<LoanDto> createNewLoan(@RequestBody  final CreateLoanRequest loanRequest) {
        LoanDto response = loanService.createLoan(loanRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
