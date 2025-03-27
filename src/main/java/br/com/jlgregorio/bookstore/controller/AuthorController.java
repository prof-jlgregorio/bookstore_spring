package br.com.jlgregorio.bookstore.controller;

import br.com.jlgregorio.bookstore.dto.AuthorDto;
import br.com.jlgregorio.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public ResponseEntity<List<AuthorDto>> findAll(){
        var authors = authorService.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> findById(@PathVariable(name = "id") long id){
        var author = authorService.findById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> create(@RequestBody AuthorDto authorDto){
        var author = authorService.create(authorDto);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AuthorDto> update(@RequestBody AuthorDto authorDto){
        var author = authorService.update(authorDto);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable( name = "id") long id){
        authorService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }





}
