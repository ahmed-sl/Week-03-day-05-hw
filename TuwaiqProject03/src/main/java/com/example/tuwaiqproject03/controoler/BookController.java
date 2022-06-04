package com.example.tuwaiqproject03.controoler;

import com.example.tuwaiqproject03.DTO.API;
import com.example.tuwaiqproject03.model.Book;
import com.example.tuwaiqproject03.model.User;
import com.example.tuwaiqproject03.service.BookService;
import com.example.tuwaiqproject03.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        logger.info("getBooks it's used");
        return ResponseEntity.status(201).body(bookService.getBooks());
    }

    @PostMapping
    public ResponseEntity<API> addBook(@RequestBody @Valid Book book){
        String message= bookService.addBook(book);
        logger.info("addBook it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
}
