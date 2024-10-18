package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Capybara;
import com.entjava.furryfriends.service.CapybaraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/capybaras")
public class CapybaraController {

    private final CapybaraService capybaraService;

    public CapybaraController(CapybaraService capybaraService) {
        this.capybaraService = capybaraService;
    }

    @GetMapping
    public Map<String, Object> getAllCapybaras(Authentication authentication)
    {
        List<Capybara> capybaras = capybaraService.findAllCapybaras();

        Map<String, Object> response = new HashMap<>();
        response.put("user", authentication.getName());
        response.put("capybaras", capybaras);

        return response;
    }

    @PostMapping
    public Capybara createCapybara(@RequestBody Capybara capybara) {
        Capybara savedCapybara = capybaraService.saveCapybara(capybara);
        return ResponseEntity.ok(savedCapybara).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteCapybara(@PathVariable Long id) {capybaraService.deleteCapybara(id); }
}