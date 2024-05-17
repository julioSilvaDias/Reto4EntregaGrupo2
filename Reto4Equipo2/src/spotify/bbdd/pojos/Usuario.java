package spotify.bbdd.pojos;

import java.util.Date;
import java.util.Objects;

abstract class Usuario {

	Date fechaRegistro;
	String login;
	boolean admin;
	String contrasenia;
	int identificador;
	Date fechaNacimiento;
	Date ultimaSesion;
	String apellido2;
	String apellido1;
	String nombre;
	String dni;
	String direccion;
	String bloqueado;

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getUltimaSesion() {
		return ultimaSesion;
	}

	public void setUltimaSesion(Date ultimaSesion) {
		this.ultimaSesion = ultimaSesion;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(String bloqueado) {
		this.bloqueado = bloqueado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(admin, apellido1, apellido2, bloqueado, contrasenia, direccion, dni, fechaNacimiento,
				fechaRegistro, identificador, login, nombre, ultimaSesion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return admin == other.admin && Objects.equals(apellido1, other.apellido1)
				&& Objects.equals(apellido2, other.apellido2) && bloqueado == other.bloqueado
				&& Objects.equals(contrasenia, other.contrasenia) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(fechaRegistro, other.fechaRegistro) && identificador == other.identificador
				&& Objects.equals(login, other.login) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(ultimaSesion, other.ultimaSesion);
	}

	@Override
	public String toString() {
		return "Usuario [fechaRegistro=" + fechaRegistro + ", login=" + login + ", admin=" + admin + ", contrasenia="
				+ contrasenia + ", identificador=" + identificador + ", fechaNacimiento=" + fechaNacimiento
				+ ", ultimaSesion=" + ultimaSesion + ", apellido2=" + apellido2 + ", apellido1=" + apellido1
				+ ", nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + ", maxIntentos=" + ", bloqueado="
				+ bloqueado + "]";
	}

}
