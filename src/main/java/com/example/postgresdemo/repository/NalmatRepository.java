package com.example.postgresdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postgresdemo.model.Nalmat;
import com.example.postgresdemo.model.Roba;

@Repository
public interface NalmatRepository extends JpaRepository<Nalmat, Long> {
	List<Nalmat> findByid(Long id);
}
