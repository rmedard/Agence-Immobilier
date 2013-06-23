package com.Immob.Entites.DAOs.JdbcTemplates.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Immob.Entites.Offre;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatOffre;

public class OffreMapper implements RowMapper<Offre>{

	@Override
	public Offre mapRow(ResultSet rs, int rowNum) throws SQLException {
		Offre offre = new Offre();
		offre.setId(rs.getInt("offre_id"));
		offre.setImmobReference(rs.getString("immmob_ref"));
		offre.setMontant(rs.getBigDecimal("montant"));
		offre.setNomAcheteur(rs.getString("nom_acheteur"));
		offre.setValidite(rs.getDate("date_validite"));
		offre.setEtat(new EtatOffre().toEtatOffre(rs.getString("etat")));
		return offre;
	}

}
