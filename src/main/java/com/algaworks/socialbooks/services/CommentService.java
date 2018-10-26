package com.algaworks.socialbooks.services;

import com.algaworks.socialbooks.exceptions.BookNotFoundException;
import com.algaworks.socialbooks.model.book.Book;
import com.algaworks.socialbooks.model.book.Comment;
import com.algaworks.socialbooks.repository.BookRepository;
import com.algaworks.socialbooks.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(final BookRepository bookRepository,
                          final CommentRepository commentRepository) {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }

    public void saveComment(final UUID bookId, final Comment comment) {
        final Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (!bookOptional.isPresent()) {
            throw new BookNotFoundException("The book could not be found.");
        }

        comment.setBook(bookOptional.get());
        comment.setDate(new Date());

        commentRepository.save(comment);
    }

    public List<Comment> listComment(final UUID bookId) {
        final Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (!bookOptional.isPresent()) {
            throw new BookNotFoundException("The book could not be found.");
        }

        return bookOptional.get().getComments();
    }
}