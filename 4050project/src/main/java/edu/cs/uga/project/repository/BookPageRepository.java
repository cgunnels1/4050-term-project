package edu.cs.uga.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cs.uga.project.model.Book;

@Repository
public interface BookPageRepository extends JpaRepository<Book, Long>{
}