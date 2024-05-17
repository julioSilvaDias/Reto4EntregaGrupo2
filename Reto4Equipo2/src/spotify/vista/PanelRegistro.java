package spotify.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import spotify.bbdd.pojos.Libre;
import spotify.bbdd.pojos.Premium;
import spotify.logica.ControladorRegistro;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class PanelRegistro {
	private JPanel panel = null;
	private JButton jButtonPanel = null;
	public JTextField textField_Nombre;
	public JTextField textField_Apellido1;
	public JTextField textField_Apellido2;
	public JTextField textField_Dni;
	public JTextField textField_FechaNacimiento;
	public JTextField textField_direccion;
	public JTextField textField_CodigoPostal;
	public JTextField textField_Ciudad;
	public JTextField textField_Provincia;
	public JTextField textField_Login;
	public JTextField textField_Password;
	public JTextField textField_Password2;
	public JTextField textField_NumeroCuenta;
	public JTextField textField_Caducidad;
	public JTextField textField_Cvv;
	public JCheckBox checkBox_Premium;
	public ControladorRegistro controladorRegistro = new ControladorRegistro();;
	public Libre libre = null;
	public Premium premium = null;
	private JButton boton_Registro = null;
	private boolean camposValidos = false;

	public PanelRegistro(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 1499, 878);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JButton boton_Cancelar = new JButton("Cancelar");
		boton_Cancelar.setBounds(809, 634, 89, 23);

		boton_Cancelar.setBackground(Color.WHITE);
		panel.add(boton_Cancelar);

		boton_Registro = new JButton("Registro");

		boton_Registro.setBounds(908, 634, 89, 23);
		boton_Registro.setBackground(Color.WHITE);
		panel.add(boton_Registro);

		textField_Dni = new JTextField();
		textField_Dni.setBounds(531, 407, 189, 28);
		textField_Dni.setColumns(10);
		panel.add(textField_Dni);

		JLabel lbl_Dni = new JLabel("DNI");
		lbl_Dni.setBounds(531, 395, 89, 14);
		lbl_Dni.setForeground(Color.WHITE);
		lbl_Dni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbl_Dni);

		JLabel lbl_TextoApellido2 = new JLabel("Apellido 2");
		lbl_TextoApellido2.setBounds(531, 345, 89, 14);
		lbl_TextoApellido2.setForeground(Color.WHITE);
		lbl_TextoApellido2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbl_TextoApellido2);

		JLabel lbl_TextoApellido1 = new JLabel("Apellido 1");
		lbl_TextoApellido1.setBounds(533, 283, 89, 14);
		lbl_TextoApellido1.setForeground(Color.WHITE);
		lbl_TextoApellido1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbl_TextoApellido1);

		textField_Apellido2 = new JTextField();
		textField_Apellido2.setBounds(531, 357, 189, 28);
		textField_Apellido2.setColumns(10);
		panel.add(textField_Apellido2);

		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(533, 239, 189, 28);
		textField_Nombre.setColumns(10);
		panel.add(textField_Nombre);

		textField_Apellido1 = new JTextField();
		textField_Apellido1.setBounds(533, 297, 189, 28);
		textField_Apellido1.setColumns(10);
		panel.add(textField_Apellido1);

		JLabel lbl_FechaNacimiento = new JLabel("Fecha de nacimiento");
		lbl_FechaNacimiento.setBounds(533, 455, 149, 14);
		lbl_FechaNacimiento.setForeground(Color.WHITE);
		lbl_FechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbl_FechaNacimiento);

		textField_FechaNacimiento = new JTextField();
		textField_FechaNacimiento.setBounds(533, 469, 189, 28);
		textField_FechaNacimiento.setColumns(10);
		panel.add(textField_FechaNacimiento);

		JLabel lbl_TextoNombre = new JLabel("Nombre");
		lbl_TextoNombre.setBounds(533, 225, 61, 14);
		lbl_TextoNombre.setForeground(Color.WHITE);
		lbl_TextoNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbl_TextoNombre);

		textField_direccion = new JTextField();
		textField_direccion.setColumns(10);
		textField_direccion.setBounds(533, 521, 189, 28);
		panel.add(textField_direccion);

		JLabel lbl_Direccion = new JLabel("Direccion");
		lbl_Direccion.setForeground(Color.WHITE);
		lbl_Direccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Direccion.setBounds(533, 507, 149, 14);
		panel.add(lbl_Direccion);

		textField_CodigoPostal = new JTextField();
		textField_CodigoPostal.setColumns(10);
		textField_CodigoPostal.setBounds(533, 573, 189, 28);
		panel.add(textField_CodigoPostal);

		JLabel lbl_CodigoPostal = new JLabel("Codigo Postal");
		lbl_CodigoPostal.setForeground(Color.WHITE);
		lbl_CodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_CodigoPostal.setBounds(533, 559, 149, 14);
		panel.add(lbl_CodigoPostal);

		JLabel lbl_Ciudad = new JLabel("Ciudad");
		lbl_Ciudad.setForeground(Color.WHITE);
		lbl_Ciudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Ciudad.setBounds(531, 618, 149, 14);
		panel.add(lbl_Ciudad);

		textField_Ciudad = new JTextField();
		textField_Ciudad.setColumns(10);
		textField_Ciudad.setBounds(531, 632, 189, 28);
		panel.add(textField_Ciudad);

		textField_Provincia = new JTextField();
		textField_Provincia.setColumns(10);
		textField_Provincia.setBounds(808, 239, 189, 28);
		panel.add(textField_Provincia);

		JLabel lbl_Provincia = new JLabel("Provincia");
		lbl_Provincia.setForeground(Color.WHITE);
		lbl_Provincia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Provincia.setBounds(808, 225, 149, 14);
		panel.add(lbl_Provincia);

		JLabel lbl_Login = new JLabel("Login");
		lbl_Login.setForeground(Color.WHITE);
		lbl_Login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Login.setBounds(808, 283, 149, 14);
		panel.add(lbl_Login);

		textField_Login = new JTextField();
		textField_Login.setColumns(10);
		textField_Login.setBounds(808, 297, 189, 28);
		panel.add(textField_Login);

		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setForeground(Color.WHITE);
		lbl_Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Password.setBounds(808, 341, 149, 14);
		panel.add(lbl_Password);

		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(808, 355, 189, 28);
		panel.add(textField_Password);

		textField_Password2 = new JTextField();
		textField_Password2.setColumns(10);
		textField_Password2.setBounds(808, 409, 189, 28);
		panel.add(textField_Password2);

		JLabel lbl_Password2 = new JLabel("Password2");
		lbl_Password2.setForeground(Color.WHITE);
		lbl_Password2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Password2.setBounds(808, 395, 149, 14);
		panel.add(lbl_Password2);

		checkBox_Premium = new JCheckBox("Premium");

		checkBox_Premium.setBounds(904, 455, 93, 21);
		panel.add(checkBox_Premium);

		JCheckBox checkBox_Libre = new JCheckBox("Libre");

		checkBox_Libre.setBounds(808, 455, 93, 21);
		panel.add(checkBox_Libre);

		textField_NumeroCuenta = new JTextField();
		textField_NumeroCuenta.setColumns(10);
		textField_NumeroCuenta.setBounds(808, 496, 189, 28);
		textField_NumeroCuenta.setVisible(false);
		panel.add(textField_NumeroCuenta);

		JLabel lbl_NumeroCuenta = new JLabel("Numero Cunta");
		lbl_NumeroCuenta.setForeground(Color.WHITE);
		lbl_NumeroCuenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_NumeroCuenta.setBounds(808, 482, 149, 14);
		lbl_NumeroCuenta.setVisible(false);
		panel.add(lbl_NumeroCuenta);

		textField_Caducidad = new JTextField();
		textField_Caducidad.setColumns(10);
		textField_Caducidad.setBounds(808, 548, 189, 28);
		textField_Caducidad.setVisible(false);
		panel.add(textField_Caducidad);

		JLabel lbl_Caducidad = new JLabel("Caducidad");
		lbl_Caducidad.setForeground(Color.WHITE);
		lbl_Caducidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Caducidad.setBounds(808, 534, 149, 14);
		lbl_Caducidad.setVisible(false);
		panel.add(lbl_Caducidad);

		textField_Cvv = new JTextField();
		textField_Cvv.setColumns(10);
		textField_Cvv.setBounds(808, 600, 189, 28);
		textField_Cvv.setVisible(false);
		panel.add(textField_Cvv);

		JLabel lbl_Cvv = new JLabel("CVV");
		lbl_Cvv.setForeground(Color.WHITE);
		lbl_Cvv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Cvv.setBounds(808, 586, 149, 14);
		lbl_Cvv.setVisible(false);
		panel.add(lbl_Cvv);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1499, 878);
		lblNewLabel.setIcon(new ImageIcon(PanelRegistro.class.getResource("/Imagenes/registro.png")));
		panel.add(lblNewLabel);

		checkBox_Premium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_NumeroCuenta.setVisible(true);
				lbl_NumeroCuenta.setVisible(true);

				textField_Caducidad.setVisible(true);
				lbl_Caducidad.setVisible(true);

				textField_Cvv.setVisible(true);
				lbl_Cvv.setVisible(true);

				checkBox_Libre.setSelected(false);

				if (!checkBox_Premium.isSelected()) {
					textField_NumeroCuenta.setVisible(false);
					lbl_NumeroCuenta.setVisible(false);

					textField_Caducidad.setVisible(false);
					lbl_Caducidad.setVisible(false);

					textField_Cvv.setVisible(false);
					lbl_Cvv.setVisible(false);

					checkBox_Premium.setSelected(false);
				}
			}
		});
		verificarCampos();

		checkBox_Libre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_NumeroCuenta.setVisible(false);
				lbl_NumeroCuenta.setVisible(false);

				textField_Caducidad.setVisible(false);
				lbl_Caducidad.setVisible(false);

				textField_Cvv.setVisible(false);
				lbl_Cvv.setVisible(false);

				checkBox_Premium.setSelected(false);
			}
		});

		boton_Registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					controladorRegistro.obtenerDatosUsuario(textField_Nombre, textField_Apellido1, textField_Apellido2,
							textField_Dni, textField_FechaNacimiento, textField_direccion, textField_CodigoPostal,
							textField_Ciudad, textField_Provincia, textField_Login, textField_Password,
							textField_Password2, textField_NumeroCuenta, textField_Caducidad, textField_Cvv,
							checkBox_Premium);

				} catch (ParseException parseException) {

					JOptionPane.showMessageDialog(null, "Formato de fechas no valido", "ERROR!!!",
							JOptionPane.ERROR_MESSAGE);
					paneles.get(0).setVisible(true);
					paneles.get(1).setVisible(false);
					paneles.get(2).setVisible(false);
					paneles.get(3).setVisible(false);
					paneles.get(4).setVisible(false);
					paneles.get(5).setVisible(false);
					paneles.get(6).setVisible(false);
					paneles.get(7).setVisible(false);
					paneles.get(8).setVisible(false);
					paneles.get(9).setVisible(false);
				} catch (SQLException sqle) {

					JOptionPane.showMessageDialog(null, "Error con la base de datos", "ERROR!!!",
							JOptionPane.ERROR_MESSAGE);
					paneles.get(0).setVisible(true);
					paneles.get(1).setVisible(false);
					paneles.get(2).setVisible(false);
					paneles.get(3).setVisible(false);
					paneles.get(4).setVisible(false);
					paneles.get(5).setVisible(false);
					paneles.get(6).setVisible(false);
					paneles.get(7).setVisible(false);
					paneles.get(8).setVisible(false);
					paneles.get(9).setVisible(false);

				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Formato de campo numerico no valido", "ERROR!!!",
							JOptionPane.ERROR_MESSAGE);
					paneles.get(0).setVisible(true);
					paneles.get(1).setVisible(false);
					paneles.get(2).setVisible(false);
					paneles.get(3).setVisible(false);
					paneles.get(4).setVisible(false);
					paneles.get(5).setVisible(false);
					paneles.get(6).setVisible(false);
					paneles.get(7).setVisible(false);
					paneles.get(8).setVisible(false);
					paneles.get(9).setVisible(false);

				} catch (Exception errorGenerico) {
					JOptionPane.showMessageDialog(null, "Error generico", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
					paneles.get(0).setVisible(true);
					paneles.get(1).setVisible(false);
					paneles.get(2).setVisible(false);
					paneles.get(3).setVisible(false);
					paneles.get(4).setVisible(false);
					paneles.get(5).setVisible(false);
					paneles.get(6).setVisible(false);
					paneles.get(7).setVisible(false);
					paneles.get(8).setVisible(false);
					paneles.get(9).setVisible(false);

				}

				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(true);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);
				paneles.get(6).setVisible(false);
				paneles.get(7).setVisible(false);
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(false);

			}
		});

		boton_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);
				paneles.get(6).setVisible(false);
				paneles.get(7).setVisible(false);
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(false);
			}

		});

		textField_Nombre.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (textField_Nombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "campo obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
					textField_Nombre.setForeground(Color.red);

				} else {
					textField_Nombre.setForeground(Color.black);

				}
			}

		});

		textField_Apellido1.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (textField_Apellido1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "campo obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
					textField_Apellido1.setForeground(Color.red);
					camposValidos = false;

				} else {
					textField_Apellido1.setForeground(Color.black);
					camposValidos = true;
				}
			}

		});

		textField_FechaNacimiento.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (textField_FechaNacimiento.getText().isEmpty()) {
					textField_FechaNacimiento.setForeground(Color.RED);
					JOptionPane.showMessageDialog(panel, "campo obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
					camposValidos = false;

				} else {
					textField_FechaNacimiento.setForeground(Color.BLACK);
					camposValidos = true;
				}
			}

		});

		textField_Dni.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {

				try {

					boolean dniExistente = controladorRegistro.compararDni(textField_Dni.getText());

					if (textField_Dni.getText().matches("\\d{8}[a-zA-Z]") && !dniExistente) {
						textField_Dni.setForeground(Color.BLACK);
						camposValidos = true;

					} else if (textField_Dni.getText().isEmpty()) {
						textField_Dni.setForeground(Color.RED);
						JOptionPane.showMessageDialog(panel, "campo obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
						camposValidos = false;

					} else {
						textField_Dni.setForeground(Color.RED);
						camposValidos = false;

					}
				} catch (SQLException sqlException) {
					JOptionPane.showMessageDialog(panel, "Error con la base de datos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

		});

		textField_direccion.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (textField_direccion.getText().isEmpty()) {
					textField_direccion.setForeground(Color.RED);
					JOptionPane.showMessageDialog(panel, "campo obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
					camposValidos = false;

				} else {
					textField_direccion.setForeground(Color.BLACK);
					camposValidos = true;
				}
			}

		});

		textField_CodigoPostal.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {

				if (textField_CodigoPostal.getText().matches("\\d{5}")) {
					textField_CodigoPostal.setForeground(Color.BLACK);
					camposValidos = true;

				} else if (textField_CodigoPostal.getText().isEmpty()) {
					textField_CodigoPostal.setForeground(Color.RED);
					JOptionPane.showMessageDialog(panel, "campo obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
					camposValidos = false;

				} else {
					textField_CodigoPostal.setForeground(Color.RED);
					camposValidos = false;

				}
			}

		});

		textField_Ciudad.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (textField_Ciudad.getText().isEmpty()) {
					textField_Ciudad.setForeground(Color.RED);
					JOptionPane.showMessageDialog(panel, "campo obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
					camposValidos = false;

				} else {
					textField_Ciudad.setForeground(Color.BLACK);
					camposValidos = true;
				}
			}

		});

		textField_Provincia.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (textField_Provincia.getText().isEmpty()) {
					textField_Provincia.setForeground(Color.RED);
					JOptionPane.showMessageDialog(panel, "campo obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
					camposValidos = false;

				} else {
					textField_Provincia.setForeground(Color.BLACK);
					camposValidos = true;
				}
			}

		});

		textField_Login.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {

				boolean usuarioDuplicado = false;
				try {
					usuarioDuplicado = controladorRegistro.compararLogin(textField_Login.getText());

					if (textField_Login.getText().isEmpty() || textField_Login.getText().length() < 3) {
						textField_Login.setForeground(Color.RED);
						camposValidos = false;

					} else if (usuarioDuplicado) {
						textField_Login.setForeground(Color.RED);
						camposValidos = false;

					} else {
						textField_Login.setForeground(Color.BLACK);
						camposValidos = true;
					}
					
				} catch (SQLException sqlException) {
					JOptionPane.showMessageDialog(panel, "Error con la base de datos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel, "Error Generico", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		textField_Password.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				String formato = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$";

				if (!textField_Password.getText().matches(formato) || textField_Password.getText().isEmpty()) {
					textField_Password.setForeground(Color.red);

					camposValidos = false;
				} else {
					textField_Password.setForeground(Color.black);
					camposValidos = true;
				}
			}

		});

		textField_Password2.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (textField_Password2.getText().isEmpty()
						|| !textField_Password2.getText().equals(textField_Password.getText())) {
					textField_Password2.setForeground(Color.red);
					camposValidos = false;
				} else {
					textField_Password2.setForeground(Color.black);
					if (checkBox_Libre.isSelected()) {
						camposValidos = true;
					}
				}
				verificarCampos();
			}

		});

		textField_Cvv.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (checkBox_Premium.isSelected()) {
					if (!textField_Cvv.getText().matches("\\d*") || textField_Cvv.getText().length() < 4
							|| textField_Cvv.getText().isEmpty()) {
						textField_Cvv.setForeground(Color.red);
						camposValidos = false;
					} else {
						textField_Cvv.setForeground(Color.black);
						camposValidos = true;
					}

				}
			}

		});

		textField_NumeroCuenta.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (checkBox_Premium.isSelected()) {
					if (!textField_NumeroCuenta.getText().matches("\\d*")
							|| textField_NumeroCuenta.getText().length() < 16
							|| textField_NumeroCuenta.getText().isEmpty()) {

						textField_NumeroCuenta.setForeground(Color.red);
						camposValidos = false;

					} else {
						textField_NumeroCuenta.setForeground(Color.black);
						camposValidos = true;
					}

				}
			}

		});

		textField_Caducidad.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarCampo();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validarCampo();

			}

			private void validarCampo() {
				if (checkBox_Premium.isSelected()) {
					if (textField_Caducidad.getText().isEmpty()) {
						textField_Caducidad.setForeground(Color.red);
						camposValidos = false;

					} else {
						textField_Caducidad.setForeground(Color.black);
						camposValidos = true;
					}

				}

				verificarCampos();
			}

		});

	}

	private void verificarCampos() {
		if (camposValidos) {
			boton_Registro.setEnabled(true);
		} else {
			boton_Registro.setEnabled(false);
		}
	}

	public JPanel getPanel() {
		return panel;
	}
}
