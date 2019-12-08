package com.example.postgresdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postgresdemo.model.Mag;

@Repository
public interface MagRepository extends JpaRepository<Mag, Long> {
    List<Mag> findByid(Long id);
    boolean existsBysifra(String sifra);
}
