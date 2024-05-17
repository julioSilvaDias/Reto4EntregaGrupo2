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
import spotify.bbdd.pojos.Grupo;
import spotify.bbdd.pojos.Libre;
import spotify.bbdd.utils.Utils;

public class GestorDisco implements GestorInterfaz<Disco> {

	@Override
	public void anaidir(Disco disco) {

	}

	@Override
	public void borrar(Disco disco) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;
		try {

			Class.forName(Utils.DRIVER);
			connection = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			String sql = "delete from disco where tituloDisco = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, disco.getTitulo());
			preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
	}

	@Override
	public void modificar(Disco t) {
		// TODO Auto-generated method stub
	}

	public void modificarDisco(Disco disco, String tituloDisco) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName(Utils.DRIVER);
			connection = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			String sql = "update disco set pass= ? where id= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, disco.getTitulo());
			preparedStatement.setInt(2, disco.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());

		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
	}

	@Override
	public ArrayList<Disco> obtener() throws SQLException {
		ArrayList<Disco> ret = new ArrayList<Disco>();
		String sql = "SELECT * FROM disco;";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				Disco disco = new Disco();

				disco.setTitulo(resultadoConjunto.getString("tituloDisco"));
				disco.setFechaPublicacion(resultadoConjunto.getDate("fechaPublicacion"));
				disco.setImagen(resultadoConjunto.getString("imagen"));
				disco.setDescripcion(resultadoConjunto.getString("descripcion"));
				disco.setGenero(resultadoConjunto.getString("genero"));
				disco.setId(resultadoConjunto.getInt("id"));

				ret.add(disco);
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
	public Disco obtenerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Disco> obtenerDiscosPorGrupo(String nombre) throws SQLException {
		ArrayList<Disco> ret = null;

		String sql = "SELECT tituloDisco, fechaPublicacion, Disco.imagen, Disco.descripcion, genero FROM disco "
				+ "JOIN grupo ON disco.codigoGrupo = grupo.id WHERE nomGrupo = ?";

		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, nombre);

			resultadoConjunto = preparedStatement.executeQuery();
			ret = new ArrayList<Disco>();
			while (resultadoConjunto.next()) {

				Disco disco = new Disco();

				disco.setTitulo(resultadoConjunto.getString("tituloDisco"));
				disco.setFechaPublicacion(resultadoConjunto.getDate("fechaPublicacion"));
				disco.setImagen(resultadoConjunto.getString("imagen"));
				disco.setDescripcion(resultadoConjunto.getString("descripcion"));
				disco.setGenero(resultadoConjunto.getString("genero"));

				ret.add(disco);

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

	public ArrayList<Disco> obtenerDatosDisco(String nombreDisco) throws SQLException {
		ArrayList<Disco> ret = null;

		String sql = "SELECT * FROM disco WHERE tituloDisco = ?";

		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, nombreDisco);

			resultadoConjunto = preparedStatement.executeQuery();
			ret = new ArrayList<Disco>();
			while (resultadoConjunto.next()) {

				Disco disco = new Disco();

				disco.setTitulo(resultadoConjunto.getString("tituloDisco"));
				disco.setFechaPublicacion(resultadoConjunto.getDate("fechaPublicacion"));
				disco.setImagen(resultadoConjunto.getString("imagen"));
				disco.setDescripcion(resultadoConjunto.getString("descripcion"));
				disco.setGenero(resultadoConjunto.getString("genero"));

				ret.add(disco);

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
