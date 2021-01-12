package com.opeyemi.simplespringapibootstrap.repository;

import com.opeyemi.simplespringapibootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query(value = "SELECT d.id, d.breed from Dog d ", nativeQuery = true)
    List<String> findDogBreed();

    @Query(value = "SELECT d.id, d.breed from Dog d where id = :id ", nativeQuery = true)
    String findDogBreedById(@Param("id") long id);

    @Query(value = "SELECT d.id, d.name from Dog d ", nativeQuery = true)
    List<String> findDogName();

}
