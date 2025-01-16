package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private static String selectAllBooks =
            "SELECT bookId, title, author, starRating, publisher, dateRead, releaseYear, bookFormat, pageCount, audioBook, ageRating, seriesNumber, " +
                    "keyword1, keyword2, keyword3, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 \n " +
                    "FROM books";

    private static String insertBook =
            "INSERT INTO books (title, author, starRating, publisher, dateRead, releaseYear, bookFormat, pageCount, " +
            "audioBook, ageRating, seriesNumber, keyword1, keyword2, keyword3, " +
            "hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 )" +
            "VALUES " +
                    "(? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

    private static String selectBooksById =
            "SELECT bookId, title, author, starRating, publisher, dateRead, releaseYear, bookFormat, pageCount, audioBook, ageRating, seriesNumber, " +
                    "keyword1, keyword2, keyword3, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 \n " +
                    "FROM books " +
                    "WHERE bookId = ? ";

    private static String updateBookById =
            "UPDATE books " +
                    "SET title = ?, " +
                    "author = ?, " +
                    "starRating = ?, " +
                    "publisher = ?, " +
                    "dateRead = ?, " +
                    "releaseYear = ?, " +
                    "bookFormat = ?, " +
                    "pageCount = ?, " +
                    "audioBook = ?, " +
                    "ageRating = ?, " +
                    "seriesNumber = ?, " +
                    "keyword1 = ?, " +
                    "keyword2 = ?, " +
                    "keyword3 = ?, " +
                    "hashtag1 = ?, " +
                    "hashtag2 = ?, " +
                    "hashtag3 = ?, " +
                    "hashtag4 = ?, " +
                    "hashtag5 = ? " +
                    "WHERE bookId = ? ";

    private static String deleteBookById =
            "DELETE FROM books " +
                    "WHERE bookId = ?  ";


    @Override
    public List<Book> getBooks() {
        List<Book> myBooks = new ArrayList<>();
        ResultSet result = null;
        Statement statement = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(selectAllBooks);
            myBooks = makeBooks(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myBooks;
    }


    private List<Book> makeBooks(ResultSet result) throws SQLException{
        List<Book> books = new ArrayList<>();

        while(result.next()){
            Book book = new Book();
            book.setTitle(result.getString("books.title"));

            book.setId(result.getInt("bookId"));
            book.setAuthor(result.getString("author"));
            book.setStarRating(result.getString("starRating"));
            book.setPublisher(result.getString("publisher"));
            book.setDateRead(result.getInt("dateRead"));
            book.setReleaseYear(result.getInt("releaseYear"));
            book.setBookFormat(result.getString("bookFormat"));
            book.setPageCount(result.getInt("pageCount"));
            book.setAudioBook(result.getString("audioBook"));
            book.setAgeRating(result.getString("ageRating"));
            book.setSeriesNumber(result.getString("seriesNumber"));
            book.setKeyword1(result.getString("keyword1"));
            book.setKeyword2(result.getString("keyword2"));
            book.setKeyword3(result.getString("keyword3"));
            book.setHashtag1(result.getString("hashtag1"));
            book.setHashtag2(result.getString("hashtag2"));
            book.setHashtag3(result.getString("hashtag3"));
            book.setHashtag4(result.getString("hashtag4"));
            book.setHashtag5(result.getString("hashtag5"));

            books.add(book);
        }
        return books;
    }

    @Override
    public Book insertBook(Book newBook){
        PreparedStatement ps = null;
        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(insertBook);
            ps.setString(1, newBook.getTitle());
            ps.setString(2, newBook.getAuthor());
            ps.setString(3, newBook.getStarRating());
            ps.setString(4, newBook.getPublisher());
            ps.setInt(5, newBook.getDateRead());
            ps.setInt(6, newBook.getReleaseYear());
            ps.setString(7, newBook.getBookFormat());
            ps.setInt(8, newBook.getPageCount());
            ps.setString(9, newBook.getAudioBook());
            ps.setString(10, newBook.getAgeRating());
            ps.setString(11, newBook.getSeriesNumber());
            ps.setString(12, newBook.getKeyword1());
            ps.setString(13, newBook.getKeyword2());
            ps.setString(14, newBook.getKeyword3());
            ps.setString(15, newBook.getHashtag1());
            ps.setString(16, newBook.getHashtag2());
            ps.setString(17, newBook.getHashtag3());
            ps.setString(18, newBook.getHashtag4());
            ps.setString(19, newBook.getHashtag5());
            int rowCount = ps.executeUpdate();
            System.out.println("Insert count: " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newBook;
    }


    @Override
    public List<Book> getBooksById(Integer bookId) {
        List<Book> myBooks = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectBooksById);
            ps.setInt(1,bookId);
            result = ps.executeQuery();
            myBooks = makeBooks(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myBooks;
    }

    @Override
    public Book updateBook(Book updateBook){
        List<Book> books = this.getBooksById(updateBook.getId());

        if(books.size() > 0 ){
            PreparedStatement ps = null;
            Connection connection = MariaDbUtil.getConnection();
            try {
                ps = connection.prepareStatement(updateBookById);
                ps.setString(1, updateBook.getTitle());
                ps.setString(2, updateBook.getAuthor());
                ps.setString(3, updateBook.getStarRating());
                ps.setString(4, updateBook.getPublisher());
                ps.setInt(5, updateBook.getDateRead());
                ps.setInt(6, updateBook.getReleaseYear());
                ps.setString(7, updateBook.getBookFormat());
                ps.setInt(8, updateBook.getPageCount());
                ps.setString(9, updateBook.getAudioBook());
                ps.setString(10, updateBook.getAgeRating());
                ps.setString(11, updateBook.getSeriesNumber());
                ps.setString(12, updateBook.getKeyword1());
                ps.setString(13, updateBook.getKeyword2());
                ps.setString(14, updateBook.getKeyword3());
                ps.setString(15, updateBook.getHashtag1());
                ps.setString(16, updateBook.getHashtag2());
                ps.setString(17, updateBook.getHashtag3());
                ps.setString(18, updateBook.getHashtag4());
                ps.setString(19, updateBook.getHashtag5());
                ps.setInt(20, updateBook.getId());
                int rowCount = ps.executeUpdate();
                System.out.println("Rows updated: " + rowCount);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateBook;
    }

    @Override
    public Book deleteBookById(Integer bookId){
        List<Book> books = getBooksById(bookId);
        Book bookToDelete = null;

        if (books.size() > 0){
            bookToDelete = books.get(0);
            int updateRowCount = 0;
            PreparedStatement ps = null;
            Connection connection = MariaDbUtil.getConnection();

            try {
                ps = connection.prepareStatement(deleteBookById);
                ps.setInt(1, bookId);
                int rowCount = ps.executeUpdate();
                System.out.println("Rows Deleted: " + rowCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return bookToDelete;
    }

}
