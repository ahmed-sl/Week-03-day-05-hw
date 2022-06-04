package com.example.tuwaiqproject03.service;

import com.example.tuwaiqproject03.model.Book;
import com.example.tuwaiqproject03.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public String addBook(Book book) {
        bookRepository.save(book);
        return "book add !";
    }
}
