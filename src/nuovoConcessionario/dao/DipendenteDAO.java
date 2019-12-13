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

public class DipendenteDAO implements Dao<Dipendente> {
	
	private static final String insertQuery =
			"insert into dipendenti (nome, cognome, matricola, ruolo)"
			+ " values (?, ?, ?, ?)";
	private static final String FindAllQuery = 
			"select id,nome,cognome,matricola,ruolo from dipendenti";
	private static final String FindByIDQuery = 
			"select id,nome,cognome,matricola,ruolo"+
			" from dipendenti where id = ?";
	private static final String DeleteByIDQuery = 
			"delete from dipendenti where id = ?";
	
	private static final String UpdateQuery = 
			"update dipendenti set nome=?, cognome=?,"
			+"matricola=?, ruolo=? where id=?";

	@Override
	public Dipendente create(Dipendente d) 
			throws ConcessionarioException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			pst = connection.prepareStatement(insertQuery,
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, d.getNome());
			pst.setString(2, d.getCognome());
			pst.setString(3, d.getMatricola());
			pst.setString(4, d.getRuolo());
			int affectedRows = pst.executeUpdate();
			if(affectedRows != 1){
				throw new SQLException("Creazione dipendente fallita");
			}
			generatedKeys = pst.getGeneratedKeys();
			if(generatedKeys.next()) {
				d.setId(generatedKeys.getLong(1));
			}
			else throw new SQLException("Fail: ID non ottenuta");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ConcessionarioException();
		} finally {
			try {generatedKeys.close();} catch (Exception e) {}
			try {pst.close();} catch (Exception e) {}
			try {connection.close();} catch (Exception e) {}
		}
		return d;
	}

	 @Override
	public Collection<Dipendente> findAll() throws ConcessionarioException {
		Connection connection = null;
		PreparedStatement pst = null ;
		ResultSet rs = null;
		Collection<Dipendente> employees = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			pst = connection.prepareStatement(FindAllQuery, 
			ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
			rs = pst.executeQuery();
			while(rs.next()) {
				employees.add(creaDipendente(rs));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ConcessionarioException();
		}finally {
			try {pst.close(); } catch (SQLException e) {}
			try {connection.close();} catch (SQLException e) {}
		}
		return employees;
	}

	 @Override
	public Dipendente findById(Long id) throws ConcessionarioException {
		 Connection connection = null;
		 PreparedStatement pst = null ;
		 ResultSet rs = null;
		 Dipendente dip = null;
		 try {
			 connection = ConnectionFactory.getConnection();
			 pst = connection.prepareStatement(FindByIDQuery, 
	            ResultSet.TYPE_SCROLL_SENSITIVE,
	            ResultSet.CONCUR_READ_ONLY);
			 pst.setLong(1, id);
			 rs = pst.executeQuery();
			 while(rs.next()) {
				 dip = creaDipendente(rs);
			 }
		 }catch (ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
			 throw new ConcessionarioException("ID not found");
		 }finally {
			 try {pst.close(); } catch (SQLException e) {}
			 try {connection.close();} catch (SQLException e) {}
		 }
		 return dip;
	}

	@Override
	public int remove(Long id) throws ConcessionarioException {
		 Connection connection = null;
		 PreparedStatement pst = null ;
		 ResultSet rs = null;
		 int affectedRows = 0;
		 try {
			 connection = ConnectionFactory.getConnection();
			 pst = connection.prepareStatement(DeleteByIDQuery, 
	            ResultSet.TYPE_SCROLL_SENSITIVE,
	            ResultSet.CONCUR_READ_ONLY);
			 pst.setLong(1, id);
			 affectedRows = pst.executeUpdate();
			 if(affectedRows != 1){
					throw new SQLException("Cancellazione dipendente fallita");
			 }
			 
		 }catch (ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
			 throw new ConcessionarioException("ID not found");
		 }finally {
			 try {pst.close(); } catch (SQLException e) {}
			 try {connection.close();} catch (SQLException e) {}
		 }
		 return affectedRows;
	}

	@Override
	public int remove(Dipendente d) throws ConcessionarioException {
		return this.remove(d.getId());
	}

	@Override
	public int update(Dipendente d) throws ConcessionarioException {
		Connection connection = null;
		PreparedStatement pst = null;
		int affectedRows = 0;
		
		try {
			connection = ConnectionFactory.getConnection();
			pst = connection.prepareStatement(UpdateQuery,
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, d.getNome());
			pst.setString(2, d.getCognome());
			pst.setString(3, d.getMatricola());
			pst.setString(4, d.getRuolo());
			pst.setLong(5, d.getId());
			affectedRows = pst.executeUpdate();
			if(affectedRows != 1){
				throw new SQLException();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ConcessionarioException("Update dipendente fallito");
		} finally {
			try {pst.close();} catch (Exception e) {}
			try {connection.close();} catch (Exception e) {}
		}
		return affectedRows;
	}

	private Dipendente creaDipendente(ResultSet rs) 
			throws SQLException {
		  
		  return new Dipendente(rs.getLong(1),
		    rs.getString(2),rs.getString(3),
		    rs.getString(4),rs.getString(5));
		 }

}
