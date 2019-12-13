package nuovoConcessionario.original;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import nuovoConcessionario.model.Dipendente;
import nuovoConcessionario.dao.DipendenteDAO;
import nuovoConcessionario.db.ConcessionarioException;

public class Main {

	static Scanner input = new Scanner(System.in);
	static Long id = null;
	static DipendenteDAO dao = new DipendenteDAO(); 
	
	public static void main(String[] args) throws ConcessionarioException {

		System.out.println("******BENVENUTO NELLA NOSTRA CONCESSIONARIA !!!! ******");
		System.out.println("\nSei un cliente o un Dipendente?\n1. Cliente\n2.Dipendente\n");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			//cliente();
			break;
		case 2:

			descrivi();

			break;
		default:
			System.out.println("Scelta errata: la preghiamo di inserire una delle due scelte possibili !");
		}
	}

	public static void descrivi() throws ConcessionarioException {

		System.out.println("Inserisci ID: ");

		id = input.nextLong();
		Dipendente dip;
		dip = dao.findById(id);

		if (dip.getRuolo().equals("A")) {
			String uscita = "n";
			while (uscita.equals("n") || uscita.equals("N")) {
				System.out
						.println("Benvenuto " + dip.getNome() + " " + dip.getCognome() + ":\nSei un amministratore !");
				System.out.println(
						"\n1. Visualizza Veicoli\n2.Visualizza Dipendenti\n3.Modifica Veicoli\n4.Modifica Personale");
				int scelta = 0;
				scelta = input.nextInt();
				switch (scelta) {
				case 1:
//					Collection<Veicolo> veicoli = tableV.get();
//					for (Veicolo v : veicoli) {
//						v.descrivi();
//					}
					break;
				case 2:
					Collection<Dipendente> dipendenti = dao.findAll();
					for (Dipendente d : dipendenti) {
//						if (!d.getRuolo().equals("A"))
							System.out.println(d.toString());
					}

					break;
				case 3:
					//modificaVeicoli();
					break;
				case 4:
					modificaPersonale();
					break;
				default:
					System.out.println("SELEZIONA UNA DELLE 4 POSSIBILITA'");
					break;
				}

				System.out.println("\nVuoi uscire dal menu? [Y/N]");
				uscita = input.next();
			}

		}

	}

//	public static void modificaVeicoli() {
//		String uscita = "n";
//		while (uscita.equals("n") || uscita.equals("N")) {
//			System.out.println("\n1.Inserisci nuovo veicolo\n2.Elimina veicolo (venduto)");
//			int scelta = 0;
//			scelta = input.nextInt();
//			switch (scelta) {
//			case 1:
//				System.out.println("Che tipo di veicolo vuoi inserire?");
//				String choice = input.next();
//				switch (choice) {
//				case "auto":
//					System.out.println("Inserisci Targa: ");
//					String targa = input.next();
//					System.out.println("Inserisci produttore: ");
//					String produttore = input.next();
//					System.out.println("Inserisci modello: ");
//					String modello = input.next();
//					System.out.println("Inserisci alimentazione: ");
//					String alimentazione = input.next();
//					System.out.println("Inserisci colore: ");
//					String colore = input.next();
//					System.out.println("Inserisci prezzo: ");
//					Double prezzo = input.nextDouble();
//					System.out.println("Inserisci numero portiere: ");
//					Integer numeroPorte = input.nextInt();
//					tableV.insert(new Auto(targa, produttore, modello, alimentazione, colore, prezzo, numeroPorte));
//					break;
//				case "Auto":
//					System.out.println("Inserisci Targa: ");
//					targa = input.next();
//					System.out.println("Inserisci produttore: ");
//					produttore = input.next();
//					System.out.println("Inserisci modello: ");
//					modello = input.next();
//					System.out.println("Inserisci alimentazione: ");
//					alimentazione = input.next();
//					System.out.println("Inserisci colore: ");
//					colore = input.next();
//					System.out.println("Inserisci prezzo: ");
//					prezzo = input.nextDouble();
//					System.out.println("Inserisci numero portiere: ");
//					numeroPorte = input.nextInt();
//					tableV.insert(new Auto(targa, produttore, modello, alimentazione, colore, prezzo, numeroPorte));
//					break;
//				case "moto":
//					System.out.println("Inserisci Targa: ");
//					targa = input.next();
//					System.out.println("Inserisci produttore: ");
//					produttore = input.next();
//					System.out.println("Inserisci modello: ");
//					modello = input.next();
//					System.out.println("Inserisci alimentazione: ");
//					alimentazione = input.next();
//					System.out.println("Inserisci colore: ");
//					colore = input.next();
//					System.out.println("Inserisci prezzo: ");
//					prezzo = input.nextDouble();
//					System.out.println("Inserisci altezza sedile: ");
//					Double altezzaSedile = input.nextDouble();
//					tableV.insert(new Moto(targa, produttore, modello, alimentazione, colore, prezzo, altezzaSedile));
//					break;
//				case "Moto":
//					System.out.println("Inserisci Targa: ");
//					targa = input.next();
//					System.out.println("Inserisci produttore: ");
//					produttore = input.next();
//					System.out.println("Inserisci modello: ");
//					modello = input.next();
//					System.out.println("Inserisci alimentazione: ");
//					alimentazione = input.next();
//					System.out.println("Inserisci colore: ");
//					colore = input.next();
//					System.out.println("Inserisci prezzo: ");
//					prezzo = input.nextDouble();
//					System.out.println("Inserisci numero portiere: ");
//					altezzaSedile = input.nextDouble();
//					tableV.insert(new Moto(targa, produttore, modello, alimentazione, colore, prezzo, altezzaSedile));
//					break;
//				default:
//					System.out.println("SELEZIONA UNA DELLE 2 POSSIBILITA'");
//				}
//
//				break;
//			case 2:
//				System.out.println("Inserisci la targa del veicolo che vuoi eliminare: ");
//				String targa = input.next();
//				Boolean finder = tableV.delete(targa);
//				if (finder == false) {
//					System.out.println("Il veicolo non esiste!");
//				} else
//					System.out.println("Il veicolo è stato eliminato!");
//				break;
//			default:
//				System.out.println("SELEZIONA UNA DELLE 4 POSSIBILITA'");
//				break;
//			}
//
//			System.out.println("Hai finito di modificare veicoli? [Y/N]");
//			uscita = input.next();
//
//		}
//	}

	public static void modificaPersonale() throws ConcessionarioException {
		System.out.println("\n1.Inserisci nuovo dipendente\n2.Elimina dipendente\n3.Aggiorna Dipendenti");
		int scelta = 0;
		scelta = input.nextInt();
		switch (scelta) {
		case 1:
			System.out.println("Inserisci nome: ");
			String nome = input.next();
			System.out.println("Inserisci cognome: ");
			String cognome = input.next();
			System.out.println("Inserisci grado (amministratore/dipendente): ");
			String grado = input.next();
			System.out.println("Inserisci Matricola: ");
			String matricola = input.next();
			dao.create(new Dipendente(nome, cognome, matricola, grado));
			break;
		case 2:
			System.out.println("Inserisci la ID del dipendente che vuoi eliminare: ");
			Long id = input.nextLong();
			dao.remove(id);
			break;
		case 3:
			update();
			break;
		default:
			System.out.println("SELEZIONA UNA DELLE 4 POSSIBILITA'");
			break;

		}

	}

	public static void update() throws ConcessionarioException {
		String nome = null;
		String cognome = null;
		Boolean degree = null;
		String grado = null;
		String matricola = null;
		String choice;
		Boolean b = false;
		System.out.println("Inserisci l'id del dipendente che vuoi modificare");
		Long id = input.nextLong();
		Dipendente dip = dao.findById(id);

		do {
			System.out.println("Cosa desideri modificare? (nome/cognome/grado)\nPer uscire digitare esci ");
			choice = input.next();
			switch (choice) {
			case ("nome"):
				System.out.println("Inserisci il nuovo nome: ");
				nome = input.next();
				dip.setNome(nome);
				break;
			case ("cognome"):
				System.out.println("Inserisci il nuovo cognome: ");
				cognome = input.next();
				dip.setCognome(cognome);
				break;
			case ("matricola"):
				System.out.println("Inserisci la nuovo matricola: ");
				matricola = input.next();
				dip.setMatricola(matricola);
				break;
			case ("grado"):
				System.out.println("Inserisci il nuovo grado: ");
				grado = input.next();
				dip.setRuolo(grado);
				break;
			default:
				System.out.println("SELEZIONA UNA DELLE POSSIBILITA'");
				break;
			}

		} while (!choice.equals("esci"));

		dao.update(dip);

	}

//	public static void cliente() {
//		System.out.println("1. Visualizza veicoli");
//		int choice = 0;
//		choice = input.nextInt();
//		switch (choice) {
//		case 1:
//			Collection<Veicolo> veicoli = tableV.get();
//			for (Veicolo v : veicoli) {
//				v.descrivi();
//			}
//			break;
//		default:
//			System.out.println("SCEGLI UNA DELLE SELEZIONI POSSIBILI !!!");
//			break;
//		}
//
//	}

}
