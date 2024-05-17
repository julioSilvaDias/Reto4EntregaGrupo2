package spotify.bbdd.pojos;

import java.util.Objects;

public class Podcast extends Audio {
	
	private int codigoSerie;

	public int getCodigoSerie() {
		return codigoSerie;
	}

	public void setCodigoSerie(int codigoSerie) {
		this.codigoSerie = codigoSerie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codigoSerie);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Podcast other = (Podcast) obj;
		return codigoSerie == other.codigoSerie;
	}

	@Override
	public String toString() {
		return "Podcast [codigoSerie=" + codigoSerie + ", id=" + id + ", numeroReproduccion=" + numeroReproduccion
				+ ", duraccion=" + duraccion + ", titulo=" + titulo + ", ruta=" + ruta + ", getCodigoSerie()="
				+ getCodigoSerie() + ", hashCode()=" + hashCode() + ", getId()=" + getId()
				+ ", getNumeroReproduccion()=" + getNumeroReproduccion() + ", getDuraccion()=" + getDuraccion()
				+ ", getTitulo()=" + getTitulo() + ", getRuta()=" + getRuta() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
	
	
	
	
}
