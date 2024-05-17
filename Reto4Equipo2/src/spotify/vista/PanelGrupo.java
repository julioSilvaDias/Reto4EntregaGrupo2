package spotify.vista;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import spotify.bbdd.pojos.Cancion;
import spotify.bbdd.pojos.Disco;
import spotify.bbdd.pojos.Grupo;
import spotify.logica.ControladorGrupo;
import spotify.logica.ControladorReproduccion;
import spotify.logica.Sesion;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PanelGrupo {

	private JPanel panel = null;
	private JTable table_Grupos;
	private JTable table_Discos;
	private JTable table_Canciones;
	private ControladorGrupo controladorGrupo = new ControladorGrupo();
	private String[] columnaGrupos = { "GRUPOS" };
	private Object[][] datoGrupos = {};
	private String[] columnaDiscos = { "DISCOS" };
	private Object[][] datoDiscos = {};
	private String[] columnaCanciones = { "CANCIONES" };
	private Object[][] datoCanciones = {};
	private DefaultTableModel modeloGrupos = null;
	private DefaultTableModel modeloDiscos = null;
	private DefaultTableModel modeloCanciones = null;
	private ArrayList<Grupo> grupos = null;
	private ArrayList<Grupo> datosgrupo = new ArrayList<Grupo>();
	private ArrayList<Disco> discos = null;
	private JLabel lbl_ImagenGrupo = new JLabel("");
	private JLabel lbl_imagenDisco = new JLabel("");
	boolean cancionSeleccionada = false;
	private String nombreCancion = null;
	private String nombreDisco = null;
	private String nombreGrupo = null;
	private ArrayList<Cancion> canciones = null;
	private String imagenStringDisco = null;
	ArrayList<Disco> datosDiscos = null;

	public PanelGrupo(ArrayList<JPanel> paneles) {
		try {

			panel = new JPanel();
			panel.setBounds(0, 0, 1499, 878);
			panel.setLayout(null);

			JScrollPane scrollPane_Grupos = new JScrollPane();
			scrollPane_Grupos.setBounds(31, 362, 432, 392);
			modeloGrupos = new DefaultTableModel(datoGrupos, columnaGrupos);
			table_Grupos = new JTable(modeloGrupos);

			grupos = controladorGrupo.cargarGrupos();

			ListSelectionModel selectionModelGrupos = table_Grupos.getSelectionModel();
			selectionModelGrupos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			for (Grupo grupo : grupos) {

				Vector<Object> fila = new Vector<Object>();
				fila.add(grupo.getNombre());

				modeloGrupos.addRow(fila);
			}

			scrollPane_Grupos.setViewportView(table_Grupos);
			panel.add(scrollPane_Grupos);

			JScrollPane scrollPane_Discos = new JScrollPane();
			scrollPane_Discos.setBounds(510, 362, 508, 392);
			panel.add(scrollPane_Discos);

			modeloDiscos = new DefaultTableModel(datoDiscos, columnaDiscos);
			table_Discos = new JTable(modeloDiscos);

			ListSelectionModel selectionModelDiscos = table_Discos.getSelectionModel();
			selectionModelDiscos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			scrollPane_Discos.setViewportView(table_Discos);

			JScrollPane scrollPane_canciones = new JScrollPane();
			scrollPane_canciones.setBounds(1057, 362, 407, 392);
			panel.add(scrollPane_canciones);

			modeloCanciones = new DefaultTableModel(datoCanciones, columnaCanciones);
			table_Canciones = new JTable(modeloCanciones);
			ListSelectionModel selectionModelCanciones = table_Canciones.getSelectionModel();
			selectionModelCanciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			scrollPane_canciones.setViewportView(table_Canciones);

			lbl_ImagenGrupo.setBounds(519, 29, 230, 228);
			panel.add(lbl_ImagenGrupo);

			lbl_imagenDisco.setBounds(1060, 26, 404, 231);
			panel.add(lbl_imagenDisco);

			JLabel lbl_descDisco = new JLabel("");
			lbl_descDisco.setForeground(new Color(255, 255, 255));
			lbl_descDisco.setBounds(1057, 267, 394, 76);
			panel.add(lbl_descDisco);

			JButton btn_Volver = new JButton("Volver");

			btn_Volver.setBounds(105, 58, 99, 26);
			panel.add(btn_Volver);

			JButton btn_Perfil = new JButton("Perfil");

			btn_Perfil.setBounds(105, 169, 99, 26);
			panel.add(btn_Perfil);

			JButton btn_Reproducir = new JButton("Reproducir");

			btn_Reproducir.setEnabled(false);
			btn_Reproducir.setBounds(1365, 760, 99, 26);
			panel.add(btn_Reproducir);

			JLabel lbl_descGrupo = new JLabel("");
			lbl_descGrupo.setForeground(new Color(255, 255, 255));
			lbl_descGrupo.setBounds(772, 29, 246, 157);
			panel.add(lbl_descGrupo);

			JLabel lbl_FechaFormacion = new JLabel("");
			lbl_FechaFormacion.setForeground(new Color(255, 255, 255));
			lbl_FechaFormacion.setBounds(936, 193, 76, 31);
			panel.add(lbl_FechaFormacion);

			JLabel lbl_FondoGrupo = new JLabel("");
			lbl_FondoGrupo.setBounds(0, 0, 1499, 878);
			lbl_FondoGrupo.setIcon(new ImageIcon(PanelGrupo.class.getResource("/Imagenes/grupos-podcast.png")));
			panel.add(lbl_FondoGrupo);

			selectionModelGrupos.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					try {
						if (!e.getValueIsAdjusting()) {
							int selectedRowGrupo = table_Grupos.getSelectedRow();
							if (selectedRowGrupo != -1) {

								Object nombre = table_Grupos.getValueAt(selectedRowGrupo, 0);
								nombreGrupo = "";
								nombreGrupo = nombre + "";
								datosgrupo = controladorGrupo.cargarDatosGrupo(nombreGrupo);
								btn_Reproducir.setEnabled(false);
								for (int i = 0; i < datosgrupo.size(); i++) {
									lbl_descGrupo.setText(datosgrupo.get(i).getDescripcion());
									String fechaFormacion = datosgrupo.get(i).getFechaFormacion() + "";
									lbl_FechaFormacion.setText(fechaFormacion);
									montarImagen(datosgrupo.get(i).getImagen());

								}
								controladorGrupo.cargarCanciones(nombreGrupo);
								modeloDiscos.setRowCount(0);
								modeloCanciones.setRowCount(0);
								discos = new ArrayList<Disco>();
								discos = controladorGrupo.cargarDiscos(nombreGrupo);

								for (Disco disco : discos) {
									Vector<Object> fila = new Vector<Object>();
									fila.add(disco.getTitulo());

									modeloDiscos.addRow(fila);
								}

							}
						}
					} catch (SQLException slqEx) {
						JOptionPane.showMessageDialog(panel, "Problemas con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
						
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(panel, "Problemas genericos", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
				}
			});

			selectionModelDiscos.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					try {
						if (!e.getValueIsAdjusting()) {
							int selectedRow = table_Discos.getSelectedRow();
							if (selectedRow != -1) {

								Object nombre = table_Discos.getValueAt(selectedRow, 0);
								nombreDisco = nombre + "";
								btn_Reproducir.setEnabled(false);

								datosDiscos = new ArrayList<Disco>();
								datosDiscos = controladorGrupo.cargarDatosDisco(nombreDisco);

								for (int i = 0; i < datosDiscos.size(); i++) {
									lbl_descDisco.setText(datosDiscos.get(i).getDescripcion());
									imagenStringDisco = datosDiscos.get(i).getImagen();
									montarImagenDisco(imagenStringDisco);
								}

								canciones = new ArrayList<Cancion>();
								canciones = controladorGrupo.cargarCanciones(nombreDisco);

								modeloCanciones.setRowCount(0);
								for (Cancion cancion : canciones) {
									Vector<Object> fila = new Vector<Object>();
									fila.add(cancion.getTitulo());

									modeloCanciones.addRow(fila);
								}

							}
						}
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(panel, "Problemas con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
					} catch (Exception generico) {
						JOptionPane.showMessageDialog(panel, "Problema generico", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			});

			selectionModelCanciones.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						int selectedRow = table_Canciones.getSelectedRow();
						if (selectedRow != -1) {

							Object nombre = table_Canciones.getValueAt(selectedRow, 0);
							nombreCancion = nombre + "";
							btn_Reproducir.setEnabled(true);

						}
					}
				}
			});

			btn_Volver.addActionListener(new ActionListener() {
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

			btn_Perfil.addActionListener(new ActionListener() {
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

			btn_Reproducir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Sesion.getInstance().setNombreCancion(nombreCancion);
					Sesion.getInstance().setNombreDisco(nombreDisco);
					Sesion.getInstance().setNombreGrupo(nombreGrupo);

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

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(panel, "Error con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(panel, "Problema generico", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void montarImagenDisco(String imagenSting) {
		byte[] imagenBytes = Base64.getDecoder().decode(imagenSting);
		ImageIcon imageIcon = new ImageIcon(imagenBytes);
		lbl_imagenDisco.setIcon(imageIcon);
	}

	private void montarImagen(String imagenString) {
		byte[] imagenBytes = Base64.getDecoder().decode(imagenString);
		ImageIcon imageIcon = new ImageIcon(imagenBytes);
		lbl_ImagenGrupo.setIcon(imageIcon);

	}

	public JPanel getPanel() {
		return panel;
	}
}
