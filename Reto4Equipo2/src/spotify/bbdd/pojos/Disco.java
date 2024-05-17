package spotify.bbdd.pojos;


import java.sql.Date;
import java.util.Objects;

public class Disco {
	int id;
	String imagen;
	String titulo;
	Date fechaPublicacion;
	String descripcion;
	String genero;
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, fechaPublicacion, genero, id, imagen, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disco other = (Disco) obj;
		return Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(fechaPublicacion, other.fechaPublicacion) && Objects.equals(genero, other.genero)
				&& id == other.id && Objects.equals(imagen, other.imagen) && Objects.equals(titulo, other.titulo);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Disco [id=" + id + ", imagen=" + imagen + ", titulo=" + titulo + ", fechaPublicacion="
				+ fechaPublicacion + ", descripcion=" + descripcion + ", genero=" + genero + "]";
	}

	
	
}
