package spotify.bbdd.pojos;

import java.sql.Date;
import java.util.Objects;

public class Grupo extends CreadorContenido{
	Date fechaFormacion;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fechaFormacion);
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
		Grupo other = (Grupo) obj;
		return Objects.equals(fechaFormacion, other.fechaFormacion);
	}

	public Date getFechaFormacion() {
		return fechaFormacion;
	}

	public void setFechaFormacion(Date fechaFormacion) {
		this.fechaFormacion = fechaFormacion;
	}

	@Override
	public String toString() {
		return "Grupo [fechaFormacion=" + fechaFormacion + "]";
	}
	
	
}
