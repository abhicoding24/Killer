package com.api.repository;

import com.api.entity.Killer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KillerRepository extends JpaRepository<Killer, Long> {
}