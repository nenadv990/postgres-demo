package com.example.postgresdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="promat")
public class Promat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "roba_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Roba roba;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "nalmat_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Nalmat nalmat;
	
	@Column(columnDefinition="Decimal(10,2)")
	private Float prodcen;
	
	@Column(columnDefinition="Integer")
	private Integer ulkol;
	
	@Column(columnDefinition="Integer")
	private Integer izkol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Roba getRoba() {
		return roba;
	}

	public void setRoba(Roba roba) {
		this.roba = roba;
	}

	public Nalmat getNalmat() {
		return nalmat;
	}

	public void setNalmat(Nalmat nalmat) {
		this.nalmat = nalmat;
	}

	public Float getProdcen() {
		return prodcen;
	}

	public void setProdcen(Float prodcen) {
		this.prodcen = prodcen;
	}
	
	public Long getNalmatId() {
		return nalmat.getId();
	}

	public Integer getUlkol() {
		return ulkol;
	}

	public void setUlkol(Integer ulkol) {
		this.ulkol = ulkol;
	}

	public Integer getIzkol() {
		return izkol;
	}

	public void setIzkol(Integer izkol) {
		this.izkol = izkol;
	}
	
	

}
