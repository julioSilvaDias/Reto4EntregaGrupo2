package spotify.logica;

import java.sql.SQLException;
import java.util.ArrayList;
import spotify.bbdd.gestor.GestorCancion;
import spotify.bbdd.gestor.GestorDisco;
import spotify.bbdd.gestor.GestorPodcast;
import spotify.bbdd.gestor.GestorSerie;
import spotify.bbdd.pojos.Cancion;
import spotify.bbdd.pojos.Disco;
import spotify.bbdd.pojos.Podcast;
import spotify.bbdd.pojos.Serie;

public class ControladorReproduccion {

	private GestorDisco gestorDisco = new GestorDisco();
	private GestorCancion gestorCancion = new GestorCancion();
	private GestorPodcast gestorPodcast = new GestorPodcast();
	private GestorSerie gestorSerie = new GestorSerie();

	public ArrayList<Cancion> cargarAllCanciones() throws SQLException {
		ArrayList<Cancion> ret = new ArrayList<Cancion>();
		ret = gestorCancion.obtener();
		return ret;
	}

	public ArrayList<Disco> cargarAllDiscos() throws SQLException {
		ArrayList<Disco> ret = new ArrayList<Disco>();
		ret = gestorDisco.obtener();
		return ret;
	}

	public ArrayList<Podcast> cargarAllPodcasts() {
		ArrayList<Podcast> ret = new ArrayList<Podcast>();
		ret = gestorPodcast.obtener();
		return ret;
	}

	public ArrayList<Serie> cargarAllSeries() {
		ArrayList<Serie> ret = new ArrayList<Serie>();
		ret = gestorSerie.obtener();
		return ret;
	}

}
