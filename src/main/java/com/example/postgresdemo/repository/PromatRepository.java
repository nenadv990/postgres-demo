package com.example.postgresdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postgresdemo.model.Nalmat;
import com.example.postgresdemo.model.Promat;

@Repository
public interface PromatRepository extends JpaRepository<Promat, Long> {

	
}
