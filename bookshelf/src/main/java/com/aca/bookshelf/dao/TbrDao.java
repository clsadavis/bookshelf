package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Tbr;

import java.util.List;

public interface TbrDao {
    public abstract List<Tbr> getTbrBooks();
    public abstract Tbr insertTbrBook(Tbr newTbrBook);
    public abstract List<Tbr> getTbrBooksById(Integer bookId);
    public abstract Tbr updateTbrBook(Tbr updateTbrBook);
    public abstract Tbr deleteTbrBookById(Integer bookId);

}
