package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="komit")
public class Komit extends AuditModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="text")
	private String nazkom;
	
	@Column(columnDefinition = "text", unique=true)
    private String sifra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazkom() {
		return nazkom;
	}

	public void setNazkom(String nazkom) {
		this.nazkom = nazkom;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	
}