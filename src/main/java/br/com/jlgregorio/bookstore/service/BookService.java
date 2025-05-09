package br.com.jlgregorio.bookstore.service;

import br.com.jlgregorio.bookstore.dto.BookDto;
import br.com.jlgregorio.bookstore.exception.ResourceNotFoundException;
import br.com.jlgregorio.bookstore.mapper.CustomModelMapper;
import br.com.jlgregorio.bookstore.model.AuthorModel;
import br.com.jlgregorio.bookstore.model.BookModel;
import br.com.jlgregorio.bookstore.model.GenderModel;
import br.com.jlgregorio.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDto save(BookDto bookDto){
        var bookModel = CustomModelMapper.parseObject(bookDto, BookModel.class);
        return CustomModelMapper.parseObject(bookRepository.save(bookModel), BookDto.class);
    }

    public BookDto findById(long id){
        var bookModel = bookRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Livro não encontrado!")
        );
        return CustomModelMapper.parseObject(bookModel, BookDto.class);
    }

    public BookDto update(BookDto bookDto){
        var bookModel = bookRepository.findById(bookDto.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Livro não encontrado!")
        );
        bookModel.setName(bookDto.getName());
        bookModel.setYear(bookDto.getYear());
        bookModel.setSummary(bookDto.getSummary());
        //set the objects
        bookModel.setAuthor(CustomModelMapper.parseObject(bookDto.getAuthor(), AuthorModel.class));
        bookModel.setGender(CustomModelMapper.parseObject(bookDto.getGender(), GenderModel.class));
        return CustomModelMapper.parseObject(bookRepository.save(bookModel), BookDto.class);
    }

    public void delete(long id){
        var bookModel = bookRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Livro não encontrado!")
        );
        bookRepository.delete(bookModel);
    }

    public List<BookDto> findAll(){
        List<BookModel> books = bookRepository.findAll();
        return CustomModelMapper.parseObjectList(books, BookDto.class);
    }

}
