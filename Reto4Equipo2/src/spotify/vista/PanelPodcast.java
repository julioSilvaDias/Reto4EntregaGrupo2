package spotify.vista;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import spotify.bbdd.pojos.Podcast;
import spotify.bbdd.pojos.Podcaster;
import spotify.bbdd.pojos.Serie;
import spotify.logica.ControladorPodcast;
import spotify.logica.Sesion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPodcast {

	private JPanel panel = null;
	private JTable tablePodcaster;
	private JTable tableSerie;
	private JTable tablePodcast;
	private ControladorPodcast controladorPodcast = new ControladorPodcast();
	private String[] columnaPodcaster = { "PODCASTER" };
	private Object[][] datoPodcaster = {};
	private String[] columnaSerie = { "SERIES" };
	private Object[][] datoSerie = {};
	private String[] columnaPodcast = { "PODCAST" };
	private Object[][] datoPodcast = {};
	private DefaultTableModel modeloPodcaster = null;
	private DefaultTableModel modeloSerie = null;
	private DefaultTableModel modeloPodcast = null;
	private ArrayList<Podcaster> podcaster = null;
	private ArrayList<Podcaster> datosPodcaster = new ArrayList<Podcaster>();
	private ArrayList<Serie> series = null;

	private JLabel lblImagenPodcaster = new JLabel("");
	private JLabel lblImagenSerie = new JLabel("");
	boolean podcastSeleccionado = false;
	private String tituloPodcast = null;
	private String tituloSerie = null;
	private String nomPodcaster = null;
	private ArrayList<Podcast> podcast = null;
	private String imagenStringSerie = null;
	private String imagenString = null;
	ArrayList<Serie> datosSerie = null;

	public PanelPodcast(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1499, 878);
		panel.setLayout(null);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
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
		btnVolver.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnVolver.setBounds(131, 56, 159, 32);
		panel.add(btnVolver);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
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
		btnPerfil.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnPerfil.setBounds(131, 168, 159, 32);
		panel.add(btnPerfil);

		JScrollPane scrollPanePodcaster = new JScrollPane();
		scrollPanePodcaster.setBounds(47, 325, 396, 481);
		modeloPodcaster = new DefaultTableModel(datoPodcaster, columnaPodcaster);
		tablePodcaster = new JTable(modeloPodcaster);

		podcaster = controladorPodcast.cargarPodcaster();

		ListSelectionModel selectionModelPodcaster = tablePodcaster.getSelectionModel();
		selectionModelPodcaster.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		for (Podcaster podcaster : podcaster) {

			Vector<Object> fila = new Vector<Object>();
			fila.add(podcaster.getNombre());

			modeloPodcaster.addRow(fila);
		}

		scrollPanePodcaster.setViewportView(tablePodcaster);
		panel.add(scrollPanePodcaster);

		JScrollPane scrollPaneSeries = new JScrollPane();
		scrollPaneSeries.setBounds(539, 325, 447, 481);

		modeloSerie = new DefaultTableModel(datoSerie, columnaSerie);
		tableSerie = new JTable(modeloSerie);

		ListSelectionModel selectionModelSerie = tableSerie.getSelectionModel();
		selectionModelSerie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPaneSeries.setViewportView(tableSerie);

		panel.add(scrollPaneSeries);

		JScrollPane scrollPanePodcast = new JScrollPane();
		scrollPanePodcast.setBounds(1086, 325, 356, 294);

		modeloPodcast = new DefaultTableModel(datoPodcast, columnaPodcast);
		tablePodcast = new JTable(modeloPodcast);
		ListSelectionModel selectionModelPodcast = tablePodcast.getSelectionModel();
		selectionModelPodcast.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPanePodcast.setViewportView(tablePodcast);

		panel.add(scrollPanePodcast);

		lblImagenPodcaster.setBounds(519, 29, 230, 228);
		panel.add(lblImagenPodcaster);

		lblImagenSerie.setBounds(1060, 26, 404, 231);
		panel.add(lblImagenSerie);

		JLabel lblDescripcionSerie = new JLabel("");
		lblDescripcionSerie.setForeground(new Color(255, 255, 255));
		lblDescripcionSerie.setBounds(1057, 267, 394, 76);
		panel.add(lblDescripcionSerie);

		JButton btnReproducir = new JButton("Reproducir");
	
		btnReproducir.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnReproducir.setBounds(1189, 694, 165, 50);
		panel.add(btnReproducir);

		JLabel lblDescripcionPodcaster = new JLabel("");
		lblDescripcionPodcaster.setForeground(new Color(255, 255, 255));
		lblDescripcionPodcaster.setBounds(772, 29, 246, 157);
		panel.add(lblDescripcionPodcaster);

		JLabel lblFechaUnion = new JLabel("");
		lblFechaUnion.setForeground(new Color(255, 255, 255, 255));
		lblFechaUnion.setBounds(936, 193, 76, 31);
		panel.add(lblFechaUnion);

		JLabel lblFondoPodcast = new JLabel("");
		lblFondoPodcast.setIcon(new ImageIcon(PanelPodcast.class.getResource("/Imagenes/grupos-podcast.png")));
		lblFondoPodcast.setBounds(0, 0, 1499, 878);
		panel.add(lblFondoPodcast);

		selectionModelPodcaster.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRowPodcaster = tablePodcaster.getSelectedRow();
					if (selectedRowPodcaster != -1) {
						Object nombre = tablePodcaster.getValueAt(selectedRowPodcaster, 0);
						nomPodcaster = nombre + "";
						datosPodcaster = controladorPodcast.cargarDatosPodcaster(nomPodcaster);
						btnReproducir.setEnabled(false);

						for (int i = 0; i < datosPodcaster.size(); i++) {
							lblDescripcionPodcaster.setText(datosPodcaster.get(i).getDescripcion());
							imagenString = datosPodcaster.get(i).getImagen();
							mostrarImagen(imagenString);
						}

						controladorPodcast.cargarPodcast(tituloPodcast);
						modeloSerie.setRowCount(0);
						modeloPodcast.setRowCount(0);
						series = new ArrayList<Serie>();
						series = controladorPodcast.cargarSeries(nomPodcaster);

						for (Serie serie : series) {
							Vector<Object> fila = new Vector<Object>();
							fila.add(serie.getTituloSerie());

							modeloSerie.addRow(fila);
						}
					}
				}
			}
		});

		selectionModelSerie.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableSerie.getSelectedRow();
					if (selectedRow != -1) {
						Object nombre = tableSerie.getValueAt(selectedRow, 0);
						tituloSerie = nombre + "";
						btnReproducir.setEnabled(false);

						datosSerie = new ArrayList<Serie>();
						datosSerie = controladorPodcast.cargarSeries(tituloSerie);

						for (int i = 0; i < datosSerie.size(); i++) {
							lblDescripcionSerie.setText(datosSerie.get(i).getDescripcion());
							imagenStringSerie = datosSerie.get(i).getImagen();
							mostrarImagenSerie(imagenStringSerie);
						}

						podcast = new ArrayList<Podcast>();
						podcast = controladorPodcast.cargarPodcast(tituloSerie);

						modeloPodcast.setRowCount(0);
						for (Podcast podcast : podcast) {
							Vector<Object> fila = new Vector<Object>();
							fila.add(podcast.getTitulo());

							modeloPodcast.addRow(fila);
						}
					}
				}
			}
		});

		selectionModelPodcast.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tablePodcast.getSelectedRow();
					if (selectedRow != -1) {

						Object nombre = tablePodcast.getValueAt(selectedRow, 0);
						tituloPodcast = nombre + "";
						btnReproducir.setEnabled(true);
					}
				}
			}
		});
		
		btnReproducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Sesion.getInstance().setNombrePodcast(tituloPodcast);
				Sesion.getInstance().setNombreSerie(tituloSerie);
				Sesion.getInstance().setNombreGrupo(nomPodcaster);

				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);
				paneles.get(6).setVisible(true);
				paneles.get(7).setVisible(false);
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(false);
			}
		});
	}

	private void mostrarImagenSerie(String imagenString) {
		byte[] imagenBytes = Base64.getDecoder().decode(imagenString);
		ImageIcon imageIcon = new ImageIcon(imagenBytes);
		lblImagenSerie.setIcon(imageIcon);
	}

	private void mostrarImagen(String imagenString) {
		byte[] imagenBytes = Base64.getDecoder().decode(imagenString);
		ImageIcon imageIcon = new ImageIcon(imagenBytes);
		lblImagenPodcaster.setIcon(imageIcon);
	}

	public JPanel getPanel() {
		return panel;
	}
}
