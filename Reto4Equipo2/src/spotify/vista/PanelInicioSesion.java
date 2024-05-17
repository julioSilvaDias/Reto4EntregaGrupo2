package spotify.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import spotify.logica.ControladorInicioSesion;

import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelInicioSesion {
	private JPanel panel = null;
	private JTextField textField_Usuario;
	private JTextField textField_Contrasena;
	protected String login;
	protected String contrasenia;

	private ControladorInicioSesion controladorInicioSesion = null;

	public PanelInicioSesion(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1499, 878);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		controladorInicioSesion = new ControladorInicioSesion();

		JLabel lbl_TextoUsuario = new JLabel("Usuario:");
		lbl_TextoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_TextoUsuario.setForeground(new Color(255, 255, 255));
		lbl_TextoUsuario.setBounds(658, 328, 89, 23);
		panel.add(lbl_TextoUsuario);

		JLabel lbl_TextoContrasena = new JLabel("Contraseña:");
		lbl_TextoContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_TextoContrasena.setForeground(new Color(255, 255, 255));
		lbl_TextoContrasena.setBounds(658, 456, 100, 23);
		panel.add(lbl_TextoContrasena);

		JButton boton_Registro = new JButton("Registro");
		boton_Registro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(true);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);
				paneles.get(6).setVisible(false);
				paneles.get(7).setVisible(false);
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(false);
			}
		});
		boton_Registro.setBackground(new Color(255, 255, 255));
		boton_Registro.setBounds(793, 624, 100, 40);
		panel.add(boton_Registro);

		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String error = controladorInicioSesion.comprobarInicioSesion(textField_Usuario.getText(),
							textField_Contrasena.getText());

					if (null == error) {
						
						JOptionPane.showConfirmDialog(null, "Inicio de Sesión Correcto", "Aviso",
								JOptionPane.CLOSED_OPTION);

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
					} else {
						
						JOptionPane.showConfirmDialog(null, error, "Aviso", JOptionPane.CLOSED_OPTION);

						textField_Usuario.setText(null);
						textField_Contrasena.setText(null);
					}

				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña no válidos, intentalo de nuevo.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error al intentar iniciar sesión. Por favor, inténtalo de nuevo más tarde.");
				}

			}
		});
		boton_Aceptar.setBackground(new Color(255, 255, 255));
		boton_Aceptar.setBounds(618, 624, 100, 40);
		panel.add(boton_Aceptar);

		textField_Contrasena = new JTextField();
		textField_Contrasena.setBounds(658, 493, 189, 40);
		panel.add(textField_Contrasena);
		textField_Contrasena.setColumns(10);

		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(658, 361, 189, 40);
		panel.add(textField_Usuario);
		textField_Usuario.setColumns(10);

		JLabel lblInicioSesion = new JLabel("Inicio Sesion");
		lblInicioSesion.setForeground(new Color(255, 255, 255));
		lblInicioSesion.setBackground(new Color(255, 255, 255));
		lblInicioSesion.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setBounds(624, 240, 250, 40);
		panel.add(lblInicioSesion);

		JLabel lblDecoracion2 = new JLabel("○");
		lblDecoracion2.setFont(new Font("Tahoma", Font.PLAIN, 52));
		lblDecoracion2.setForeground(new Color(255, 255, 255));
		lblDecoracion2.setBounds(565, 220, 38, 40);
		panel.add(lblDecoracion2);

		JLabel lblDecoracion = new JLabel("○");
		lblDecoracion.setForeground(Color.WHITE);
		lblDecoracion.setFont(new Font("Tahoma", Font.PLAIN, 52));
		lblDecoracion.setBounds(904, 220, 38, 40);
		panel.add(lblDecoracion);

		JLabel lbl_FondoInicioSesion = new JLabel("");
		lbl_FondoInicioSesion.setIcon(new ImageIcon(PanelInicioSesion.class.getResource("/Imagenes/login.png")));
		lbl_FondoInicioSesion.setBounds(0, 0, 1499, 878);
		panel.add(lbl_FondoInicioSesion);

	}

	public JPanel getPanel() {
		return panel;
	}
}
