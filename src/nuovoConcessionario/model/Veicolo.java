package nuovoConcessionario.model;

import java.io.Serializable;

public abstract class Veicolo implements Serializable {
	
	private Long id;
	private String targa;
	private String produttore;
	private String modello;
	private String alimentazione;
	private String colore;
	private Double prezzo;
	private Integer numeroPorte;
	
	public Veicolo(String targa, String produttore, String modello, String alimentazione, String colore,
			Double prezzo) {
		this.targa = targa;
		this.produttore = produttore;
		this.modello = modello;
		this.alimentazione = alimentazione;
		this.colore = colore;
		this.prezzo = prezzo;
	}
	
	public Veicolo(Long id, String targa, String produttore, String modello, String alimentazione, String colore,
			Double prezzo) {
		this(targa,produttore,modello,alimentazione,colore,prezzo);
		this.id = id;
	}

	public Veicolo() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getProduttore() {
		return produttore;
	}

	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public abstract String getTipo();

	public Integer getAltezzaSedile() {
		return null;
	}
	
	public Integer getNumeroPorte() {
		return null;
	}

	

}
