package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Hashtag;

import java.util.List;

public interface HashtagDao {
    public abstract List<Hashtag> getHashtags();
    public abstract Hashtag updateHashtag(Hashtag updateHashtag);
    public abstract List<Hashtag> getHashtagsById(Integer hashtagId);
}
