package com.socialbooks.repository;

import com.socialbooks.model.book.Book;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, UUID> {

}