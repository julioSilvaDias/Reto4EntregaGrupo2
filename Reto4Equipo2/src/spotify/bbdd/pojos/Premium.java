package spotify.bbdd.pojos;

import java.util.Objects;

public class Premium extends Usuario {
	long numeroCuenta;
	String caduca;
	int CVV;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(CVV, caduca, numeroCuenta);
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
		Premium other = (Premium) obj;
		return CVV == other.CVV && Objects.equals(caduca, other.caduca) && numeroCuenta == other.numeroCuenta;
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getCaduca() {
		return caduca;
	}

	public void setCaduca(String caduca) {
		this.caduca = caduca;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	@Override
	public String toString() {
		return "Premium [numeroCuenta=" + numeroCuenta + ", caduca=" + caduca + ", CVV=" + CVV + "]";
	}

}
