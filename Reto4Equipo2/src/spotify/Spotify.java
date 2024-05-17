package spotify;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import spotify.vista.PanelAdministrador;
import spotify.vista.PanelBienvenida;
import spotify.vista.PanelFavoritos;
import spotify.vista.PanelGrupo;
import spotify.vista.PanelInicioSesion;
import spotify.vista.PanelPerfil;
import spotify.vista.PanelPodcast;
import spotify.vista.PanelPrincipal;
import spotify.vista.PanelRegistro;
import spotify.vista.PanelReproduccion;

public class Spotify {
	private JFrame frame;
	public ArrayList<JPanel> paneles = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Spotify().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Spotify() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1499, 878);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/**
		 * Se encuentra la lista que contiene los paneles
		 */
		paneles = new ArrayList<JPanel>();

		/**
		 * Se crea el gestor y el PanelBienvenida. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelBienvenida panelBienvenida = new PanelBienvenida(paneles);
		JPanel panel1 = panelBienvenida.getPanel();
		panel1.setVisible(true);

		paneles.add(panel1);
		frame.getContentPane().add(panel1);

		/**
		 * Se crea el gestor y el PanelLogin. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelInicioSesion panelLogin = new PanelInicioSesion(paneles);
		JPanel panel2 = panelLogin.getPanel();
		panel2.setVisible(false);

		paneles.add(panel2);
		frame.getContentPane().add(panel2);

		/**
		 * Se crea el gestor y el PanelRegistro. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelRegistro panelRegistro = new PanelRegistro(paneles);
		JPanel panel3 = panelRegistro.getPanel();
		panel3.setVisible(false);

		paneles.add(panel3);
		frame.getContentPane().add(panel3);
		
		/**
		 * Se crea el gestor y el PanelPrincipal. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelPrincipal panelPrincipal = new PanelPrincipal(paneles);
		JPanel panel4 = panelPrincipal.getPanel();
		panel4.setVisible(false);

		paneles.add(panel4);
		frame.getContentPane().add(panel4);
		
		/**
		 * Se crea el gestor y el PanelGrupo. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelGrupo panelGrupo= new PanelGrupo(paneles);
		JPanel panel5 = panelGrupo.getPanel();
		panel5.setVisible(false);

		paneles.add(panel5);
		frame.getContentPane().add(panel5);
		
		/**
		 * Se crea el gestor y el PanelPodcast. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelPodcast panelPodcast = new PanelPodcast(paneles);
		JPanel panel6 = panelPodcast.getPanel();
		panel6.setVisible(false);
		
		paneles.add(panel6);
		frame.getContentPane().add(panel6);
		
		/**
		 * Se crea el gestor y el PanelReproduccion. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelReproduccion panelReproduccion = new PanelReproduccion(paneles);
		JPanel panel7 = panelReproduccion.getPanel();
		panel7.setVisible(false);
		
		paneles.add(panel7);
		frame.getContentPane().add(panel7);
		
		/**
		 * Se crea el gestor y el PanelFavoritos. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelFavoritos panelFavoritos = new PanelFavoritos(paneles);
		JPanel panel8 = panelFavoritos.getPanel();
		panel8.setVisible(false);
		
		paneles.add(panel8);
		frame.getContentPane().add(panel8);
		
		/**
		 * Se crea el gestor y el PanelPerfil. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelPerfil panelPerfil = new PanelPerfil(paneles);
		JPanel panel9 = panelPerfil.getPanel();
		panel9.setVisible(false);
		
		paneles.add(panel9);
		frame.getContentPane().add(panel9);
		
		/**
		 * Se crea el gestor y el PanelPerfil. Y lo pasamos a la lista por el constructor
		 * y metemos lo metemos en la lista y ventana
		 */
		PanelAdministrador panelAdministrador = new PanelAdministrador(paneles);
		JPanel panel10 = panelAdministrador.getPanel();
		panel10.setVisible(false);
		
		paneles.add(panel10);
		frame.getContentPane().add(panel10);
		
	}
}
