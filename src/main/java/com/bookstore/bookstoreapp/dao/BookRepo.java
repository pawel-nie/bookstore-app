package com.bookstore.bookstoreapp.dao;

import com.bookstore.bookstoreapp.dao.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{

}
