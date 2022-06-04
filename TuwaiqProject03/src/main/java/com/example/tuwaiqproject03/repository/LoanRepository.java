package com.example.tuwaiqproject03.repository;

import com.example.tuwaiqproject03.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    Loan findByBookID(Integer bookID);
}
