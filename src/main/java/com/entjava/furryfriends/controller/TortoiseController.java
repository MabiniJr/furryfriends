package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Tortoise;
import com.entjava.furryfriends.service.TortoiseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tortoises")
public class TortoiseController {

    private final TortoiseService tortoiseService;

    public TortoiseController(TortoiseService tortoiseService) {
        this.tortoiseService = tortoiseService;
    }

    @GetMapping
    public List<Tortoise> getAllTortoises() {return tortoiseService.findAllTortoises(); }

    @PostMapping
    public Tortoise createTortoise(@RequestBody Tortoise tortoise) {return tortoiseService.saveTortoise(tortoise); }

    @DeleteMapping("/{id}")
    public void deleteTortoise(@PathVariable Long id) {tortoiseService.deleteTortoise(id); }
}