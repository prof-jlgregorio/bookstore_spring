package br.com.jlgregorio.bookstore.service;

import br.com.jlgregorio.bookstore.model.GenderModel;
import br.com.jlgregorio.bookstore.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public GenderModel save(GenderModel genderModel){
        return genderRepository.save(genderModel);
    }

    public GenderModel findById(long id) throws Exception {
        return genderRepository.findById(id).orElseThrow(()-> new Exception("Não encontrado!"));
    }

    public List<GenderModel> findAll(){
        return genderRepository.findAll();
    }

    public GenderModel update(GenderModel genderModel) throws Exception {
        Optional<GenderModel> found = genderRepository.findById(genderModel.getId());
        if(found.isPresent()){
            found.get().setDescription(genderModel.getDescription());
            found.get().setName(genderModel.getName());
            return genderRepository.save(found.get());
        } else {
            throw new Exception("Gênero não encontrado!");
        }
    }

    public void delete(long id) throws Exception {
        var genderModel = genderRepository.findById(id).orElseThrow(
                ()-> new Exception("Gênero não encontrado!"));
        genderRepository.delete(genderModel);
    }





}
