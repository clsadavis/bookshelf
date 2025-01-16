package com.aca.bookshelf.controller;

import com.aca.bookshelf.model.Tbr;
import com.aca.bookshelf.service.TbrService;
import com.aca.bookshelf.model.BookException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "api/tbr", produces = "application/json")
@CrossOrigin("*")
public class TbrController {

    private TbrService service = new TbrService();

    @RequestMapping(method = RequestMethod.GET,
            produces = "application/json")
    public List<Tbr> getTbrBooks(){
        return service.getTbrBooks();
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.POST)
    public Tbr createTbrBook(@RequestBody Tbr newTbrBook) throws BookException {
        System.out.println(newTbrBook.toString());
        return service.createTbrBook(newTbrBook);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public List<Tbr> getTbrBookById(@PathVariable Integer bookId){
        System.out.println("ID: " + bookId);
        return service.getTbrBooksById(bookId);
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    public Tbr updateTbrBook(@RequestBody Tbr updateTbrBook) {
        return service.updateTbrBook(updateTbrBook);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public Tbr deleteTbrBookById(@PathVariable Integer bookId){
        return service.deleteTbrBookById(bookId);
    }

}
