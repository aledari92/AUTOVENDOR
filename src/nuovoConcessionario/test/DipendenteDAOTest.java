package nuovoConcessionario.test;

import java.util.Collection;

import nuovoConcessionario.dao.DipendenteDAO;
import nuovoConcessionario.db.ConcessionarioException;
import nuovoConcessionario.model.Dipendente;

public class DipendenteDAOTest {

	public static void main(String[] args) throws ConcessionarioException {
		
		DipendenteDAO dao = new DipendenteDAO();
//		Dipendente d = new Dipendente("Luka", "Doncic", "A33", "P");
//		dao.create(d);
//		d = new Dipendente("Boban", "Marjanovic", "A15", "C");
//		dao.create(d);
//		d = new Dipendente("TJ", "McConnell", "A13", "D");
//		dao.create(d);
//		d = new Dipendente("Gordon", "Hayward", "G33", "A");
//		dao.create(d);
		
//		Collection<Dipendente> dipList = dao.findAll();
//		for(Dipendente dip:dipList) {
//			System.out.println(dip);
//		}
//		
//		Dipendente dip = dao.findById(10L);
//		System.out.println(dip);
		
//		dao.remove(13L);
//		dao.remove(dao.findById(14L));
//		dao.remove(new Dipendente(15L, null,null, null, null));
		Dipendente dip = dao.findById(16L);
		dip.setNome("Befana");
		dip.setCognome("Re Magio");
		dip.setMatricola("A01");
		dip.setRuolo("N");
		dao.update(dip);
	}
	
}
