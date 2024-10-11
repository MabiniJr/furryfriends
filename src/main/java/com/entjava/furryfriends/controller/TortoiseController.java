package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Tortoise;
import com.entjava.furryfriends.service.TortoiseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/tortoises")
public class TortoiseController {

    private final TortoiseService tortoiseService;

    public TortoiseController(TortoiseService tortoiseService) {
        this.tortoiseService = tortoiseService;
    }

    @GetMapping
    public List<Tortoise> getAllTortoises() {
        return tortoiseService.findAllTortoises();
    }

    @PostMapping
    public Tortoise createTortoise(@RequestBody Tortoise tortoise) {
        Tortoise savedTortoise = tortoiseService.saveTortoise(tortoise);
        return ResponseEntity.ok(savedTortoise).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteTortoise(@PathVariable Long id) {tortoiseService.deleteTortoise(id); }
}