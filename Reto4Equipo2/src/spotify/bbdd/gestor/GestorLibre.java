package spotify.bbdd.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import spotify.bbdd.pojos.Libre;
import spotify.bbdd.pojos.Localidad;
import spotify.bbdd.utils.Utils;

public class GestorLibre implements GestorInterfaz<Libre> {

	@Override
	public void anaidir(Libre t) {

	}

	@Override
	public void borrar(Libre t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Libre t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Libre obtenerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Libre> obtener() throws SQLException {
		ArrayList<Libre> ret = new ArrayList<Libre>();
		String sql = "SELECT * FROM usuario;";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				Libre usuario = new Libre();

				usuario.setDni(resultadoConjunto.getString("DNI"));
				usuario.setLogin(resultadoConjunto.getString("login"));
				usuario.setUltimaSesion(resultadoConjunto.getTimestamp("ultimaSesion"));
				usuario.setContrasenia(resultadoConjunto.getString("pass"));
				usuario.setNombre(resultadoConjunto.getString("nombre"));
				usuario.setApellido1(resultadoConjunto.getString("apellido1"));
				usuario.setApellido2(resultadoConjunto.getString("apellido2"));
				usuario.setFechaNacimiento(resultadoConjunto.getDate("fechaNacimieto"));
				usuario.setDireccion(resultadoConjunto.getString("direccion"));
				usuario.setBloqueado(resultadoConjunto.getString("bloqueado"));

				ret.add(usuario);
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

	public Libre obtenerUsuarioLibrePorLoginContrasena(String login, String contrasenia) {

		String sql = "select * from Usuario where login = '" + login + "' and pass = '" + contrasenia + "'";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		Libre usuario = new Libre();

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				usuario.setDni(resultadoConjunto.getString("DNI"));
				usuario.setLogin(resultadoConjunto.getString("login"));
				usuario.setUltimaSesion(resultadoConjunto.getTimestamp("ultimaSesion"));
				usuario.setContrasenia(resultadoConjunto.getString("pass"));
				usuario.setNombre(resultadoConjunto.getString("nombre"));
				usuario.setApellido1(resultadoConjunto.getString("apellido1"));
				usuario.setApellido2(resultadoConjunto.getString("apellido2"));
				usuario.setFechaNacimiento(resultadoConjunto.getDate("fechaNacimieto"));
				usuario.setDireccion(resultadoConjunto.getString("direccion"));
				usuario.setBloqueado(resultadoConjunto.getString("bloqueado"));

			}
		} catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarConexionBBDD(conexion, declarar, resultadoConjunto);

		}
		return usuario;

	}

	public void anaidirUser(Libre t, Localidad localidad) throws SQLException {
		Connection conexion = null;
		Statement declarar = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			declarar = conexion.createStatement();

			String sqlUsuario = "INSERT INTO usuario (DNI, login, fechaRegistro, useradmin, ultimaSesion, pass, nombre, apellido1,"
					+ " apellido2, fechaNacimieto, direccion, codigoPostal) VALUES ('" + t.getDni() + "', '"
					+ t.getLogin() + "', CURRENT_DATE, 'no', current_timestamp, '" + t.getContrasenia() + "', '"
					+ t.getNombre() + "', '" + t.getApellido1() + "', '" + t.getApellido2() + "', '"
					+ t.getFechaNacimiento() + "', '" + t.getDireccion() + "', '" + localidad.getCodigoPostal() + "')";

			declarar.executeUpdate(sqlUsuario);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
			throw sqle;
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (declarar != null)
					declarar.close();
			} catch (Exception e) {

			}
			;
			try {
				if (conexion != null)
					conexion.close();
			} catch (Exception e) {

			}
			;
		}
	}

	public Libre obtenerUsuarioPorLogin(String login)throws SQLException {

		String sql = "select * from Usuario where login = '" + login + "'";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		Libre usuario = new Libre();

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				usuario.setIdentificador(resultadoConjunto.getInt("id"));
				usuario.setDni(resultadoConjunto.getString("DNI"));
				usuario.setLogin(resultadoConjunto.getString("login"));
				usuario.setUltimaSesion(resultadoConjunto.getTimestamp("ultimaSesion"));
				usuario.setContrasenia(resultadoConjunto.getString("pass"));
				usuario.setNombre(resultadoConjunto.getString("nombre"));
				usuario.setApellido1(resultadoConjunto.getString("apellido1"));
				usuario.setApellido2(resultadoConjunto.getString("apellido2"));
				usuario.setFechaNacimiento(resultadoConjunto.getDate("fechaNacimieto"));
				usuario.setDireccion(resultadoConjunto.getString("direccion"));
				usuario.setBloqueado(resultadoConjunto.getString("bloqueado"));

			}
		} catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
			throw e;
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarConexionBBDD(conexion, declarar, resultadoConjunto);

		}
		return usuario;

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

	public void cambiarContraseña(int identificador, String pass) throws SQLException{

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName(Utils.DRIVER);
			connection = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			String sql = "update usuario set pass= ? where id= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pass);
			preparedStatement.setInt(2, identificador);
			preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
			throw sqle;
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

}
