package com.example.tuwaiqproject03.controoler;

import com.example.tuwaiqproject03.DTO.API;
import com.example.tuwaiqproject03.model.Book;
import com.example.tuwaiqproject03.model.Loan;
import com.example.tuwaiqproject03.service.BookService;
import com.example.tuwaiqproject03.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;
    Logger logger = LoggerFactory.getLogger(LoanController.class);

    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        return ResponseEntity.status(201).body(loanService.getLoans());
    }

    @PostMapping
    public ResponseEntity<API> addLoan(@RequestBody @Valid Loan loan){
        String message= loanService.addLoan(loan);
        logger.info("addLoan it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @PutMapping("/{userID}/{bookID}")
    public ResponseEntity<API> lendBook(@PathVariable Integer userID, @PathVariable Integer bookID){
        String message = loanService.lendBook(userID,bookID);
        logger.info("lendBook it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @PutMapping("return/{bookID}")
    public ResponseEntity<API> returnBook(@PathVariable Integer bookID){
        String message = loanService.returnBook(bookID);
        logger.info("returnBook it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
}
