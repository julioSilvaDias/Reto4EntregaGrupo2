package spotify.vista;

import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JPanel;

import javazoom.jl.player.Player;
import spotify.bbdd.pojos.Cancion;
import spotify.bbdd.pojos.Disco;
import spotify.bbdd.pojos.Podcast;
import spotify.bbdd.pojos.Serie;
import spotify.logica.ControladorReproduccion;
import spotify.logica.Sesion;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelReproduccion {
	private JPanel panel = null;
	private ControladorReproduccion controladorReproduccion = null;
	private JLabel lblImagenDisco = null;
	private ArrayList<Cancion> canciones = new ArrayList<Cancion>();
	private ArrayList<Disco> disco = null;
	private ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
	private ArrayList<Serie> series = new ArrayList<Serie>();
	private Player player = null;
	private int contadorReproduccion = 0;
	private String nombreDisco = null;
	private String nombreCancion = null;
	private String nombrePodcast = null;
	private String nombreSerie = null;
	private String imgString = null;

	public PanelReproduccion(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 1499, 878);
		panel.setLayout(null);

		controladorReproduccion = new ControladorReproduccion();
		JLabel lblPlay = new JLabel("");

		lblPlay.setIcon(new ImageIcon(PanelGrupo.class.getResource("/Imagenes/playicon.png")));
		lblPlay.setBounds(994, 690, 51, 63);
		panel.add(lblPlay);

		JLabel lblStop = new JLabel("");
		lblStop.setIcon(new ImageIcon(PanelGrupo.class.getResource("/Imagenes/stopicon.png")));
		lblStop.setBounds(990, 690, 55, 63);
		panel.add(lblStop);

		lblStop.setVisible(false);
		lblStop.setEnabled(false);

		lblPlay.setVisible(true);
		lblPlay.setEnabled(true);

		JLabel lblVolver = new JLabel("");
		lblVolver.setBounds(874, 674, 90, 78);
		panel.add(lblVolver);

		JLabel lblAdelantar = new JLabel("");

		lblAdelantar.setBounds(1071, 684, 82, 71);
		panel.add(lblAdelantar);

		JLabel lblFavorito = new JLabel("");
		lblFavorito.setBounds(1245, 675, 76, 78);
		panel.add(lblFavorito);

		lblImagenDisco = new JLabel("");
		lblImagenDisco.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenDisco.setBounds(719, 67, 585, 482);
		panel.add(lblImagenDisco);

		JButton btnVolver = new JButton("Volver");

		btnVolver.setBounds(98, 118, 137, 32);
		panel.add(btnVolver);

		JButton btnPerfil = new JButton("Perfil");

		btnPerfil.setBounds(98, 233, 137, 32);
		panel.add(btnPerfil);

		JLabel lblNombreCancion = new JLabel("");
		lblNombreCancion.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCancion.setForeground(new Color(255, 255, 255));
		lblNombreCancion.setBounds(719, 576, 585, 40);
		panel.add(lblNombreCancion);

		JLabel fondoReproductor = new JLabel("");
		fondoReproductor.setIcon(new ImageIcon(PanelGrupo.class.getResource("/Imagenes/reproductor.png")));
		fondoReproductor.setBounds(0, 0, 1499, 845);
		panel.add(fondoReproductor);

		lblPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (null != Sesion.getInstance().getNombrePodcast()) {
					nombrePodcast = Sesion.getInstance().getNombrePodcast();
					nombreDisco = Sesion.getInstance().getNombreSerie();

					podcasts = controladorReproduccion.cargarAllPodcasts();
					series = controladorReproduccion.cargarAllSeries();

					for (int i = 0; i < series.size(); i++) {
						if (series.get(i).getTituloSerie().equals(nombreSerie)) {
							imgString = disco.get(i).getImagen();
							montarImagen(imgString);
							break;
						}

					}

					for (int i = 0; i < podcasts.size(); i++) {
						if (podcasts.get(i).getTitulo().equals(nombrePodcast)) {
							play(podcasts.get(i).getRuta());
							lblNombreCancion.setText(podcasts.get(i).getTitulo());
							contadorReproduccion = i;
							break;

						}
					}
				}

				if (null != Sesion.getInstance().getNombreCancion()) {

					nombreCancion = Sesion.getInstance().getNombreCancion();
					nombreDisco = Sesion.getInstance().getNombreDisco();
					try {
						canciones = controladorReproduccion.cargarAllCanciones();

						disco = new ArrayList<Disco>();
						disco = controladorReproduccion.cargarAllDiscos();
					} catch (SQLException sqle) {

					}

					for (int i = 0; i < disco.size(); i++) {
						if (disco.get(i).getTitulo().equals(nombreDisco)) {
							imgString = disco.get(i).getImagen();
							montarImagen(imgString);
							break;
						}
					}

					for (int i = 0; i < canciones.size(); i++) {
						if (canciones.get(i).getTitulo().equals(nombreCancion)) {
							play(canciones.get(i).getRuta());
							lblNombreCancion.setText(canciones.get(i).getTitulo());
							contadorReproduccion = i;
							break;
						}

					}
				}

				lblStop.setVisible(true);
				lblStop.setEnabled(true);

				lblPlay.setVisible(false);
				lblPlay.setEnabled(false);
			}
		});

		lblStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stop();
				lblStop.setVisible(false);
				lblStop.setEnabled(false);

				lblPlay.setVisible(true);
				lblPlay.setEnabled(true);
			}
		});

		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stop();

				if (null != Sesion.getInstance().getNombrePodcast()) {
					if (contadorReproduccion > 0) {
						contadorReproduccion--;
					}

					if (contadorReproduccion <= podcasts.size()) {
						stop();
						play(podcasts.get(contadorReproduccion).getRuta());
						lblNombreCancion.setText(podcasts.get(contadorReproduccion).getTitulo());
					}
				}

				if (null != Sesion.getInstance().getNombreCancion()) {
					if (contadorReproduccion > 0) {
						contadorReproduccion--;
					}

					if (contadorReproduccion <= canciones.size()) {
						for (int i = 0; i < disco.size(); i++) {

							if (disco.get(i).getId() == canciones.get(contadorReproduccion).getCodidogoDisco()) {
								montarImagen(disco.get(i).getImagen());
								break;
							}
						}
						stop();
						play(canciones.get(contadorReproduccion).getRuta());
						lblNombreCancion.setText(canciones.get(contadorReproduccion).getTitulo());
					}
				}

				lblStop.setVisible(true);
				lblStop.setEnabled(true);

				lblPlay.setVisible(false);
				lblPlay.setEnabled(false);
			}
		});

		lblAdelantar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblAdelantar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						stop();

						if (null != Sesion.getInstance().getNombrePodcast()) {
							if (contadorReproduccion < canciones.size() - 1) {

								contadorReproduccion++;
							} else {
								contadorReproduccion = 0;
							}
							
							stop();
							play(podcasts.get(contadorReproduccion).getRuta());
							lblNombreCancion.setText(podcasts.get(contadorReproduccion).getTitulo());
						}
						if (null != Sesion.getInstance().getNombreCancion()) {
							if (contadorReproduccion < canciones.size() - 1) {

								contadorReproduccion++;
							} else {
								contadorReproduccion = 0;
							}

							for (int i = 0; i < disco.size(); i++) {

								if (disco.get(i).getId() == canciones.get(contadorReproduccion).getCodidogoDisco()) {
									montarImagen(disco.get(i).getImagen());
									break;
								}
							}
							stop();

							play(canciones.get(contadorReproduccion).getRuta());
							lblNombreCancion.setText(canciones.get(contadorReproduccion).getTitulo());
						}

						lblStop.setVisible(true);
						lblStop.setEnabled(true);

						lblPlay.setVisible(false);
						lblPlay.setEnabled(false);
					}
				});

			}
		});

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
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

		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
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

	}

	private void play(String ruta) {
		String THE_MUSIC_FILE = new File("").getAbsolutePath() + ruta;

		new Thread() {
			@Override
			public void run() {
				try {
					FileInputStream fileInputStream = new FileInputStream(THE_MUSIC_FILE);
					player = new Player(fileInputStream);
					player.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}.start();
	}

	private void stop() {
		if (player != null) {
			player.close();
		}
	}

	private void montarImagen(String imagenString) {
		if (imagenString != null) {
			byte[] imagenBytes = Base64.getDecoder().decode(imagenString);
			ImageIcon imageIcon = new ImageIcon(imagenBytes);
			lblImagenDisco.setIcon(imageIcon);
		} else {
		}
	}

	public JPanel getPanel() {
		return panel;
	}
}
