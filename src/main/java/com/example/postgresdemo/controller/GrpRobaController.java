package com.example.postgresdemo.controller;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.GrpRoba;
import com.example.postgresdemo.repository.GrpRobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class GrpRobaController {
	
	@Autowired
	private GrpRobaRepository grpRobaRepository;
	
	@GetMapping("/grproba")
    public List<GrpRoba> getGrpRoba() {
		System.out.println("XXX");
        return grpRobaRepository.findAll();
    }
	 
}
