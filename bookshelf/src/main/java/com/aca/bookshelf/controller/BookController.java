package com.aca.bookshelf.controller;

import com.aca.bookshelf.model.Book;
import com.aca.bookshelf.service.BookService;
import com.aca.bookshelf.model.BookException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "api/books", produces = "application/json")
@CrossOrigin("*")
public class BookController {

    private BookService service = new BookService();

    @RequestMapping(method = RequestMethod.GET,
                produces = "application/json")
    public List<Book> getBooks(){
        return service.getBooks();
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book newBook) throws BookException {
        System.out.println(newBook.toString());
        return service.createBook(newBook);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public List<Book> getBookById(@PathVariable Integer bookId){
        System.out.println("ID: " + bookId);
        return service.getBooksById(bookId);
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book updateBook) {
        return service.updateBook(updateBook);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public Book deleteBookById(@PathVariable Integer bookId){
        return service.deleteBookById(bookId);
    }

}
