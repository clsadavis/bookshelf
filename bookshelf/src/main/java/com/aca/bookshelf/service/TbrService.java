package com.aca.bookshelf.service;


import com.aca.bookshelf.dao.TbrDao;
import com.aca.bookshelf.dao.TbrDaoImpl;
import com.aca.bookshelf.model.BookException;
import com.aca.bookshelf.model.Tbr;

import java.util.List;

public class TbrService {
    private TbrDao tbrDao = new TbrDaoImpl();

    public List<Tbr> getTbrBooks(){
        return tbrDao.getTbrBooks();
    }

    private void validateReleaseYear(Integer releaseYear) throws BookException {
        if (null == releaseYear){
            throw new BookException("Invalid value for release year; null value is not allowed.");
        } else if (releaseYear < 1000 || releaseYear > 2030){
            throw new BookException("Invalid value for release year; out of range");
        }
    }

    public Tbr createTbrBook (Tbr newTbrBook) throws BookException{
        validateReleaseYear(newTbrBook.getReleaseYear());
        return tbrDao.insertTbrBook(newTbrBook);
    }

    public List<Tbr> getTbrBooksById(Integer bookId){
        return tbrDao.getTbrBooksById(bookId);
    }

    public Tbr updateTbrBook(Tbr updateTbrBook){
        return tbrDao.updateTbrBook(updateTbrBook);
    }

    public Tbr deleteTbrBookById(Integer bookId){
        return tbrDao.deleteTbrBookById(bookId);
    }


}
