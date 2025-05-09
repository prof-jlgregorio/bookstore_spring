package br.com.jlgregorio.bookstore.service;

import br.com.jlgregorio.bookstore.dto.GenderDto;
import br.com.jlgregorio.bookstore.exception.ResourceNotFoundException;
import br.com.jlgregorio.bookstore.mapper.CustomModelMapper;
import br.com.jlgregorio.bookstore.model.GenderModel;
import br.com.jlgregorio.bookstore.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public GenderDto save(GenderDto genderDto){
        var genderModel = CustomModelMapper.parseObject(genderDto, GenderModel.class);
        return CustomModelMapper.parseObject(genderRepository.save(genderModel), GenderDto.class);
    }

    public GenderDto findById(long id){
        var genderModel = genderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Gênero não encontrado!"));
        return CustomModelMapper.parseObject(genderModel, GenderDto.class);
    }

    public GenderDto update(GenderDto genderDto){
        //first we retrive the model by id of Dto
        var foundGenderModel = genderRepository.findById(genderDto.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Gênero não encontrado!")
        );
        //set the new values
        foundGenderModel.setName(genderDto.getName());
        foundGenderModel.setDescription(genderDto.getDescription());
        //update the model
        return CustomModelMapper.parseObject(genderRepository.save(foundGenderModel),
                GenderDto.class);
    }

    public void delete(long id){
        var foundGenderModel = genderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Gênero não encontrado!"));
        genderRepository.delete(foundGenderModel);
    }

    public List<GenderDto> findAll() {
        List<GenderModel> genders = genderRepository.findAll();
        return CustomModelMapper.parseObjectList(genders, GenderDto.class);
    }


}
