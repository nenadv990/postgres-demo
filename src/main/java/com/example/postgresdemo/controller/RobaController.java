package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;

import com.example.postgresdemo.model.GrpRoba;
import com.example.postgresdemo.model.Roba;
import com.example.postgresdemo.repository.RobaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.example.postgresdemo.repository.GrpRobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.example.postgresdemo.repository.GeneratePdfReport;;

@RestController
public class RobaController {
	
	@Autowired
    private RobaRepository robaRepository;

    @Autowired
    private GrpRobaRepository grpRobaRepository;
    
	@GetMapping("/roba")
    public List<Roba> getRoba() {
        return robaRepository.findAll();
    }
	
	@PostMapping("/roba")
    public Roba createRoba(@Valid @RequestBody Roba roba) {
		System.out.println("xxx");
		if (robaRepository.existsBysifra(roba.getSifra())) {
			roba.setError("Roba sa tom sifrom vec postoji");
			return roba;
		}
        return robaRepository.save(roba);
    }
	
	@RequestMapping(value="/getpdf", method=RequestMethod.GET,produces = MediaType.APPLICATION_PDF_VALUE )
	public ResponseEntity<InputStreamResource> robaReport() {

        List<Roba> robe = robaRepository.findAll();
        
        for (Roba r : robe) {
        	System.out.println(r.getNazrob());
        }

        ByteArrayInputStream bis = GeneratePdfReport.robaReport(robe);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
	

  
}
