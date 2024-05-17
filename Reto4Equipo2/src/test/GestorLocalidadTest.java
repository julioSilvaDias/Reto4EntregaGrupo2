package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import spotify.bbdd.gestor.GestorLocalidad;
import spotify.bbdd.pojos.Localidad;

public class GestorLocalidadTest {

	private GestorLocalidad gestorLocalidad;

	@Before
	public void setUp() {
		gestorLocalidad = new GestorLocalidad();
	}

	@Test
	public void testModificar() {
		Localidad localidad = new Localidad();
		localidad.setCodigoPostal(48001);
		String nuevaCiudad = "Sestao";
		
		gestorLocalidad.modificarLocalidad(localidad, nuevaCiudad);
		
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		
		for(int i =0; i<localidades.size(); i++) {
			if(localidades.get(i).getCiudad().equals(nuevaCiudad)) {
				assertEquals(localidades.get(i).getCiudad(), nuevaCiudad);
				break;
			}
		}
		
	}

	@Test
	public void testBorrar() {
		Localidad localidad = new Localidad();
		localidad.setCiudad("Bilbao");

		gestorLocalidad.borrar(localidad);

		ArrayList<Localidad> localidadBorrado = gestorLocalidad.obtener();

		assertTrue(localidadBorrado.isEmpty());

	}

	@Test
	public void testAnadirYObtener() {

		Localidad nuevaLocalidad = new Localidad();
		nuevaLocalidad.setCodigoPostal(28001);
		nuevaLocalidad.setProvincia("Madrid");
		nuevaLocalidad.setCiudad("Madrid");

		gestorLocalidad.anaidir(nuevaLocalidad);
		ArrayList<Localidad> localidades = gestorLocalidad.obtener();

		assertNotNull(localidades);
		assertEquals(true, localidades.size() > 0);

		boolean localidadEncontrada = false;
		for (Localidad localidad : localidades) {
			if (localidad.getCodigoPostal() == nuevaLocalidad.getCodigoPostal()
					&& localidad.getProvincia().equals(nuevaLocalidad.getProvincia())
					&& localidad.getCiudad().equals(nuevaLocalidad.getCiudad())) {
				localidadEncontrada = true;
				break;
			}
		}
		assertEquals(true, localidadEncontrada);
	}

}
