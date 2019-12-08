package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Komit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KomitRepository extends JpaRepository<Komit, Long> {
    List<Komit> findByid(Long id);
    boolean existsBysifra(String sifra);
}
