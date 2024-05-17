package spotify.logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import spotify.bbdd.gestor.GestorCancion;
import spotify.bbdd.gestor.GestorDisco;
import spotify.bbdd.gestor.GestorGrupo;
import spotify.bbdd.pojos.Cancion;
import spotify.bbdd.pojos.Disco;
import spotify.bbdd.pojos.Grupo;

public class ControladorGrupo {
	GestorGrupo gestorGrupo = new GestorGrupo();
	GestorDisco gestorDisco = new GestorDisco();

	public ArrayList<Grupo> cargarGrupos() throws SQLException{
		
		ArrayList<Grupo> ret = gestorGrupo.obtener();

		return ret;
	}
	
	public ArrayList<Grupo> cargarDatosGrupo(String nombre) throws SQLException{
		ArrayList<Grupo> ret = new ArrayList<Grupo>();
		ret = gestorGrupo.obtenerDatosGrupoPorNombre(nombre);
		return ret;
	}
	
	public ArrayList<Disco> cargarDiscos(String nombre) throws SQLException{
		ArrayList <Disco> ret = new ArrayList<Disco>();
		ret = gestorDisco.obtenerDiscosPorGrupo(nombre);
		return ret;
	}


	public ArrayList<Disco> cargarDatosDisco(String nombreDisco) throws SQLException{
		ArrayList<Disco> ret = new ArrayList<Disco>();
		ret = gestorDisco.obtenerDatosDisco(nombreDisco);
		return ret;
	}
	
	public ArrayList<Cancion> cargarCanciones(String nombreDisco) throws SQLException{
		GestorCancion gestorCancion = new GestorCancion();
		ArrayList<Cancion> ret = gestorCancion.obtenerCancionesPorDisco(nombreDisco);
		return ret;
		
	}
	



}
