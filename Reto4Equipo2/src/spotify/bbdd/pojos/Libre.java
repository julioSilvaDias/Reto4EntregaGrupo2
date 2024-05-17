package spotify.bbdd.pojos;

import java.sql.Date;

public class Libre extends Usuario{
	
	private Date ultimaReproduccion;

	public Date getUltimaReproduccion() {
		return ultimaReproduccion;
	}

	public void setUltimaReproduccion(Date ultimaReproduccion) {
		this.ultimaReproduccion = ultimaReproduccion;
	}
}
