package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Tortoise;
import com.entjava.furryfriends.repository.TortoiseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class TortoiseService {
    @Autowired
    private final TortoiseRepository tortoiseRepository;

    public TortoiseService(TortoiseRepository tortoiseRepository) {
        this.tortoiseRepository = tortoiseRepository;
    }

    public List<Tortoise> findAllTortoises() {
        return tortoiseRepository.findAll();
    }

    public Tortoise saveTortoise(Tortoise tortoise) {
        return tortoiseRepository.save(tortoise);
    }

    public void deleteTortoise(Long id) {
        if (tortoiseRepository.existsById(id)) {
            tortoiseRepository.deleteById(id);
        }
    }
}
