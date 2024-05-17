package spotify.logica;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import spotify.bbdd.gestor.GestorLibre;
import spotify.bbdd.gestor.GestorLocalidad;
import spotify.bbdd.gestor.GestorPremium;
import spotify.bbdd.pojos.Libre;
import spotify.bbdd.pojos.Localidad;
import spotify.bbdd.pojos.Premium;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import spotify.vista.PanelRegistro;

public class ControladorRegistro {

	private Libre libre = null;
	private Premium premium = null;
	private Localidad localidad = new Localidad();
	private GestorPremium gestorPremium = new GestorPremium();
	private GestorLibre gestorLibre = new GestorLibre();
	private GestorLocalidad gestorLocalidad = new GestorLocalidad();

	public void obtenerDatosUsuario(JTextField textField_Nombre, JTextField textField_Apellido1,
			JTextField textField_Apellido2, JTextField textField_Dni, JTextField textField_FechaNacimiento,
			JTextField textField_direccion, JTextField textField_CodigoPostal, JTextField textField_Ciudad,
			JTextField textField_Provincia, JTextField textField_Login, JTextField textField_Password,
			JTextField textField_Password2, JTextField textField_NumeroCuenta, JTextField textField_Caducidad,
			JTextField textField_Cvv, JCheckBox checkBox_Premium)  throws SQLException, ParseException, NumberFormatException{

		String txt = "";
		Date fecha = null;
		int numero = 0;
		long numeroLargo = 0;
		boolean codigoPostalExistente = false;

		if (checkBox_Premium.isSelected()){
			premium = new Premium();

			txt = textField_Nombre.getText();
			premium.setNombre(txt);

			txt = textField_Apellido1.getText();
			premium.setApellido1(txt);

			txt = textField_Apellido2.getText();
			premium.setApellido2(txt);

			txt = textField_Dni.getText();
			premium.setDni(txt);

			txt = textField_FechaNacimiento.getText();
			fecha = obtenerFechas(txt);
			premium.setFechaNacimiento(fecha);

			txt = textField_direccion.getText();
			premium.setDireccion(txt);

			txt = textField_CodigoPostal.getText();
			numero = Integer.parseInt(txt);
			localidad.setCodigoPostal(numero);
			codigoPostalExistente = compararCodigoPostal(localidad.getCodigoPostal());

			txt = textField_Ciudad.getText();
			localidad.setCiudad(txt);

			txt = textField_Provincia.getText();
			localidad.setProvincia(txt);

			txt = textField_Login.getText();
			premium.setLogin(txt);

			txt = textField_Password.getText();
			premium.setContrasenia(txt);

			txt = textField_NumeroCuenta.getText();
			numeroLargo = Long.parseLong(txt);
			premium.setNumeroCuenta(numero);

			txt = textField_Cvv.getText();
			numero = Integer.parseInt(txt);
			premium.setCVV(numero);

			txt = textField_Caducidad.getText();
			premium.setCaduca(txt);

			gestorPremium = new GestorPremium();

			gestorPremium.anaidirLocalidad(premium, localidad);

			if (!codigoPostalExistente) {
				gestorLocalidad.anaidir(localidad);
			}

		} else {

			libre = new Libre();
			txt = textField_Nombre.getText();
			libre.setNombre(txt);

			txt = textField_Apellido1.getText();
			libre.setApellido1(txt);

			txt = textField_Apellido2.getText();
			libre.setApellido2(txt);

			txt = textField_Dni.getText();
			libre.setDni(txt);

			txt = textField_FechaNacimiento.getText();
			fecha = obtenerFechas(txt);
			libre.setFechaNacimiento(fecha);

			txt = textField_direccion.getText();
			libre.setDireccion(txt);

			txt = textField_CodigoPostal.getText();
			numero = Integer.parseInt(txt);
			localidad.setCodigoPostal(numero);
			codigoPostalExistente = this.compararCodigoPostal(localidad.getCodigoPostal());

			txt = textField_Ciudad.getText();
			localidad.setCiudad(txt);

			txt = textField_Provincia.getText();
			localidad.setProvincia(txt);

			txt = textField_Login.getText();
			libre.setLogin(txt);

			txt = textField_Password.getText();
			libre.setContrasenia(txt);

			gestorLibre = new GestorLibre();

			gestorLibre.anaidirUser(libre, localidad);

			if (!codigoPostalExistente) {
				gestorLocalidad.anaidir(localidad);
			}

		}

	}

	public boolean compararCodigoPostal(int codigoPostal) {
		boolean ret = false;

		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		localidades = gestorLocalidad.obtener();

		for (int i = 0; i < localidades.size(); i++) {

			if (localidades.get(i).getCodigoPostal() == codigoPostal) {
				ret = false;
				break;
			} else {
				ret = true;
			}
		}

		return ret;
	}

	public boolean compararLogin(String login) throws SQLException{
		boolean ret = false;
		ArrayList<Libre> loginExistentes = new ArrayList<Libre>();
		loginExistentes = gestorLibre.obtener();

		for (int i = 0; i < loginExistentes.size(); i++) {
			if (login.equals(loginExistentes.get(i).getLogin())) {
				ret = true;
				break;
			} else {
				ret = false;
			}
		}

		return ret;
	}

	public boolean compararDni(String dni) throws SQLException{
		boolean ret = false;
		ArrayList<Libre> dniExistentes = new ArrayList<Libre>();
		dniExistentes = gestorLibre.obtener();

		for (int i = 0; i < dniExistentes.size(); i++) {
			if (dni.equals(dniExistentes.get(i).getDni())) {
				ret = true;
				break;
			} else {
				ret = false;
			}
		}
		
		return ret;
	}
	

	private Date obtenerFechas(String txt) throws ParseException{
		java.util.Date fecha = null;
		Date ret = null; 

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			fecha = dateFormat.parse(txt);
			ret = new Date(fecha.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return ret;
	}

}