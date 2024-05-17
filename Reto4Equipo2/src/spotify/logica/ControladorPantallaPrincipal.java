package spotify.logica;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.imageio.ImageIO;

import spotify.bbdd.gestor.GestorDisco;
import spotify.bbdd.gestor.GestorGrupo;
import spotify.bbdd.pojos.Disco;
import spotify.bbdd.pojos.Grupo;

public class ControladorPantallaPrincipal {

	public class ControladorGrupo {
		private ArrayList<Grupo> grupos = null;

		public ArrayList<Disco> cargarAllDiscos() throws SQLException {
			ArrayList<Disco> ret = new ArrayList<Disco>();
			GestorDisco gestorDisco = new GestorDisco();
			ret = gestorDisco.obtener();
			return ret;
		}

	}

	public ArrayList<Disco> cargarAllDiscos() throws SQLException {
		ArrayList<Disco> ret = new ArrayList<Disco>();
		GestorDisco gestorDisco = new GestorDisco();
		ret = gestorDisco.obtener();
		return ret;

	}
}
