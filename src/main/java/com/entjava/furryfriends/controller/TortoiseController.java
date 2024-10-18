package com.entjava.furryfriends.controller;


import com.entjava.furryfriends.model.Tortoise;
import com.entjava.furryfriends.service.TortoiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tortoises")
public class TortoiseController {

    private final TortoiseService tortoiseService;

    public TortoiseController(TortoiseService tortoiseService) {
        this.tortoiseService = tortoiseService;
    }

    @GetMapping
    public Map<String, Object> getAllTortoises(Authentication authentication)
    {
        List<Tortoise> tortoises = tortoiseService.findAllTortoises();

        Map<String, Object> response = new HashMap<>();
        response.put("user", authentication.getName());
        response.put("tortoises", tortoises);

        return response;
    }

    @PostMapping
    public Tortoise createTortoise(@RequestBody Tortoise tortoise) {
        Tortoise savedTortoise = tortoiseService.saveTortoise(tortoise);
        return ResponseEntity.ok(savedTortoise).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteTortoise(@PathVariable Long id) {tortoiseService.deleteTortoise(id); }
}