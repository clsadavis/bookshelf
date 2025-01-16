package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Book;

import java.util.List;

public interface BookDao {
    public abstract List<Book> getBooks();
    public abstract Book insertBook(Book newBook);
    public abstract List<Book> getBooksById(Integer bookId);
    public abstract Book updateBook(Book updateBook);
    public abstract Book deleteBookById(Integer bookId);

}
