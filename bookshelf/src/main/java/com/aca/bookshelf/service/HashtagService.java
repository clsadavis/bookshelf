package com.aca.bookshelf.service;

import com.aca.bookshelf.dao.HashtagDao;
import com.aca.bookshelf.dao.HashtagDaoImpl;
import com.aca.bookshelf.model.Hashtag;

import java.util.List;

public class HashtagService {
    private HashtagDao hashtagDao = new HashtagDaoImpl();

    public List<Hashtag> getHashtags(){
        return hashtagDao.getHashtags();
    }

    public List<Hashtag> getHashtagsById(Integer hashtagId){
        return hashtagDao.getHashtagsById(hashtagId);
    }

    public Hashtag updateHashtag(Hashtag updateHashtag){
        return hashtagDao.updateHashtag(updateHashtag);
    }
}
