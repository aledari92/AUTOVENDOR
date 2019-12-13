package nuovoConcessionario.model;

public class Moto extends Veicolo {

	@Override
	public String toString() {
		return "Moto "+super.toString()+ " [altezzaSedile=" + altezzaSedile + "]";
	}

	private Integer altezzaSedile;
	
	public Moto(String targa, String produttore, String modello, 
			String alimentazione, String colore, Double prezzo,
			String tipo, Integer altezzaSedile) {
		super(targa, produttore,prezzo, modello, alimentazione, colore);
		this.altezzaSedile = altezzaSedile;
		
	}

	public Moto(Long id, String targa, String produttore, String modello, String alimentazione, String colore,
			Double prezzo) {
		super(id, targa, produttore, modello, alimentazione, colore, prezzo);
	}

	public Moto() {}

	@Override
	public String getTipo() {
		return "M";
	}

	public Integer getAltezzaSedile() {
		return altezzaSedile;
	}

	public void setAltezzaSedile(Integer altezzaSedile) {
		this.altezzaSedile = altezzaSedile;
	}

}
