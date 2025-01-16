package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Book;
import com.aca.bookshelf.model.Tbr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TbrDaoImpl implements TbrDao{

    private static String selectAllTbrBooks =
            "SELECT bookId, title, author, releaseYear, bookFormat, pageCount, audioBook, ageRating, seriesNumber, " +
                    "keyword1, keyword2, keyword3, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5, " +
                    "recScore, keywordScore, authorScore, totalScore \n " +
                    "FROM tbr";

    private static String insertTbrBook =
            "INSERT INTO tbr (title, author, releaseYear, bookFormat, pageCount, " +
            "audioBook, ageRating, seriesNumber, keyword1, keyword2, keyword3, " +
            "hashtag1, hashtag2, hashtag3, hashtag4, hashtag5, recScore, keywordScore, authorScore, totalScore )" +
            "VALUES " +
            "(? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

    private static String selectTbrBooksById =
            "SELECT bookId, title, author, releaseYear, bookFormat, pageCount, audioBook, ageRating, seriesNumber, " +
                    "keyword1, keyword2, keyword3, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5, " +
                    "recScore, keywordScore, authorScore, totalScore  \n " +
                    "FROM tbr " +
                    "WHERE bookId = ? ";

    private static String updateTbrBookById =
            "UPDATE tbr " +
                    "SET title = ?, " +
                    "author = ?, " +
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
                    "hashtag5 = ?, " +
                    "recScore = ?, " +
                    "keywordScore = ?, " +
                    "authorScore = ?, " +
                    "totalScore = ? " +
                    "WHERE bookId = ? ";

    private static String deleteTbrBookById =
            "DELETE FROM tbr " +
                    "WHERE bookId = ?  ";

    @Override
    public List<Tbr> getTbrBooks() {
        List<Tbr> myTbrBooks = new ArrayList<>();
        ResultSet result = null;
        Statement statement = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(selectAllTbrBooks);
            myTbrBooks = makeTbrBooks(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myTbrBooks;
    }

    private List<Tbr> makeTbrBooks(ResultSet result) throws SQLException{
        List<Tbr> tbrBooks = new ArrayList<>();

        while(result.next()){
            Tbr tbrBook = new Tbr();
            tbrBook.setTitle(result.getString("tbr.title"));

            tbrBook.setId(result.getInt("bookId"));
            tbrBook.setAuthor(result.getString("author"));
            tbrBook.setReleaseYear(result.getInt("releaseYear"));
            tbrBook.setBookFormat(result.getString("bookFormat"));
            tbrBook.setPageCount(result.getInt("pageCount"));
            tbrBook.setAudioBook(result.getString("audioBook"));
            tbrBook.setAgeRating(result.getString("ageRating"));
            tbrBook.setSeriesNumber(result.getString("seriesNumber"));
            tbrBook.setKeyword1(result.getString("keyword1"));
            tbrBook.setKeyword2(result.getString("keyword2"));
            tbrBook.setKeyword3(result.getString("keyword3"));
            tbrBook.setHashtag1(result.getString("hashtag1"));
            tbrBook.setHashtag2(result.getString("hashtag2"));
            tbrBook.setHashtag3(result.getString("hashtag3"));
            tbrBook.setHashtag4(result.getString("hashtag4"));
            tbrBook.setHashtag5(result.getString("hashtag5"));
            tbrBook.setRecScore(result.getInt("recScore"));
            tbrBook.setKeywordScore(result.getInt("keywordScore"));
            tbrBook.setAuthorScore(result.getInt("authorScore"));
            tbrBook.setTotalScore(result.getInt("totalScore"));

            tbrBooks.add(tbrBook);
        }
        return tbrBooks;
    }

    @Override
    public Tbr insertTbrBook(Tbr newTbrBook) {
        PreparedStatement ps = null;
        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(insertTbrBook);
            ps.setString(1, newTbrBook.getTitle());
            ps.setString(2, newTbrBook.getAuthor());
            ps.setInt(3, newTbrBook.getReleaseYear());
            ps.setString(4, newTbrBook.getBookFormat());
            ps.setInt(5, newTbrBook.getPageCount());
            ps.setString(6, newTbrBook.getAudioBook());
            ps.setString(7, newTbrBook.getAgeRating());
            ps.setString(8, newTbrBook.getSeriesNumber());
            ps.setString(9, newTbrBook.getKeyword1());
            ps.setString(10, newTbrBook.getKeyword2());
            ps.setString(11, newTbrBook.getKeyword3());
            ps.setString(12, newTbrBook.getHashtag1());
            ps.setString(13, newTbrBook.getHashtag2());
            ps.setString(14, newTbrBook.getHashtag3());
            ps.setString(15, newTbrBook.getHashtag4());
            ps.setString(16, newTbrBook.getHashtag5());
            ps.setInt(17, newTbrBook.getRecScore());
            ps.setInt(18, newTbrBook.getKeywordScore());
            ps.setInt(19, newTbrBook.getAuthorScore());
            ps.setInt(20, newTbrBook.getTotalScore());
            int rowCount = ps.executeUpdate();
            System.out.println("Insert count: " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newTbrBook;
    }

    @Override
    public List<Tbr> getTbrBooksById(Integer bookId) {
        List<Tbr> myTbrBooks = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectTbrBooksById);
            ps.setInt(1,bookId);
            result = ps.executeQuery();
            myTbrBooks = makeTbrBooks(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myTbrBooks;
    }

    @Override
    public Tbr updateTbrBook(Tbr updateTbrBook) {
        List<Tbr> tbrBooks = this.getTbrBooksById(updateTbrBook.getId());

        if(tbrBooks.size() > 0 ){
            PreparedStatement ps = null;
            Connection connection = MariaDbUtil.getConnection();
            try {
                ps = connection.prepareStatement(updateTbrBookById);
                ps.setString(1, updateTbrBook.getTitle());
                ps.setString(2, updateTbrBook.getAuthor());
                ps.setInt(3, updateTbrBook.getReleaseYear());
                ps.setString(4, updateTbrBook.getBookFormat());
                ps.setInt(5, updateTbrBook.getPageCount());
                ps.setString(6, updateTbrBook.getAudioBook());
                ps.setString(7, updateTbrBook.getAgeRating());
                ps.setString(8, updateTbrBook.getSeriesNumber());
                ps.setString(9, updateTbrBook.getKeyword1());
                ps.setString(10, updateTbrBook.getKeyword2());
                ps.setString(11, updateTbrBook.getKeyword3());
                ps.setString(12, updateTbrBook.getHashtag1());
                ps.setString(13, updateTbrBook.getHashtag2());
                ps.setString(14, updateTbrBook.getHashtag3());
                ps.setString(15, updateTbrBook.getHashtag4());
                ps.setString(16, updateTbrBook.getHashtag5());
                ps.setInt(17, updateTbrBook.getRecScore());
                ps.setInt(18, updateTbrBook.getKeywordScore());
                ps.setInt(19, updateTbrBook.getAuthorScore());
                ps.setInt(20, updateTbrBook.getTotalScore());
                ps.setInt(21,updateTbrBook.getId());
                int rowCount = ps.executeUpdate();
                System.out.println("Rows updated: " + rowCount);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateTbrBook;
    }

    @Override
    public Tbr deleteTbrBookById(Integer bookId) {
        List<Tbr> tbrBooks = getTbrBooksById(bookId);
        Tbr tbrBookToDelete = null;

        if (tbrBooks.size() > 0){
            tbrBookToDelete = tbrBooks.get(0);
            int updateRowCount = 0;
            PreparedStatement ps = null;
            Connection connection = MariaDbUtil.getConnection();

            try {
                ps = connection.prepareStatement(deleteTbrBookById);
                ps.setInt(1, bookId);
                int rowCount = ps.executeUpdate();
                System.out.println("Rows Deleted: " + rowCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return tbrBookToDelete;
    }
}
