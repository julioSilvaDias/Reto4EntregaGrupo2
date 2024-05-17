package spotify.bbdd.pojos;

import java.util.Objects;

public class ListaReproduccion {
	int numeroReproduccion;
	double duraccion;
	String titulo;
	int id;
	@Override
	public int hashCode() {
		return Objects.hash(duraccion, id, numeroReproduccion, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaReproduccion other = (ListaReproduccion) obj;
		return Double.doubleToLongBits(duraccion) == Double.doubleToLongBits(other.duraccion) && id == other.id
				&& numeroReproduccion == other.numeroReproduccion && Objects.equals(titulo, other.titulo);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ListaReproduccion [numeroReproduccion=" + numeroReproduccion + ", duraccion=" + duraccion + ", titulo="
				+ titulo + ", id=" + id + "]";
	}
	
	
}
