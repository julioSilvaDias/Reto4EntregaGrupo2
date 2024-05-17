package spotify.bbdd.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import spotify.bbdd.pojos.Localidad;
import spotify.bbdd.pojos.Premium;
import spotify.bbdd.utils.Utils;

public class GestorPremium implements GestorInterfaz<Premium> {

	@Override
	public void anaidir(Premium t) {
		Connection conexion = null;
		Statement declarar = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			declarar = conexion.createStatement();

			String sqlUsuario = "INSERT INTO usuario (DNI, login, fechaRegistro, useradmin, pass, nombre, apellido1,"
					+ " apellido2, fechaNacimieto, direccion) VALUES ('" + t.getDni() + "', '" + t.getLogin()
					+ "', CURRENT_DATE, 'no', '" + t.getContrasenia() + "', '" + t.getNombre() + "', '"
					+ t.getApellido1() + "', '" + t.getApellido2() + "', '" + t.getFechaNacimiento() + "', '"
					+ t.getDireccion() + "')";

			String sqlPremium = "insert into premium (numCuenta, caduca, cvv) " + "values (" + t.getNumeroCuenta()
					+ "', '" + t.getCaduca() + "', '" + t.getCVV() + "')";

			declarar.executeUpdate(sqlUsuario);
			declarar.executeUpdate(sqlPremium);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
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

	@Override
	public void borrar(Premium t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modificar(Premium t) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Premium> obtener() throws SQLException{
		String sql = "select * from Premium";
		ArrayList<Premium> ret = new ArrayList<Premium>();

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				Premium premium = new Premium();

				
				premium.setIdentificador(resultadoConjunto.getInt("id"));

				ret.add(premium);

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

	public Premium obtenerUsuarioPremiumPorLoginContrasena(String login, String contrasenia) {
		String sql = "select * from Usuario where login = '" + login + "' and pass = '" + contrasenia + "'";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		Premium usuarioPremium = new Premium();

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				usuarioPremium.setDni(resultadoConjunto.getString("DNI"));
				usuarioPremium.setLogin(resultadoConjunto.getString("login"));
				usuarioPremium.setUltimaSesion(resultadoConjunto.getTimestamp(sql));
				usuarioPremium.setContrasenia(resultadoConjunto.getString("pass"));
				usuarioPremium.setNombre(resultadoConjunto.getString("nombre"));
				usuarioPremium.setApellido1(resultadoConjunto.getString("apellido1"));
				usuarioPremium.setApellido2(resultadoConjunto.getString("apellido2"));
				usuarioPremium.setFechaNacimiento(resultadoConjunto.getDate("fechaNacimiento"));
				usuarioPremium.setDireccion(resultadoConjunto.getString("direccion"));

			}
		} catch (SQLException e) {
			System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarConexionBBDD(conexion, declarar, resultadoConjunto);

		}
		return usuarioPremium;

	}

	public void anaidirLocalidad(Premium t, Localidad localidad) {
		Connection conexion = null;
		Statement declarar = null;
		PreparedStatement preparedStatementPremium = null;

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

			String sqlPremium = "INSERT INTO premium (numCuenta, caduca, cvv) VALUES (?, ?, ?)";
			preparedStatementPremium = conexion.prepareStatement(sqlPremium);
			preparedStatementPremium.setLong(1, t.getNumeroCuenta());
			preparedStatementPremium.setString(2, t.getCaduca());
			preparedStatementPremium.setInt(3, t.getCVV());
			preparedStatementPremium.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (declarar != null)
					declarar.close();
				if (preparedStatementPremium != null)
					preparedStatementPremium.close();
				if (conexion != null)
					conexion.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexión - " + e.getMessage());
			}
		}
	}

	public Premium obtenerUsuarioPorLogin(String login) {

		String sql = "select * from Usuario where login = '" + login + "'";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		Premium usuario = new Premium();

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
				usuario.setNumeroCuenta(resultadoConjunto.getLong("numeroCuenta"));
				usuario.setCaduca(resultadoConjunto.getString("caduca"));
				usuario.setCVV(resultadoConjunto.getInt("cVV"));

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

	@Override
	public Premium obtenerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void cerrarConexionBBDD(Connection conexion, Statement declarar, ResultSet resultadoConjunto) {
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
