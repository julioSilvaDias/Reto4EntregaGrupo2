package spotify.bbdd.pojos;

import java.util.Objects;

public class Localidad {
	String Provincia;
	String Ciudad;
	int codigoPostal;
	@Override
	public String toString() {
		return "Localidad [Provincia=" + Provincia + ", Ciudad=" + Ciudad + ", codigoPostal=" + codigoPostal + "]";
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Ciudad, Provincia, codigoPostal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidad other = (Localidad) obj;
		return Objects.equals(Ciudad, other.Ciudad) && Objects.equals(Provincia, other.Provincia)
				&& codigoPostal == other.codigoPostal;
	}
}
