package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDaoMock implements BookDao {

    private static List<Book> books = new ArrayList<Book>();

    private static Integer lastBookId = 0;

    private static Integer getNextBookId(){
        lastBookId++;
        return lastBookId;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> myBooks = new ArrayList<Book>();
        myBooks.addAll(books);
        return myBooks;
    }

    @Override
    public Book insertBook(Book newBook){
        newBook.setId(getNextBookId());
        books.add(newBook);
        return newBook;
    }

    @Override
    public List<Book> getBooksById(Integer bookId) {
        List<Book> myBooks = new ArrayList<Book>();
        for(Book book : BookDaoMock.books){
            if (book.getId().intValue() == bookId.intValue()){
                myBooks.add(book);
            }
        }
        return myBooks;
    }

    @Override
    public Book updateBook(Book updateBook) {
        for (Book book : books){
            if(book.getId().intValue() == updateBook.getId().intValue()){
                book.setTitle(updateBook.getTitle());
                book.setAuthor(updateBook.getAuthor());
                book.setStarRating(updateBook.getStarRating());
                book.setPublisher(updateBook.getPublisher());
                book.setDateRead(updateBook.getDateRead());
                book.setReleaseYear(updateBook.getReleaseYear());
                book.setBookFormat(updateBook.getBookFormat());
                book.setPageCount(updateBook.getPageCount());
                book.setAudioBook(updateBook.getAudioBook());
                book.setAgeRating(updateBook.getAgeRating());
                book.setSeriesNumber(updateBook.getSeriesNumber());
                book.setKeyword1(updateBook.getKeyword1());
                book.setKeyword2(updateBook.getKeyword2());
                book.setKeyword3(updateBook.getKeyword3());
                book.setHashtag1(updateBook.getHashtag1());
                book.setHashtag2(updateBook.getHashtag2());
                book.setHashtag3(updateBook.getHashtag3());
                book.setHashtag4(updateBook.getHashtag4());
                book.setHashtag5(updateBook.getHashtag5());
                break;
            }
        }
        return updateBook;
    }

    public Book deleteBookById(Integer bookId){
        List<Book> books = getBooksById(bookId);
        Book book = null;

        if(books.size() > 0){
            book = books.get(0);
            BookDaoMock.books.remove(book);
        }
        return book;
    }
}
