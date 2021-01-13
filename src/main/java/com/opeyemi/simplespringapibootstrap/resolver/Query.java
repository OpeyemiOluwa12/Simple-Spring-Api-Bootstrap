package com.opeyemi.simplespringapibootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.opeyemi.simplespringapibootstrap.entity.Dog;
import com.opeyemi.simplespringapibootstrap.repository.DogRepository;
import com.opeyemi.simplespringapibootstrap.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
