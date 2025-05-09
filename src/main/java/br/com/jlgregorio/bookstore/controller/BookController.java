package br.com.jlgregorio.bookstore.controller;

import br.com.jlgregorio.bookstore.dto.BookDto;
import br.com.jlgregorio.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto){
        var response = bookService.save(bookDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable(name = "id") long id){
        var response = bookService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto){
        var response = bookService.update(bookDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        bookService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll(){
        var response = bookService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
