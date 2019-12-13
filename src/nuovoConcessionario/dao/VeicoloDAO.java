package nuovoConcessionario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import nuovoConcessionario.db.ConcessionarioException;
import nuovoConcessionario.db.ConnectionFactory;
import nuovoConcessionario.model.Dipendente;
import nuovoConcessionario.model.Veicolo;

public class VeicoloDAO implements Dao<Veicolo> {
	
	private static final String insertQuery =
			"insert into veicoli (tipo, targa, produttore,prezzo, "
			+ "modello, alimentazione, colore, altezzasedile, numeroporte)"
			+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String FindAllQuery = 
			"select id,tipo,targa,produttore,prezzo,"
			+ "modello, alimentazione, colore, "
			+ "altezzasedile,numeroporte from veicoli";
	private static final String FindByIDQuery = 
			"select id,tipo,targa,produttore,prezzo,"
			+ "modello, alimentazione, colore, "
			+ "altezzasedile,numeroporte from veicoli "
			+ "where id=?";
	private static final String DeleteByIDQuery = 
			"delete from veicoli where id = ?";
	
	private static final String UpdateQuery = 
			"update veicoli set targa=?, produttore=?, prezzo=?,"
			+"modello=?, alimentazione=?, colore=?, "
			+ "altezzasedile=?, numeroporte=? where id=?";

	@Override
	public Veicolo create(Veicolo t) throws ConcessionarioException {
		return null;
	}

	@Override
	public Collection<Veicolo> findAll() throws ConcessionarioException {
		return null;
	}

	@Override
	public Veicolo findById(Long id) throws ConcessionarioException {
		return null;
	}

	@Override
	public int remove(Long id) throws ConcessionarioException {
		return 0;
	}

	@Override
	public int remove(Veicolo t) throws ConcessionarioException {
		return 0;
	}

	@Override
	public int update(Veicolo t) throws ConcessionarioException {
		return 0;
	}

	private Veicolo creaVeicolo(ResultSet rs) {
		return null;
		
	}
	
}