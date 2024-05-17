package spotify.bbdd.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import spotify.bbdd.pojos.Podcaster;
import spotify.bbdd.utils.Utils;

public class GestorPodcaster implements GestorInterfaz<Podcaster>{

	@Override
	public void anaidir(Podcaster t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void borrar(Podcaster t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modificar(Podcaster t) {
		// TODO Auto-generated method stub
	}

	@Override
	public Podcaster obtenerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Podcaster> obtener() {
		ArrayList<Podcaster> ret = null;

		String sql = "select * from Podcaster";

		Connection conexion = null;
		Statement declarar = null;
		ResultSet resultadoConjunto = null;

		try {
			Class.forName(Utils.DRIVER);
			conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

			declarar = conexion.createStatement();
			resultadoConjunto = declarar.executeQuery(sql);
			ret = new ArrayList<Podcaster>();
			while (resultadoConjunto.next()) {

				Podcaster podcaster = new Podcaster();

				podcaster.setId(resultadoConjunto.getInt("id"));
		        podcaster.setNombre(resultadoConjunto.getString("nomPodcaster"));
		        podcaster.setFechaUnion(resultadoConjunto.getDate("fechaUnion"));
		        podcaster.setDescripcion(resultadoConjunto.getString("descripcion"));
		        podcaster.setImagen(resultadoConjunto.getString("imagen"));

				ret.add(podcaster);

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
	
	public ArrayList<Podcaster> obtenerDatosPodcasterPorNombre(String nomPodcaster) {
		ArrayList<Podcaster> ret = null;

		String sql = "select * from Podcaster where nomPodcaster = ?";

		Connection conexion = null;
		PreparedStatement statement = null;
		ResultSet resultadoConjunto = null;

		try {
		    Class.forName(Utils.DRIVER);
		    conexion = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASS);

		    statement = conexion.prepareStatement(sql);
		    statement.setString(1, nomPodcaster);
		    resultadoConjunto = statement.executeQuery();
		    ret = new ArrayList<Podcaster>();
		    while (resultadoConjunto.next()) {
		        Podcaster podcaster = new Podcaster();
		        podcaster.setId(resultadoConjunto.getInt("id"));
		        podcaster.setNombre(resultadoConjunto.getString("nomPodcaster"));
		        podcaster.setFechaUnion(resultadoConjunto.getDate("fechaUnion"));
		        podcaster.setDescripcion(resultadoConjunto.getString("descripcion"));
		        podcaster.setImagen(resultadoConjunto.getString("imagen"));
		        ret.add(podcaster);
		    }
		} catch (SQLException e) {
		    System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("ERROR GENERICO :" + e.getMessage());
		} finally {
		    cerrarConexionBBDD(conexion, statement, resultadoConjunto);
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

