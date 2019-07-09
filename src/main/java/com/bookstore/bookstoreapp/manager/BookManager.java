package com.bookstore.bookstoreapp.manager;

import com.bookstore.bookstoreapp.dao.BookRepo;
import com.bookstore.bookstoreapp.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookManager {

    private BookRepo bookRepo;

    @Autowired
    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Optional<Book> findById(Long id){
        return bookRepo.findById(id);
    }

    public Iterable<Book> findAll(){
        return bookRepo.findAll();
    }

    public Book save(Book book){
        return bookRepo.save(book);
    }

    public void deleteById(Long id){
        bookRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Book(1L, "Bible", LocalDate.of(0, 5, 23)));
        save(new Book(2L, "Misery", LocalDate.of(1982, 1, 2)));
        save(new Book(3L, "1984", LocalDate.of(1984, 11, 12)));
    }


}
