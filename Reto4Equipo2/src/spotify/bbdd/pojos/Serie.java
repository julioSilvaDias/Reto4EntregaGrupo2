package spotify.bbdd.pojos;

import java.sql.Date;
import java.util.Objects;

public class Serie {
	int id;
	Date fechaInicio;
	String tituloSerie;
	String tematica;
	String imagen;
	String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getTituloSerie() {
		return tituloSerie;
	}
	public void setTituloSerie(String tituloSerie) {
		this.tituloSerie = tituloSerie;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, fechaInicio, id, imagen, tematica, tituloSerie);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(fechaInicio, other.fechaInicio)
				&& id == other.id && Objects.equals(imagen, other.imagen) && Objects.equals(tematica, other.tematica)
				&& Objects.equals(tituloSerie, other.tituloSerie);
	}
	@Override
	public String toString() {
		return "Serie [id=" + id + ", fechaInicio=" + fechaInicio + ", tituloSerie=" + tituloSerie + ", tematica="
				+ tematica + ", imagen=" + imagen + ", descripcion=" + descripcion + "]";
	}

	
}