package com.Immob.Entites;

import java.math.BigDecimal;

import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatImmobilier;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.TypeImmobilier;

public class Immobilier {
	private int id;
	private String reference;
	private EtatImmobilier.Etat etat;
	private TypeImmobilier.Type type;
	private BigDecimal prix;
	private String description;
	private Boolean visible;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public EtatImmobilier.Etat getEtat() {
		return etat;
	}
	public void setEtat(EtatImmobilier.Etat etat) {
		this.etat = etat;
	}
	public TypeImmobilier.Type getType() {
		return type;
	}
	public void setType(TypeImmobilier.Type type) {
		this.type = type;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean isVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
}
