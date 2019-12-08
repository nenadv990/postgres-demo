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
@Table(name="nalmat")
public class Nalmat extends AuditModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="text")
	private String nazdok;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "mag_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Mag mag;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "komit_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Komit komit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazdok() {
		return nazdok;
	}

	public void setNazdok(String nazdok) {
		this.nazdok = nazdok;
	}

	public Mag getMag() {
		return mag;
	}

	public void setMag(Mag mag) {
		this.mag = mag;
	}

	public Komit getKomit() {
		return komit;
	}

	public void setKomit(Komit komit) {
		this.komit = komit;
	}
	

	
	public Long getKomitId() {
		return komit.getId();
	}
	
	public Long getMagId() {
		return mag.getId();
	}
}
