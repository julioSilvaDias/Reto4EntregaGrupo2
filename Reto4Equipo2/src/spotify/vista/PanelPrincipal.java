package spotify.vista;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import spotify.bbdd.gestor.GestorDisco;
import spotify.bbdd.pojos.Disco;
import spotify.logica.ControladorPantallaPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PanelPrincipal {
	JLabel lblPropaganda = null;

	private JPanel panel = null;

	
	ArrayList<Disco> discos = new ArrayList<Disco>();

	public PanelPrincipal(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1499, 878);
		panel.setLayout(null);

		JButton botonSalir = new JButton("Salir");
		botonSalir.setForeground(new Color(255, 255, 255));
		botonSalir.addActionListener(new ActionListener() {
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
		botonSalir.setBackground(new Color(41, 20, 34));
		botonSalir.setBounds(131, 161, 89, 23);
		panel.add(botonSalir);

		JButton botonPerfil = new JButton("Perfil");
		botonPerfil.setForeground(new Color(255, 255, 255));
		botonPerfil.setBackground(new Color(41, 20, 34));
		botonPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);
				paneles.get(6).setVisible(false);
				paneles.get(7).setVisible(false);
				paneles.get(8).setVisible(true);
				paneles.get(9).setVisible(false);
			}
		});
		botonPerfil.setBounds(131, 265, 89, 23);
		panel.add(botonPerfil);

		JButton botonFavoritos = new JButton("Favoritos");
		botonFavoritos.setForeground(new Color(255, 255, 255));
		botonFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);
				paneles.get(6).setVisible(false);
				paneles.get(7).setVisible(true);
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(false);
			}
		});
		botonFavoritos.setBackground(new Color(41, 20, 34));
		botonFavoritos.setBounds(131, 466, 89, 23);
		panel.add(botonFavoritos);

		JButton botonPodcast = new JButton("Podcasts");
		botonPodcast.setForeground(new Color(255, 255, 255));
		botonPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(true);
				paneles.get(6).setVisible(false);
				paneles.get(7).setVisible(false);
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(false);
			}
		});
		botonPodcast.setBackground(new Color(41, 20, 34));
		botonPodcast.setBounds(131, 605, 89, 23);
		panel.add(botonPodcast);

		JButton botonGrupos = new JButton("Grupos");
		botonGrupos.setForeground(new Color(255, 255, 255));
		botonGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(true);
				paneles.get(5).setVisible(false);
				paneles.get(6).setVisible(false);
				paneles.get(7).setVisible(false);
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(false);
			}
		});
		botonGrupos.setBackground(new Color(41, 20, 34));
		botonGrupos.setBounds(131, 748, 89, 23);
		panel.add(botonGrupos);

		lblPropaganda = new JLabel("");
		lblPropaganda.setBounds(773, 111, 537, 462);
		panel.add(lblPropaganda);
		
		ControladorPantallaPrincipal controladorPantallaPrincipal = new ControladorPantallaPrincipal();
		try {
			discos = controladorPantallaPrincipal.cargarAllDiscos();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(panel, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
		};
		Random random = new Random();
		int puntero = random.nextInt(discos.size());
		montarImagen(discos.get(puntero).getImagen());

		JLabel labelFondoPrincipal = new JLabel("");
		labelFondoPrincipal.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/principal.png")));
		labelFondoPrincipal.setBounds(0, 0, 1499, 878);
		panel.add(labelFondoPrincipal);

		TimerTask propagandaAutomatica = new TimerTask() {
			@Override
			public void run() {

				Random random = new Random();
				int puntero = random.nextInt(discos.size());
				montarImagen(discos.get(puntero).getImagen());
			}
		};
		

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(propagandaAutomatica, 0, 5000);

	}

	private void montarImagen(String imagenString) {
		if (imagenString != null) {
			byte[] imagenBytes = Base64.getDecoder().decode(imagenString);
			ImageIcon imageIcon = new ImageIcon(imagenBytes);
			lblPropaganda.setIcon(imageIcon);
		} else {
		}

	}

	public JPanel getPanel() {
		return panel;
	}
}