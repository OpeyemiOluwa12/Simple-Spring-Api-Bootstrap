package com.opeyemi.simplespringapibootstrap.web;

import com.opeyemi.simplespringapibootstrap.entity.Dog;
import com.opeyemi.simplespringapibootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dog")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogBreedList = dogService.findAll();
        return new ResponseEntity<>(dogBreedList, HttpStatus.OK);
    }

    @GetMapping("/dog/breed")
    public ResponseEntity<List<String>> getDogBreed() {
        List<String> dogBreedList = dogService.retrieveDogBreed();
        return new ResponseEntity<>(dogBreedList, HttpStatus.OK);
    }

    @GetMapping("/dog/name")
    public ResponseEntity<List<String>> getDogName() {
        List<String> dogNameList = dogService.retrieveDogNames();
        return new ResponseEntity<>(dogNameList, HttpStatus.OK);
    }

    @GetMapping("{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id) {
        String dogBreed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(dogBreed, HttpStatus.OK);
    }
}
