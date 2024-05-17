package spotify.bbdd.pojos;

import java.util.Objects;

abstract class Audio{
	int id;
	int numeroReproduccion;
	double duraccion;
	String titulo;
	String ruta;
	@Override
	public int hashCode() {
		return Objects.hash(duraccion, id, numeroReproduccion, ruta, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return Double.doubleToLongBits(duraccion) == Double.doubleToLongBits(other.duraccion) && id == other.id
				&& numeroReproduccion == other.numeroReproduccion && Objects.equals(ruta, other.ruta)
				&& Objects.equals(titulo, other.titulo);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroReproduccion() {
		return numeroReproduccion;
	}
	public void setNumeroReproduccion(int numeroReproduccion) {
		this.numeroReproduccion = numeroReproduccion;
	}
	public double getDuraccion() {
		return duraccion;
	}
	public void setDuraccion(double duraccion) {
		this.duraccion = duraccion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	@Override
	public String toString() {
		return "Audio [id=" + id + ", numeroReproduccion=" + numeroReproduccion + ", duraccion=" + duraccion
				+ ", titulo=" + titulo + ", ruta=" + ruta + "]";
	}
	
}
