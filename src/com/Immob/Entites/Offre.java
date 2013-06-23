package com.Immob.Entites;

import java.math.BigDecimal;
import java.util.Date;

import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatOffre;

public class Offre {
	private int id;
	private String immobReference;
	private BigDecimal montant;
	private String nomAcheteur;
	private Date validite;
	private EtatOffre.Etat etat;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImmobReference() {
		return immobReference;
	}
	public void setImmobReference(String immobReference) {
		this.immobReference = immobReference;
	}
	public BigDecimal getMontant() {
		return montant;
	}
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
	public String getNomAcheteur() {
		return nomAcheteur;
	}
	public void setNomAcheteur(String nomAcheteur) {
		this.nomAcheteur = nomAcheteur;
	}
	public Date getValidite() {
		return validite;
	}
	public void setValidite(Date validite) {
		this.validite = validite;
	}
	public EtatOffre.Etat getEtat() {
		return etat;
	}
	public void setEtat(EtatOffre.Etat etat) {
		this.etat = etat;
	}
	
}
