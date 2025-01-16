package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Book;
import com.aca.bookshelf.model.Hashtag;

import java.util.ArrayList;
import java.util.List;

public class HashtagDaoMock implements HashtagDao{
    private static List<Hashtag> hashtags = new ArrayList<Hashtag>();
    private static Integer lastHashtagId = 0;

    private static Integer getNextHashtagId(){
        lastHashtagId++;
        return lastHashtagId;
    }

    @Override
    public List<Hashtag> getHashtags() {
        List<Hashtag> myHashtags = new ArrayList<Hashtag>();
        myHashtags.addAll(hashtags);
        return myHashtags;
    }

    @Override
    public Hashtag updateHashtag(Hashtag updateHashtag) {
        for (Hashtag hashtag : hashtags) {
            if (hashtag.getHashtagId().intValue() == updateHashtag.getHashtagId().intValue()) {
                hashtag.setHashtagName(updateHashtag.getHashtagName());
                hashtag.setDescription(updateHashtag.getDescription());
                break;
            }
        }
        return updateHashtag;
    }

    @Override
    public List<Hashtag> getHashtagsById(Integer hashtagId){
        List<Hashtag> myHashtags = new ArrayList<Hashtag>();
        for(Hashtag hashtag : HashtagDaoMock.hashtags){
            if(hashtag.getHashtagId().intValue() == hashtagId.intValue()){
                myHashtags.add(hashtag);
            }
        }
        return myHashtags;
    }
}
