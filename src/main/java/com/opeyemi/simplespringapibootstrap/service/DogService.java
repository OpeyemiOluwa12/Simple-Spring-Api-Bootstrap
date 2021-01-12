package com.opeyemi.simplespringapibootstrap.service;

import com.opeyemi.simplespringapibootstrap.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DogService {

    List<String> retrieveDogBreed();

    String retrieveDogBreedById(long id);

    List<String> retrieveDogNames();

    List<Dog> findAll();
}
