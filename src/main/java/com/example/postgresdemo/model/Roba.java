package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="roba")
public class Roba extends AuditModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="text")
	private String nazrob;
	
	@Column(columnDefinition = "text", unique=true)
    private String sifra;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "grproba_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private GrpRoba grproba;
	
	private String error;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazrob() {
		return nazrob;
	}

	public void setNazrob(String nazrob) {
		this.nazrob = nazrob;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public GrpRoba getGrproba() {
		return grproba;
	}

	public void setGrproba(GrpRoba grproba) {
		this.grproba = grproba;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public Long getGrpRobaId(GrpRoba grproba) {
		return grproba.getId();
	}
	
	public void setGrpRobaId(GrpRoba grproba) {
		this.grproba.setId(grproba.getId());
	}
	
	public String toString() {
		return this.nazrob.toString() + " " + this.getGrproba().getNaziv();
	}

}

	
	
	

