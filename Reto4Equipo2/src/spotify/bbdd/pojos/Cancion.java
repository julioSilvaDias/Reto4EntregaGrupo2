package spotify.bbdd.pojos;

import java.util.Objects;

public class Cancion extends Audio{
	private int codidogoDisco;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codidogoDisco);
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
		Cancion other = (Cancion) obj;
		return codidogoDisco == other.codidogoDisco;
	}

	public int getCodidogoDisco() {
		return codidogoDisco;
	}

	public void setCodidogoDisco(int codidogoDisco) {
		this.codidogoDisco = codidogoDisco;
	}

	@Override
	public String toString() {
		return "Cancion [codidogoDisco=" + codidogoDisco + "]";
	}
	
	
}
