package com.example.tuwaiqproject03.service;

import com.example.tuwaiqproject03.exception.InvalidException;
import com.example.tuwaiqproject03.model.Book;
import com.example.tuwaiqproject03.model.Loan;
import com.example.tuwaiqproject03.model.User;
import com.example.tuwaiqproject03.repository.BookRepository;
import com.example.tuwaiqproject03.repository.LoanRepository;
import com.example.tuwaiqproject03.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public String addLoan(Loan loan) {
        loanRepository.save(loan);
        return "Loan add !";
    }

    public String lendBook(Integer userID, Integer bookID) {
        User user = userRepository.findById(userID).orElseThrow(()-> new InvalidException("User ID is invalid "));
        Book book = bookRepository.findById(bookID).orElseThrow(()-> new InvalidException("Book ID is invalid"));
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book);
        Loan loan = new Loan(null,userID,bookID,bookSet);
        Set<Loan> loanSet = book.getLoans();

        if (loanSet.isEmpty()){
            loanSet = new HashSet<>();
        }
        loanSet.add(loan);
        loanRepository.save(loan);
        bookRepository.save(book);
        return "Lend book completed !";
    }

    public String returnBook(Integer bookID) {
        Book book = bookRepository.findById(bookID).orElseThrow(()-> new InvalidException("Book ID is invalid "));
        Loan loan = loanRepository.findByBookID(bookID);
        Set<Book> bookSet = loan.getBooks();
        bookSet.remove(book);
        Set<Loan> loanSet = book.getLoans();
        loanSet.remove(loan);
        bookRepository.save(book);
        loanRepository.save(loan);
        return "return book completed !";
    }
}
