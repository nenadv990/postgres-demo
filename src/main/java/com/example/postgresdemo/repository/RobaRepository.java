package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Roba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {
    List<Roba> findByid(Long id);
    boolean existsBysifra(String sifra);
}