package edu.cs.uga.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cs.uga.project.model.ArchivedBook;

@Repository
public interface ArchivedBookRepository extends JpaRepository<ArchivedBook, Long>{
}
