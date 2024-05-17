package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import spotify.bbdd.gestor.GestorDisco;
import spotify.bbdd.pojos.Disco;

public class GestorDiscoTest {

	private GestorDisco gestorDisco;

	@Before
	public void setUp() {
		gestorDisco = new GestorDisco();
	}

	@Test
	public void testBorrar() {
		Disco disco = new Disco();
	    disco.setTitulo("Born to Die");

	    gestorDisco.borrar(disco);

	    ArrayList<Disco> discoBorrado = new ArrayList<>();

	    try {
	        discoBorrado = gestorDisco.obtenerDatosDisco("Born to Die");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        fail("Se produjo una excepción SQLException: " + e.getMessage());
	    }

	    assertTrue(discoBorrado.isEmpty());
	}

	@Test
	public void testObtener() {
		try {
			ArrayList<Disco> discos = gestorDisco.obtener();
			assertNotNull(discos);
			assertTrue(discos.size() > 0);
		} catch (SQLException sqle) {

		}
	}

	@Test
	public void testModificarDisco() {
		String nuevoTitulo = "Grupo2";
		Disco disco = new Disco();
		disco.setId(1);
		gestorDisco.modificarDisco(disco, nuevoTitulo);
		ArrayList<Disco> discos = new ArrayList<Disco>();
		try {
			discos = gestorDisco.obtener();
		} catch (SQLException e) {

		}

		for (int i = 0; i < discos.size(); i++) {
			if (discos.get(i).getTitulo().equals(nuevoTitulo)) {
				assertEquals(discos.get(i).getTitulo(), nuevoTitulo);
				break;
			}
		}
	}

	@Test
	public void testObtenerDiscosPorGrupo() {
		try {
			String nombreGrupo = "Oasis";
			String nombreDisco = "Morning Glory?";

			ArrayList<Disco> discos = gestorDisco.obtenerDiscosPorGrupo(nombreGrupo);

			assertNotNull(discos);
			assertTrue(discos.size() > 0);
			for (Disco disco : discos) {
				assertEquals(nombreDisco, disco.getTitulo());
			}

		} catch (SQLException sqle) {

		}
	}

}
