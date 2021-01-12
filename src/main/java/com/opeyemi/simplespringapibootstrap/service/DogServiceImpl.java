package com.opeyemi.simplespringapibootstrap.service;

import com.opeyemi.simplespringapibootstrap.entity.Dog;
import com.opeyemi.simplespringapibootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl  implements  DogService{

    @Autowired
    DogRepository dogRepository;


    @Override
    public List<String> retrieveDogBreed() {
        return dogRepository.findDogBreed();
    }

    @Override
    public String retrieveDogBreedById(long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findDogBreedById(id));

        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.findDogName();
    }

    @Override
    public List<Dog> findAll() {
        return (List<Dog>) dogRepository.findAll();
    }
}
