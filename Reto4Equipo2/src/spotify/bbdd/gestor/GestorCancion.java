package spotify.bbdd.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import spotify.bbdd.pojos.Cancion;
import spotify.bbdd.pojos.Disco;
import spotify.bbdd.pojos.Libre;
import spotify.bbdd.utils.Utils;

public class GestorCancion implements GestorInterfaz<Cancion> {

	@Override
	public void anaidir(Cancion t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void borrar(Cancion t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modificar(Cancion t) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Cancion> obtener() throws SQLException{
		ArrayList<Cancion> ret = new ArrayList<Cancion>();
		String sql = "SELECT * FROM canciones;";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				Cancion cancion = new Cancion();

				cancion.setId(resultadoConjunto.getInt("id"));
				cancion.setTitulo(resultadoConjunto.getString("tituloCancion"));
				cancion.setNumeroReproduccion(resultadoConjunto.getInt("numReproducciones"));
				cancion.setRuta(resultadoConjunto.getString("ruta"));
				cancion.setCodidogoDisco(resultadoConjunto.getInt("codigoDisco"));

				ret.add(cancion);
			}
		} catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
			throw e;
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarConexionBBDD(conexion, declarar, resultadoConjunto);
		}
		return ret;
	}
	
	@Override
	public Cancion obtenerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cancion obtenerCancion(String nombre) {
		Cancion ret = null;

		String sql = "SELECT canciones.id, tituloCancion, numReproducciones, ruta FROM canciones "
				+ "where tituloCancion = ?";

		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, nombre);

			resultadoConjunto = preparedStatement.executeQuery();

			while (resultadoConjunto.next()) {

				ret = new Cancion();

				ret.setId(resultadoConjunto.getInt("id"));
				ret.setTitulo(resultadoConjunto.getString("tituloCancion"));
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

	public ArrayList<Cancion> obtenerCancionesPorDisco(String nombre) throws SQLException{
		ArrayList<Cancion> ret = null;

		String sql = "SELECT canciones.id, tituloCancion, numReproducciones, ruta FROM canciones "
				+ "JOIN Disco ON disco.id = canciones.codigoDisco WHERE tituloDisco = ?";

		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, nombre);

			resultadoConjunto = preparedStatement.executeQuery();
			ret = new ArrayList<Cancion>();
			while (resultadoConjunto.next()) {

				Cancion cancion = new Cancion();

				cancion.setId(resultadoConjunto.getInt("id"));
				cancion.setTitulo(resultadoConjunto.getString("tituloCancion"));
				cancion.setNumeroReproduccion(resultadoConjunto.getInt("numReproducciones"));
				cancion.setRuta(resultadoConjunto.getString("ruta"));

				ret.add(cancion);

			}

		} catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
			throw e;
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
