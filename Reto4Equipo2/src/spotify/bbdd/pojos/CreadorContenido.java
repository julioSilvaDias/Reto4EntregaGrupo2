package spotify.bbdd.pojos;
import java.util.Objects;

abstract class CreadorContenido {
	int id;
	String imagen;
	String nombre;
	String descripcion;
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, imagen, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreadorContenido other = (CreadorContenido) obj;
		return Objects.equals(descripcion, other.descripcion) && id == other.id && imagen == other.imagen
				&& Objects.equals(nombre, other.nombre);
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "CreadorContenido [id=" + id + ", imagen=" + imagen + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}

	
}
