package spotify.logica;

import java.util.ArrayList;

import spotify.bbdd.gestor.GestorPodcast;
import spotify.bbdd.gestor.GestorPodcaster;
import spotify.bbdd.gestor.GestorSerie;

import spotify.bbdd.pojos.Podcast;
import spotify.bbdd.pojos.Podcaster;
import spotify.bbdd.pojos.Serie;

public class ControladorPodcast {
	GestorPodcaster gestorPodcaster = new GestorPodcaster();
	GestorSerie gestorSerie = new GestorSerie();

	public ArrayList<Podcaster> cargarPodcaster() {

		ArrayList<Podcaster> ret = gestorPodcaster.obtener();

		return ret;
	}

	public ArrayList<Podcaster> cargarDatosPodcaster(String nomPodcaster) {

		ArrayList<Podcaster> ret = new ArrayList<Podcaster>();
		ret = gestorPodcaster.obtenerDatosPodcasterPorNombre(nomPodcaster);

		return ret;
	}

	public ArrayList<Serie> cargarSeries(String tituloSerie) {
		ArrayList<Serie> ret = new ArrayList<Serie>();
		ret = gestorSerie.obtenerSeriesPorPodcaster(tituloSerie);

		return ret;
	}

	public ArrayList<Serie> cargarDatosSerie(String tituloSerie) {
		ArrayList<Serie> ret = new ArrayList<Serie>();
		ret = gestorSerie.obtenerDatosSerie(tituloSerie);

		return ret;
	}

	public ArrayList<Podcast> cargarPodcast(String tituloPodcast) {
		GestorPodcast gestorPodcast = new GestorPodcast();
		ArrayList<Podcast> ret = gestorPodcast.obtenerPodcastPorSerie(tituloPodcast);

		return ret;
	}

}
