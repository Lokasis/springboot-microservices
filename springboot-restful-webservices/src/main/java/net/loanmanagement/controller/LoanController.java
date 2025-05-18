package net.loanmanagement.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.loanmanagement.dto.CreateLoanRequest;
import net.loanmanagement.dto.LoanDto;
import net.loanmanagement.dto.UpdateLoanRequest;
import net.loanmanagement.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<LoanDto> createNewLoan(@Valid  @RequestBody  final CreateLoanRequest loanRequest) {
        LoanDto response = loanService.createLoan(loanRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/loan/{id}")
    public ResponseEntity<LoanDto> getLoanById(@PathVariable("id") final Long id) {
        LoanDto response = loanService.getLoanbyId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/loans")
    public ResponseEntity<List<LoanDto>> getAllActiveLoans() {
        List<LoanDto> response = loanService.getAllActiveLoans();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/loan/{id}")
    public void deleteLoanById(@PathVariable("id") final Long id) {
        loanService.softDelete(id);
    }

    @PutMapping("/loan/{id}")
    public ResponseEntity<LoanDto> updateLoanById(@PathVariable("id") final Long id,
                                                  @Valid @RequestBody final UpdateLoanRequest request) {
        LoanDto response = loanService.updateLoan(id, request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
