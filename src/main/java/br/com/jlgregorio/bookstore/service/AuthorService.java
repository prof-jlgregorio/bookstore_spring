package br.com.jlgregorio.bookstore.service;

import br.com.jlgregorio.bookstore.dto.AuthorDto;
import br.com.jlgregorio.bookstore.exception.ResourceNotFoundException;
import br.com.jlgregorio.bookstore.mapper.CustomModelMapper;
import br.com.jlgregorio.bookstore.model.AuthorModel;
import br.com.jlgregorio.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDto create(AuthorDto authorDto){
        AuthorModel authorModel = CustomModelMapper.parseObject(authorDto, AuthorModel.class);
        return CustomModelMapper.parseObject(authorRepository.save(authorModel), AuthorDto.class);
    }

    public AuthorDto findById(long id){
        AuthorModel authorModel = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado!"));
        return CustomModelMapper.parseObject(authorModel, AuthorDto.class);
    }

    public List<AuthorDto> findAll(){
        var authorList = authorRepository.findAll();
        return CustomModelMapper.parseObjectList(authorList, AuthorDto.class);
    }

    public AuthorDto update(AuthorDto authorDto){
        var author = authorRepository.findById(authorDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado!"));
        author.setName(authorDto.getName());
        author.setCountry(authorDto.getCountry());
        return CustomModelMapper.parseObject(authorRepository.save(author), AuthorDto.class);
    }

    public void delete(long id){
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado!"));
        authorRepository.delete(author);
    }

}
