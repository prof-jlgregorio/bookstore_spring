package br.com.jlgregorio.bookstore.service;

import br.com.jlgregorio.bookstore.model.GenderModel;
import br.com.jlgregorio.bookstore.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




}
