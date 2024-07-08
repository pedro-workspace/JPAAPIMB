package com.bookstore.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.jpa.models.AuthorModel;
import java.util.UUID;
// import org.springframework.data.repository.query.Param;
// import org.springframework.data.jpa.repository.Query;
// import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID>{
    
}