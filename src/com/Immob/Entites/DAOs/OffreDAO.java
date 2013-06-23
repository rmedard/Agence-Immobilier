package com.Immob.Entites.DAOs;

import java.util.List;

import javax.sql.DataSource;

import com.Immob.Entites.Offre;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatOffre;

public interface OffreDAO {
	public void setDataSource(DataSource ds);
	public void create(Offre offre);
	public Offre getOffreParID(int id);
	public List<Offre> getAllOffre();
	public List<Offre> getOffreParImmobRef(String ImmobRef);
	public List<Offre> getOffreParEtat(EtatOffre etat);
	public List<Offre> getOffreParNomAcheteur(String nom);
	public Boolean updateOffre(Offre offre);
	public Boolean deleteOffre(Offre offre);
}
