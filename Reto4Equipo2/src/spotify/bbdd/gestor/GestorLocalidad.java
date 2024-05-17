package spotify.bbdd.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import spotify.bbdd.pojos.ListaReproduccion;
import spotify.bbdd.pojos.Localidad;
import spotify.bbdd.pojos.Premium;
import spotify.bbdd.utils.Utils;

public class GestorLocalidad implements GestorInterfaz<Localidad> {

	@Override
	public void anaidir(Localidad t) {
		Connection conexion = null;
		PreparedStatement consultaPreparada = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			String sql = "INSERT INTO localidad (codigoPostal, provincia, ciudad) VALUES (?, ?, ?)";
			consultaPreparada = conexion.prepareStatement(sql);
			consultaPreparada.setInt(1, t.getCodigoPostal());
			consultaPreparada.setString(2, t.getProvincia());
			consultaPreparada.setString(3, t.getCiudad());

			consultaPreparada.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (consultaPreparada != null)
					consultaPreparada.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar el PreparedStatement - " + e.getMessage());
			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión - " + e.getMessage());
			}
		}
	}

	@Override
	public void borrar(Localidad localidad) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;
		try {

			Class.forName(Utils.DRIVER);
			connection = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);
			String sql = "delete from localidad where ciudad = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, localidad.getCiudad());
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
	public void modificar(Localidad t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Localidad> obtener() {

		String sql = "select * from localidad";
		ArrayList<Localidad> ret = null;

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		ret = new ArrayList<Localidad>();
		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);

			while (resultadoConjunto.next()) {
				Localidad localidad = new Localidad();
				localidad.setCodigoPostal(resultadoConjunto.getInt("codigoPostal"));
				localidad.setProvincia(resultadoConjunto.getString("provincia"));
				localidad.setCiudad(resultadoConjunto.getString("ciudad"));
				ret.add(localidad);
			}
		} catch (SQLException e) {
			System.out.println("aquiERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
			cerrarConexionBBDD(conexion, declarar, resultadoConjunto);

		}
		return ret;
	}

	@Override
	public Localidad obtenerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modificarLocalidad(Localidad localidad, String ciudad) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName(Utils.DRIVER);
			connection = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			String sql = "update localidad set ciudad= ? where codigoPostal= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ciudad);
			preparedStatement.setInt(2, localidad.getCodigoPostal());
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
