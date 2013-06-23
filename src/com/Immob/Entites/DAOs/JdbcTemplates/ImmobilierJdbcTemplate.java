package com.Immob.Entites.DAOs.JdbcTemplates;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.Immob.Entites.Immobilier;
import com.Immob.Entites.Offre;
import com.Immob.Entites.DAOs.ImmobilierDAO;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.ImmobilierMapper;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatImmobilier.Etat;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.TypeImmobilier.Type;

public class ImmobilierJdbcTemplate implements ImmobilierDAO {

    public DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
	this.dataSource = ds;
	this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(Immobilier immobilier) {
	String query = "INSERT INTO immobilier (reference, etat, type, prix, description, visible)"
		+ " VALUES (?,?,?,?,?,?)";
	try {
	    jdbcTemplate.update(query, new Object[] {
		    immobilier.getReference(), immobilier.getEtat().toString(),
		    immobilier.getType().toString(), immobilier.getPrix(),
		    immobilier.getDescription(), immobilier.isVisible() });
	} catch (DataAccessException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public Immobilier getImmobilierParID(int id) {
	String query = "SELECT * FROM immobilier WHERE immob_id = ?";
	try {
	    return jdbcTemplate.queryForObject(query, new Object[] { id },
		    new ImmobilierMapper());
	} catch (DataAccessException e) {
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    public Immobilier getImmobilierParRef(String reference) {
	String query = "SELECT * FROM immobilier WHERE reference = ?";
	try {
	    return jdbcTemplate.queryForObject(query,
		    new Object[] { reference }, new ImmobilierMapper());
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return null;
	}
	// return null;
    }

    @Override
    public List<Immobilier> getAllImmobilier() {
	String query = "SELECT * FROM immobilier";
	try {
	    return jdbcTemplate.query(query, new ImmobilierMapper());
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return null;
	}
	// return null;
    }

    @Override
    public List<Immobilier> getImmobilierParPrixMinimum(BigDecimal prix) {
	String query = "SELECT * FROM immobilier WHERE prix >= ?";
	try {
	    List<Immobilier> immobs = jdbcTemplate.query(query,
		    new Object[] { prix }, new ImmobilierMapper());
	    return immobs;
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return null;
	}
	// return null;
    }

    @Override
    public List<Immobilier> getImmobilierParPrixMaximum(BigDecimal prix) {
	String query = "SELECT * FROM immobilier WHERE prix <= ?";
	try {
	    List<Immobilier> immobs = jdbcTemplate.query(query,
		    new Object[] { prix }, new ImmobilierMapper());
	    return immobs;
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return null;
	}
	// return null;
    }

    public Immobilier getImmobilierParOffre(Offre offre) {
	return getImmobilierParRef(offre.getImmobReference());
    }

    @Override
    public Boolean updateImmobilier(Immobilier immobilier) {
	String query = "UPDATE immobilier SET reference = ?, "
		+ "etat = ?, type = ?, prix = ?, description = ?, "
		+ "visible = ? WHERE immob_id = ?";
	try {
	    int affected = jdbcTemplate.update(query,
		    immobilier.getReference(), immobilier.getEtat().toString(),
		    immobilier.getType().toString(), immobilier.getPrix(),
		    immobilier.getDescription(), immobilier.isVisible(),
		    immobilier.getId());
	    return affected == 1 ? true : false;
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return false;
	}
    }

    @Override
    public Boolean deleteImmobilier(Immobilier immobilier) {
	String query = "DELETE FROM immobilier WHERE immob_id = ?";
	try {
	    int affected = jdbcTemplate.update(query, immobilier.getId());
	    return affected == 1 ? true : false;
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return false;
	}
    }

    @Override
    public List<Immobilier> getImmobilierParType(Type type) {
	String query = "SELECT * FROM immobilier WHERE type = ?";
	try {
	    List<Immobilier> immobs = jdbcTemplate.query(query,
		    new Object[] { type.toString() }, new ImmobilierMapper());
	    return immobs;
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return null;
	}
	// return null;
    }

    @Override
    public List<Immobilier> getImmobilierParEtat(Etat etat) {
	String query = "SELECT * FROM immobilier WHERE etat = ?";
	try {
	    List<Immobilier> immobs = jdbcTemplate.query(query,
		    new Object[] { etat.toString() }, new ImmobilierMapper());
	    return immobs;
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return null;
	}
	// return null;
    }

    @Override
    public List<Immobilier> getImmobilierParVisibilite(Boolean visible) {
	String query = "SELECT * FROM immobilier WHERE visible = ?";
	try {
	    List<Immobilier> immobs = jdbcTemplate.query(query,
		    new Object[] { visible }, new ImmobilierMapper());
	    return immobs;
	} catch (DataAccessException e) {
	    // e.printStackTrace();
	    return null;
	}
	// return null;
    }

}
