package com.Immob.Entites.DAOs.JdbcTemplates;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Immob.Entites.Offre;
import com.Immob.Entites.DAOs.OffreDAO;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.OffreMapper;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatOffre;

public class OffreJdbcTemplate implements OffreDAO {

	public DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public void create(Offre offre) {
		String query = "INSERT INTO offre (immob_ref, montant, nom_acheteur, date_validite, etat) VALUES (?,?,?,?,?)";
		try {
			jdbcTemplate.update(
					query,
					new Object[] { offre.getImmobReference(),
							offre.getMontant(), offre.getNomAcheteur(),
							offre.getValidite(), offre.getEtat() });
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Offre getOffreParID(int id) {
		String query = "SELECT * FROM offre WHERE offre_id = ?";
		try {
			return jdbcTemplate.queryForObject(query, new Object[] { id },
					new OffreMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Offre> getAllOffre() {
		String query = "SELECT * FROM offre";
		try {
			return jdbcTemplate.query(query, new OffreMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			System.out.println("Dore aho byapfiriye: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Offre> getOffreParImmobRef(String ImmobRef) {
		String query = "SELECT * FROM offre WHERE immob_ref = ?";
		try {
			List<Offre> offres = jdbcTemplate.query(query,
					new Object[] { ImmobRef }, new OffreMapper());
			return offres;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Offre> getOffreParEtat(EtatOffre etat) {
		String query = "SELECT * FROM offre WHERE etat = ?";
		try {
			List<Offre> offres = jdbcTemplate.query(query,
					new Object[] { etat }, new OffreMapper());
			return offres;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Offre> getOffreParNomAcheteur(String nom) {
		String query = "SELECT * FROM offre WHERE nom_acheteur = ?";
		try {
			List<Offre> offres = jdbcTemplate.query(query,
					new Object[] { nom }, new OffreMapper());
			return offres;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Boolean updateOffre(Offre offre) {
		String query = "UPDATE offre SET immob_ref = ?, montant = ?, nom_acheteur = ?, date_validite = ?, etat = ? VALUES (?,?,?,?,?)";
		try {
			int affectedRow = jdbcTemplate.update(
					query,
					new Object[] { offre.getImmobReference(),
							offre.getMontant(), offre.getNomAcheteur(),
							offre.getValidite(), offre.getEtat() });
			return affectedRow == 1 ? true : false; 
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Boolean deleteOffre(Offre offre) {
		String query = "DELETE FROM offre WHERE id = ?";
		try {
			int affectedRow = jdbcTemplate.update(query, new Object[]{offre.getId()});
			return affectedRow == 1 ? true : false;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

}
