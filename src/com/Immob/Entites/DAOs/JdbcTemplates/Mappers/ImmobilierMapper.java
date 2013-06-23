package com.Immob.Entites.DAOs.JdbcTemplates.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Immob.Entites.Immobilier;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatImmobilier;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.TypeImmobilier;

public class ImmobilierMapper implements RowMapper<Immobilier>{

	@Override
	
	public Immobilier mapRow(ResultSet rs, int rowNum) throws SQLException {
		Immobilier immobilier = new Immobilier();
		immobilier.setId(rs.getInt("immob_id"));
		immobilier.setReference(rs.getString("reference"));
		immobilier.setEtat(new EtatImmobilier().toEtatImmbilier(rs.getString("etat")));
		immobilier.setType(new TypeImmobilier().toTypeImmobilier(rs.getString("type")));
		immobilier.setPrix(rs.getBigDecimal("prix"));
		immobilier.setDescription(rs.getString("description"));
		immobilier.setVisible(rs.getBoolean("visible"));
		return immobilier;
	}
}
