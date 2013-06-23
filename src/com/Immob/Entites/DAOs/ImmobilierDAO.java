package com.Immob.Entites.DAOs;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import com.Immob.Entites.Immobilier;
import com.Immob.Entites.Offre;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatImmobilier;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.TypeImmobilier;

public interface ImmobilierDAO {
	public void setDataSource(DataSource ds);
	public void create(Immobilier immobilier);
	public Immobilier getImmobilierParID(int id);
	public Immobilier getImmobilierParRef(String reference);
	public List<Immobilier> getAllImmobilier();
	public List<Immobilier> getImmobilierParType(TypeImmobilier.Type type);
	public List<Immobilier> getImmobilierParPrixMinimum(BigDecimal prix);
	public List<Immobilier> getImmobilierParPrixMaximum(BigDecimal prix);
	public List<Immobilier> getImmobilierParEtat(EtatImmobilier.Etat etat);
	public List<Immobilier> getImmobilierParVisibilite(Boolean visible);
	public Immobilier getImmobilierParOffre(Offre offre);
	public Boolean updateImmobilier(Immobilier immobilier);
	public Boolean deleteImmobilier(Immobilier immobilier);
}
