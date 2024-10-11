package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Capybara;
import com.entjava.furryfriends.repository.CapybaraRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CapybaraService {
    @Autowired
    private final CapybaraRepository capybaraRepository;

    public CapybaraService(CapybaraRepository capybaraRepository) {
        this.capybaraRepository = capybaraRepository;
    }

    public List<Capybara> findAllCapybaras() {
        return capybaraRepository.findAll();
    }

    public Capybara saveCapybara(Capybara capybara) {
        return capybaraRepository.save(capybara);
    }

    public void deleteCapybara(Long id) {
        if (capybaraRepository.existsById(id)) {
            capybaraRepository.deleteById(id);
        }
    }
}