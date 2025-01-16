package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Tbr;

import java.util.ArrayList;
import java.util.List;

public class TbrDaoMock implements TbrDao{

    private static List<Tbr> tbrBooks = new ArrayList<Tbr>();

    private static Integer lastTbrBookId = 0;

    private static Integer getNextTbrBookId(){
        lastTbrBookId++;
        return lastTbrBookId;
    }

    @Override
    public List<Tbr> getTbrBooks() {
        List<Tbr> myTbrBooks = new ArrayList<Tbr>();
        myTbrBooks.addAll(tbrBooks);
        return myTbrBooks;
    }

    @Override
    public Tbr insertTbrBook(Tbr newTbrBook){
        newTbrBook.setId(getNextTbrBookId());
        tbrBooks.add(newTbrBook);
        return newTbrBook;
    }

    @Override
    public List<Tbr> getTbrBooksById(Integer bookId) {
        List<Tbr> myTbrBooks = new ArrayList<Tbr>();
        for(Tbr tbr : TbrDaoMock.tbrBooks){
            if (tbr.getId().intValue() == bookId.intValue()){
                myTbrBooks.add(tbr);
            }
        }
        return myTbrBooks;
    }

    @Override
    public Tbr updateTbrBook(Tbr updateTbrBook) {
        for (Tbr tbr : tbrBooks){
            if(tbr.getId().intValue() == updateTbrBook.getId().intValue()){
                tbr.setTitle(updateTbrBook.getTitle());
                tbr.setAuthor(updateTbrBook.getAuthor());
                tbr.setReleaseYear(updateTbrBook.getReleaseYear());
                tbr.setBookFormat(updateTbrBook.getBookFormat());
                tbr.setPageCount(updateTbrBook.getPageCount());
                tbr.setAudioBook(updateTbrBook.getAudioBook());
                tbr.setAgeRating(updateTbrBook.getAgeRating());
                tbr.setSeriesNumber(updateTbrBook.getSeriesNumber());
                tbr.setKeyword1(updateTbrBook.getKeyword1());
                tbr.setKeyword2(updateTbrBook.getKeyword2());
                tbr.setKeyword3(updateTbrBook.getKeyword3());
                tbr.setHashtag1(updateTbrBook.getHashtag1());
                tbr.setHashtag2(updateTbrBook.getHashtag2());
                tbr.setHashtag3(updateTbrBook.getHashtag3());
                tbr.setHashtag4(updateTbrBook.getHashtag4());
                tbr.setHashtag5(updateTbrBook.getHashtag5());
                tbr.setRecScore(updateTbrBook.getRecScore());
                tbr.setKeywordScore(updateTbrBook.getKeywordScore());
                tbr.setAuthorScore(updateTbrBook.getAuthorScore());
                tbr.setTotalScore(updateTbrBook.getTotalScore());
                break;
            }
        }
        return updateTbrBook;
    }

    @Override
    public Tbr deleteTbrBookById(Integer bookId) {
        List<Tbr> books = getTbrBooksById(bookId);
        Tbr tbr = null;

        if(tbrBooks.size() > 0){
            tbr = tbrBooks.get(0);
            TbrDaoMock.tbrBooks.remove(tbr);
        }
        return tbr;
    }

}
