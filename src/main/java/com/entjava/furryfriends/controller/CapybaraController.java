package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Capybara;
import com.entjava.furryfriends.service.CapybaraService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/capybaras")
public class CapybaraController {

    private final CapybaraService capybaraService;

    public CapybaraController(CapybaraService capybaraService) {
        this.capybaraService = capybaraService;
    }

    @GetMapping
    public List<Capybara> getAllCapybaras() {
        return capybaraService.findAllCapybaras();
    }

    @PostMapping
    public Capybara createCapybara(@RequestBody Capybara capybara) {
        Capybara savedCapybara = capybaraService.saveCapybara(capybara);
        return ResponseEntity.ok(savedCapybara).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteCapybara(@PathVariable Long id) {capybaraService.deleteCapybara(id); }
}