package com.example.postgresdemo.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.model.Roba;
import com.example.postgresdemo.model.Nalmat;
import com.example.postgresdemo.model.Komit;
import com.example.postgresdemo.model.Mag;
import com.example.postgresdemo.repository.GeneratePdfReport1;
import com.example.postgresdemo.repository.KomitRepository;
import com.example.postgresdemo.repository.MagRepository;
import com.example.postgresdemo.repository.NalmatRepository;;

@RestController
public class NalmatController {
	
	@Autowired
    private KomitRepository komitRepository;
	
	@Autowired
    private MagRepository magRepository;
	
	@Autowired
    private NalmatRepository nalmatRepository;
	
	@RequestMapping(value="/nalmat/getpdf/{nalmatId}", method=RequestMethod.GET,produces = MediaType.APPLICATION_PDF_VALUE )
	public ResponseEntity<InputStreamResource> robaReport(@PathVariable Long nalmatId) {

        List<Nalmat> nalmat1 = nalmatRepository.findByid(nalmatId);
        
        
        List<Komit> komit1 = komitRepository.findByid(nalmat1.get(0).getKomitId());
        
        List<Mag> mag1 = magRepository.findByid(nalmat1.get(0).getMagId());
        
        
        //System.out.println(nalmat1.get().getNazdok());
        
        ByteArrayInputStream bis = GeneratePdfReport1.robaReport(nalmat1.get(0), komit1.get(0), mag1.get(0));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
