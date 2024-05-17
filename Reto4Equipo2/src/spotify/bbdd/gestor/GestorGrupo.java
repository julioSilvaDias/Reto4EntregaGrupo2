package spotify.bbdd.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import spotify.bbdd.pojos.Grupo;
import spotify.bbdd.pojos.Libre;
import spotify.bbdd.utils.Utils;

public class GestorGrupo implements GestorInterfaz<Grupo> {

	public void anadir(Grupo t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void borrar(Grupo t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modificar(Grupo t) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Grupo> obtener() throws SQLException{
		ArrayList<Grupo> ret = null;

		String sql = "select * from Grupo";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);
			ret = new ArrayList<Grupo>();
			while (resultadoConjunto.next()) {

				Grupo grupo = new Grupo();

				grupo.setId(resultadoConjunto.getInt("id"));
				grupo.setFechaFormacion(resultadoConjunto.getDate("fechaFormacion"));
				grupo.setNombre(resultadoConjunto.getString("nomGrupo"));
				grupo.setImagen(resultadoConjunto.getString("imagen"));
				grupo.setDescripcion(resultadoConjunto.getString("descripcion"));

				ret.add(grupo);

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
	public Grupo obtenerById(int id) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void anaidir(Grupo t) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Grupo> obtenerDatosGrupoPorNombre(String nombre) throws SQLException{
		ArrayList<Grupo> ret = null;

		String sql = "select * from Grupo where nomGrupo = ?";

		Connection conexion = null;
		PreparedStatement statement = null;
		ResultSet resultadoConjunto = null;

		try {
		    Class.forName(Utils.DRIVER);
		    conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

		    statement = conexion.prepareStatement(sql);
		    statement.setString(1, nombre);
		    resultadoConjunto = statement.executeQuery();
		    ret = new ArrayList<Grupo>();
		    while (resultadoConjunto.next()) {
		        Grupo grupo = new Grupo();
		        grupo.setId(resultadoConjunto.getInt("id"));
		        grupo.setFechaFormacion(resultadoConjunto.getDate("fechaFormacion"));
		        grupo.setNombre(resultadoConjunto.getString("nomGrupo"));
		        grupo.setImagen(resultadoConjunto.getString("imagen"));
		        grupo.setDescripcion(resultadoConjunto.getString("descripcion"));
		        ret.add(grupo);
		    }
		} catch (SQLException e) {
		    System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		    throw e;
		} catch (Exception e) {
		    System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
		    cerrarConexionBBDD(conexion, statement, resultadoConjunto);
		}

		return ret;

	}

}
