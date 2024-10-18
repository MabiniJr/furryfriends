package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Dog;
import com.entjava.furryfriends.service.DogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public Map<String, Object> getAllCats(Authentication authentication)
    {
        List<Dog> dogs = dogService.findAllDogs();

        Map<String, Object> response = new HashMap<>();
        response.put("user", authentication.getName());
        response.put("dogs", dogs);

        return response;
    }

    @PostMapping
    public Dog createDog(@RequestBody Dog dog) {
        return dogService.saveDog(dog);
    }

    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
    }
}

