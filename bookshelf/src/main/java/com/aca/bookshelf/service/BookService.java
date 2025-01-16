package com.aca.bookshelf.service;

import com.aca.bookshelf.dao.BookDao;
import com.aca.bookshelf.dao.BookDaoImpl;
import com.aca.bookshelf.model.Book;
import com.aca.bookshelf.model.BookException;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDaoImpl();

    private void validateReleaseYear(Integer releaseYear) throws BookException {
        if (null == releaseYear){
            throw new BookException("Invalid value for release year; null value is not allowed.");
        } else if (releaseYear < 1000 || releaseYear > 2030){
            throw new BookException("Invalid value for release year; out of range");
        }
    }

    public List<Book> getBooks(){
        return bookDao.getBooks();
    }

    public Book createBook (Book newBook) throws BookException{
        validateReleaseYear(newBook.getReleaseYear());
        return bookDao.insertBook(newBook);
    }

    public List<Book> getBooksById(Integer bookId){
        return bookDao.getBooksById(bookId);
    }

    public Book updateBook(Book updateBook){
        return bookDao.updateBook(updateBook);
    }


    public Book deleteBookById(Integer bookId){
        return bookDao.deleteBookById(bookId);
    }

}
