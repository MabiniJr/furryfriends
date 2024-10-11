package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Capybara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapybaraRepository extends JpaRepository<Capybara, Long> {
    // Add custom query methods specific to Dog
}

