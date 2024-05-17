package spotify.logica;

import spotify.bbdd.gestor.GestorLibre;
import spotify.bbdd.pojos.Libre;

public class ControladorInicioSesion {

	final int MAX_INTENTOS = 3;
	int intentos = 0;

	public String comprobarInicioSesion(String login, String contrasenia) throws NullPointerException {
		String ret = null;

		GestorLibre gestorLibre = new GestorLibre();
		Libre usuarioLibre = gestorLibre.obtenerUsuarioLibrePorLoginContrasena(login, contrasenia);

		if (null == usuarioLibre) {
			System.out.print("El usuario " + login + " no existe en BBDD");
		} else {
			
			if (usuarioLibre.getLogin().equalsIgnoreCase(login) && usuarioLibre.getContrasenia().equals(contrasenia)) {
				usuarioLibre.setUltimaSesion(null);
			} else if (usuarioLibre.getLogin().equalsIgnoreCase(login)) {
				ret = "La contraseña no coincide con el usuario, intentalo nuevamente";
			} else {
				intentos++;
				ret = "Contraseña incorrecta, al tercer intento quedarás bloqueado";
			}

			if (intentos >= MAX_INTENTOS) {
				usuarioLibre.isBloqueado();
			}

		}
		return ret;
	}

	public void iniciarSesion(String login, String contrasenia) {

	}

}
