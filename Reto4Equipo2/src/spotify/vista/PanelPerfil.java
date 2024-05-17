package spotify.vista;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import spotify.bbdd.pojos.Libre;
import spotify.logica.ControladorPerfil;
import spotify.logica.Sesion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class PanelPerfil {
	private JPanel panel = null;
	private JTextField textField_CambiarContrasena;
	private Libre usuario = new Libre();
	private ControladorPerfil controladorPerfil = new ControladorPerfil();

	public PanelPerfil(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1499, 878);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(749, 116, 348, 32);
		panel.add(lblNombre);

		textField_CambiarContrasena = new JTextField();
		textField_CambiarContrasena.setBounds(514, 528, 177, 32);
		panel.add(textField_CambiarContrasena);
		textField_CambiarContrasena.setColumns(10);

		JLabel lbl_TextoCambiarContrasena = new JLabel("Cambiar contrasena");
		lbl_TextoCambiarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_TextoCambiarContrasena.setForeground(new Color(255, 255, 255));
		lbl_TextoCambiarContrasena.setBounds(514, 503, 131, 14);
		panel.add(lbl_TextoCambiarContrasena);

		JButton boton_Aceptar = new JButton("Aceptar");

		boton_Aceptar.setForeground(new Color(255, 255, 255));
		boton_Aceptar.setBackground(new Color(55, 26, 45));
		boton_Aceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Aceptar.setBounds(514, 626, 124, 32);
		panel.add(boton_Aceptar);

		JButton boton_Cancelar = new JButton("Cancelar");
		boton_Cancelar.setForeground(new Color(255, 255, 255));
		boton_Cancelar.setBackground(new Color(55, 26, 45));
		boton_Cancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		boton_Cancelar.setBounds(514, 724, 124, 32);
		panel.add(boton_Cancelar);

		JButton btnVerPerfil = new JButton("Ver Perfil");
		btnVerPerfil.setBounds(956, 724, 101, 32);
		panel.add(btnVerPerfil);

		JLabel lblApellido = new JLabel("");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setBounds(749, 164, 348, 32);
		panel.add(lblApellido);

		JLabel lblDni = new JLabel("");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setBounds(749, 206, 348, 32);
		panel.add(lblDni);

		JLabel lblFechaNac = new JLabel("");
		lblFechaNac.setForeground(new Color(255, 255, 255));
		lblFechaNac.setBounds(749, 248, 348, 32);
		panel.add(lblFechaNac);

		JLabel lblDireccion = new JLabel("");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setBounds(749, 290, 348, 32);
		panel.add(lblDireccion);

		JLabel lblLogin = new JLabel("");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBounds(749, 337, 348, 32);
		panel.add(lblLogin);

		JLabel lblTipoCuenta = new JLabel("");
		lblTipoCuenta.setForeground(new Color(255, 255, 255));
		lblTipoCuenta.setBounds(749, 381, 348, 32);
		panel.add(lblTipoCuenta);

		JLabel lbl_FondoPerfil = new JLabel("");
		lbl_FondoPerfil.setIcon(new ImageIcon(PanelPerfil.class.getResource("/Imagenes/perfil.png")));
		lbl_FondoPerfil.setBounds(0, 0, 1499, 878);
		panel.add(lbl_FondoPerfil);

		btnVerPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				usuario = controladorPerfil.obtenerUsuario(Sesion.getInstance().getLogin());
				lblNombre.setText(usuario.getNombre());
				lblApellido.setText(usuario.getApellido1());
				lblDni.setText(usuario.getDni());
				String fechaString = usuario.getFechaNacimiento() + "";
				lblFechaNac.setText(fechaString);
				lblDireccion.setText(usuario.getDireccion());
				lblLogin.setText(usuario.getLogin());
				boolean isPremium = controladorPerfil.isPremium(usuario.getIdentificador());
				if(isPremium) {
					lblTipoCuenta.setText("Premium");
				}else {
					lblTipoCuenta.setText("Libre");
				}
				
				btnVerPerfil.setVisible(false);
				btnVerPerfil.setEnabled(false);
				}catch(SQLException sqle) {
					JOptionPane.showMessageDialog(panel, "Problemas con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(panel, "Problemas genericos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				controladorPerfil.cambiarContrasenia(usuario.getIdentificador(), textField_CambiarContrasena.getText());
				}catch(SQLException sqle) {
					JOptionPane.showMessageDialog(panel, "Problemas con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(panel, "Problemas genericos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	public JPanel getPanel() {
		return panel;
	}
}
