package com.example.tuwaiqproject03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "user id is required")
    private Integer userID;
    @NotNull(message = "book id is required")
    private Integer bookID;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Book> books;
}
