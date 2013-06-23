package com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools;

public class EtatImmobilier {
	
	public enum Etat{
		DISPONIBLE, OPTION, COMPROMIS_SIGNE, VENDU
	}
	
	public Etat toEtatImmbilier(String etatString){
		for( Etat etat : EtatImmobilier.Etat.values()){
			if(etat.toString().equalsIgnoreCase(etatString.trim())){
				return etat;
			}
		}
		/*
		for(int i = 0; i < EtatImmobilier.Etat.values().length; i++){
			if(EtatImmobilier.Etat.values()[i].toString().equals(etatString.trim())){
				return EtatImmobilier.Etat.values()[i];
			}
		}
		*/
		return null;
	}
}
