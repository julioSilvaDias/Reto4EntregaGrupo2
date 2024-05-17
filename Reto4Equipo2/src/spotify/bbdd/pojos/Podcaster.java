package spotify.bbdd.pojos;

import java.sql.Date;
import java.util.Objects;

public class Podcaster extends CreadorContenido{
	Date fechaUnion;

	public Date getFechaUnion() {
		return fechaUnion;
	}

	public void setFechaUnion(Date fechaUnion) {
		this.fechaUnion = fechaUnion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fechaUnion);
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
		Podcaster other = (Podcaster) obj;
		return Objects.equals(fechaUnion, other.fechaUnion);
	}

	@Override
	public String toString() {
		return "Podcaster [fechaUnion=" + fechaUnion + "]";
	}
	
	
}
