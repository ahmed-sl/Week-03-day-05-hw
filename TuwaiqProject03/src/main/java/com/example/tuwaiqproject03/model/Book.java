package com.example.tuwaiqproject03.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "name is required")
    @Column(unique = true)
    private String name;
    @NotEmpty(message = "genre is required")
    private String genre;

    @ManyToMany(mappedBy = "books",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Loan> loans;
}
