package spotify.bbdd.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import spotify.bbdd.pojos.Podcast;
import spotify.bbdd.utils.Utils;

public class GestorPodcast implements GestorInterfaz<Podcast>{

	@Override
	public void anaidir(Podcast t) {
		
	}

	@Override
	public void borrar(Podcast t) {
		
	}

	@Override
	public void modificar(Podcast t) {
		
	}

	@Override
	public ArrayList<Podcast> obtener() {
		ArrayList<Podcast> ret = new ArrayList<Podcast>();
		String sql = "SELECT * FROM Podcast;";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				Podcast podcast = new Podcast();

				podcast.setId(resultadoConjunto.getInt("id"));
				podcast.setTitulo(resultadoConjunto.getString("tituloCancion"));
				podcast.setNumeroReproduccion(resultadoConjunto.getInt("numReproducciones"));
				podcast.setRuta(resultadoConjunto.getString("ruta"));
				podcast.setCodigoSerie(resultadoConjunto.getInt("codigoSerie"));

				ret.add(podcast);
			}
		} catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarConexionBBDD(conexion, declarar, resultadoConjunto);
		}
		return ret;
	}

	@Override
	public Podcast obtenerById(int id) {
		
		return null;
	}

	public Podcast obtenerPodcast(String tituloPodcast) {
		Podcast ret = null;

		String sql = "SELECT Podcast.id, tituloPodcast, numReproducciones, ruta FROM Podcast "
				+ "where tituloPodcast = ?";

		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, tituloPodcast);

			resultadoConjunto = preparedStatement.executeQuery();

			while (resultadoConjunto.next()) {

				ret = new Podcast();

				ret.setId(resultadoConjunto.getInt("id"));
				ret.setTitulo(resultadoConjunto.getString("tituloPodcast"));
				ret.setNumeroReproduccion(resultadoConjunto.getInt("numReproducciones"));
				ret.setRuta(resultadoConjunto.getString("ruta"));

			}

		} catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO: " + e.getMessage());
		} finally {
			cerrarConexionBBDD(conexion, preparedStatement, resultadoConjunto);
		}

		return ret;
		}
	
	public ArrayList<Podcast> obtenerPodcastPorSerie(String tituloPodcast) {
		ArrayList<Podcast> ret = null;

		String sql = "SELECT Podcast.id, tituloPodcast, numReproducciones, ruta FROM Podcast "
				+ "JOIN Serie ON Serie.id = Podcast.codigoSerie WHERE tituloSerie = ?";

		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, tituloPodcast);

			resultadoConjunto = preparedStatement.executeQuery();
			ret = new ArrayList<Podcast>();
			while (resultadoConjunto.next()) {

				Podcast podcast = new Podcast();

				podcast.setId(resultadoConjunto.getInt("id"));
				podcast.setTitulo(resultadoConjunto.getString("tituloPodcast"));
				podcast.setNumeroReproduccion(resultadoConjunto.getInt("numReproducciones"));
				podcast.setRuta(resultadoConjunto.getString("ruta"));

				ret.add(podcast);

			}

		} catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO: " + e.getMessage());
		} finally {
			cerrarConexionBBDD(conexion, preparedStatement, resultadoConjunto);
		}

		return ret;

	}
	
	private void cerrarConexionBBDD(Connection conexion, Statement declarar, ResultSet resultadoConjunto) {
		if (resultadoConjunto != null) {
			try {
				resultadoConjunto.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if (declarar != null) {
			try {
				declarar.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
