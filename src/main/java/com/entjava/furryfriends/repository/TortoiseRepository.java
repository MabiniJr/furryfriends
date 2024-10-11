package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Tortoise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TortoiseRepository extends JpaRepository<Tortoise, Long> {
    // Add custom query methods specific to Dog
}
