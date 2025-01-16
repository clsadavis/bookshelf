package com.aca.bookshelf.controller;

import com.aca.bookshelf.model.Hashtag;
import com.aca.bookshelf.service.HashtagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/hashtags", produces = "application/json")
@CrossOrigin("*")
public class HashtagController {

    private HashtagService service = new HashtagService();

    @RequestMapping(value = "/hashtags", method = RequestMethod.GET)
    public List<Hashtag> getHashtags(){
        return service.getHashtags();
    }

    @RequestMapping(value = "/{hashtagId}", method = RequestMethod.GET)
    public List<Hashtag> getHashtagById(@PathVariable Integer hashtagId){
        System.out.println("ID: " + hashtagId);
        return service.getHashtagsById(hashtagId);
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    public Hashtag updateHashtag(@RequestBody Hashtag updateHashtag){
        return service.updateHashtag(updateHashtag);
    }

}
