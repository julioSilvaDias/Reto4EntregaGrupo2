package spotify.logica;

import java.sql.SQLException;
import java.util.ArrayList;

import spotify.bbdd.gestor.GestorLibre;
import spotify.bbdd.gestor.GestorPremium;
import spotify.bbdd.pojos.Libre;
import spotify.bbdd.pojos.Premium;

public class ControladorPerfil {
	private GestorLibre gestorLibre = new GestorLibre();
	private GestorPremium gestorPremium = new GestorPremium();

	public Libre obtenerUsuario(String login)throws SQLException {
		Libre ret = new Libre();
		ret = gestorLibre.obtenerUsuarioPorLogin(login);

		return ret;
	}

	public boolean isPremium(int id) throws SQLException{
		boolean ret = false;
		ArrayList<Premium> idPremium = gestorPremium.obtener();
		
		for (int i = 0; i < idPremium.size(); i++) {
			if(idPremium.get(i).getIdentificador()==id) {
				ret=true;
				break;
			}else {
				ret=false;
			}
		}

		return ret;
	}

	public void cambiarContrasenia(int identificador, String pass) throws SQLException{
		gestorLibre.cambiarContraseña(identificador, pass);
		
	}

}
