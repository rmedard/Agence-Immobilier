package com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools;

public class EtatOffre {
	
	public enum Etat{
		SOUMISE, REFUSE, ACCEPTE
	}
	
	public Etat toEtatOffre(String etatString){
		for(Etat etat : EtatOffre.Etat.values()){
			if(etat.toString().equalsIgnoreCase(etatString.trim())){
				return etat;
			}
		}
		return null;
	}
}
