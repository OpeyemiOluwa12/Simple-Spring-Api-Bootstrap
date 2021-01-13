package com.opeyemi.simplespringapibootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.opeyemi.simplespringapibootstrap.entity.Dog;
import com.opeyemi.simplespringapibootstrap.repository.DogRepository;
import com.opeyemi.simplespringapibootstrap.service.BreedNotFoundException;
import com.opeyemi.simplespringapibootstrap.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog newDog(String breed, String name, String origin) {
        Dog dog = new Dog(name, breed, origin);
        dogRepository.save(dog);
        return dog;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> dogs = dogRepository.findAll();
        for (Dog dog : dogs) {
            if (dog.getBreed().equals(breed)) {
                dogRepository.delete(dog);
                deleted = true;
            }
        }
        if(!deleted){
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return true;
    }

    public Dog updateDogName(String name, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
