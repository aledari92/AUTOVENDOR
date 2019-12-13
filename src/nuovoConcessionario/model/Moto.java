package nuovoConcessionario.model;

public class Moto extends Veicolo {

	private Integer altezzaSedile;
	
	public Moto(String targa, String produttore, String modello, 
			String alimentazione, String colore, Double prezzo,
			String tipo, String altezzaSedile) {
		super(targa, produttore, modello, alimentazione, colore, prezzo);
		
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

	@Override
	public Integer getAltezzaSedile() {
		return altezzaSedile;
	}

	public void setAltezzaSedile(Integer altezzaSedile) {
		this.altezzaSedile = altezzaSedile;
	}

}
