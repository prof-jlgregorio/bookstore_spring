package br.com.jlgregorio.bookstore.controller;

import br.com.jlgregorio.bookstore.dto.AuthorDto;
import br.com.jlgregorio.bookstore.exception.CustomExceptionResponse;
import br.com.jlgregorio.bookstore.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/authors")
@Tag(name = "Authors", description = "Operações relacionadas à entidade Author.")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public ResponseEntity<List<AuthorDto>> findAll(){
        var authors = authorService.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Encontra uma instância da entidade Author mediante um ID", responses = {
            @ApiResponse(description = "O Author existe e foi encontrado.", responseCode = "200", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AuthorDto.class) )
            }),
            @ApiResponse(description = "O Author com o ID informado não existe.", responseCode = "404",
                content = {@Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema( implementation = CustomExceptionResponse.class)
                )})
                })
    public ResponseEntity<AuthorDto> findById(@PathVariable(name = "id") long id){
        var author = authorService.findById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cria um recurso Author no banco de dados", responses = {
            @ApiResponse(description = "Um novo Author é cadastrado.", responseCode = "201",
                    content = @Content(
                            mediaType =  MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AuthorDto.class)
                    )
            ),
            @ApiResponse(description = "Requisição inválida. Verifique os dados enviados", responseCode = "400",
                content = { @Content }
            )
    })
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
