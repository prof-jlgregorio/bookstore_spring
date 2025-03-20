package br.com.jlgregorio.bookstore.controller;

import br.com.jlgregorio.bookstore.model.GenderModel;
import br.com.jlgregorio.bookstore.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping("/")
    public ResponseEntity<List<GenderModel>> findAll(){
        var genders = genderService.findAll();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderModel> findById(@PathVariable(name = "id") long id)
            throws Exception {
        var gender = genderService.findById(id);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<GenderModel> save(@RequestBody GenderModel genderModel){
        var created = genderService.save(genderModel);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<GenderModel> update(@RequestBody GenderModel genderModel) throws Exception {
        var updated = genderService.update(genderModel);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") long id) throws Exception {
        genderService.delete(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }






}
