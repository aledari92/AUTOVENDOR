package nuovoConcessionario.model;

public class Auto extends Veicolo {

	public Auto(String targa, String produttore, String modello, String alimentazione, String colore, Double prezzo) {
		super(targa, produttore, modello, alimentazione, colore, prezzo);
	}

	public Auto(Long id, String targa, String produttore, String modello, String alimentazione, String colore,
			Double prezzo) {
		super(id, targa, produttore, modello, alimentazione, colore, prezzo);
	}

	public Auto() {}

	@Override
	public String getTipo() {
		return "A";
	}

}
