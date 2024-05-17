package spotify.bbdd.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import spotify.bbdd.pojos.Serie;
import spotify.bbdd.utils.Utils;

public class GestorSerie implements GestorInterfaz <Serie>{

	@Override
	public void anaidir(Serie t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Serie> obtener() {
		ArrayList<Serie> ret = new ArrayList<Serie>();
		String sql = "SELECT * FROM Serie;";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				Serie serie = new Serie();

				serie.setId(resultadoConjunto.getInt("id"));
				serie.setFechaInicio(resultadoConjunto.getDate("fechaInicio"));
				serie.setTituloSerie(resultadoConjunto.getString("tituloSerie"));
				serie.setTematica(resultadoConjunto.getString("tematica"));
				serie.setImagen(resultadoConjunto.getString("imagen"));
				serie.setDescripcion(resultadoConjunto.getString("descripcion"));

				ret.add(serie);
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

	public Serie obtenerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Serie> obtenerSeriesPorPodcaster(String tituloSerie) {
	    ArrayList<Serie> series = new ArrayList<>();
	    String sql = "SELECT tituloSerie, Serie.imagen, Serie.descripcion FROM Serie "
	                + "JOIN Podcaster ON Serie.codigoPodcaster = Podcaster.id WHERE Podcaster.nomPodcaster = ?";

	    try (Connection conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
	         PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

	        preparedStatement.setString(1, tituloSerie);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                Serie serie = new Serie();
	                serie.setTituloSerie(resultSet.getString("tituloSerie"));
	                serie.setImagen(resultSet.getString("imagen"));
	                serie.setDescripcion(resultSet.getString("descripcion"));
	                series.add(serie);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("ERROR GENERICO: " + e.getMessage());
	    }

	    return series;
	}
	
	public ArrayList<Serie> obtenerDatosSerie(String tituloSerie) {
		ArrayList<Serie> ret = null;

		String sql = "SELECT * FROM Serie WHERE tituloSerie = ?";

		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultadoConjunto = null;

		try {
		    Class.forName(Utils.DRIVER);
		    conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

		    preparedStatement = conexion.prepareStatement(sql);
		    preparedStatement.setString(1, tituloSerie); 

		    resultadoConjunto = preparedStatement.executeQuery();
		    ret = new ArrayList<Serie>();
		    while (resultadoConjunto.next()) {

		    	Serie serie = new Serie();

		    	serie.setTituloSerie(resultadoConjunto.getString("tituloSerie"));
		    	serie.setFechaInicio(resultadoConjunto.getDate("fechaInicio"));
		    	serie.setImagen(resultadoConjunto.getString("imagen"));
		    	serie.setDescripcion(resultadoConjunto.getString("descripcion"));
		    	serie.setTematica(resultadoConjunto.getString("tematica"));

		        ret.add(serie);
		        
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
