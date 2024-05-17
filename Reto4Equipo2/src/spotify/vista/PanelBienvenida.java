package spotify.vista;

import java.util.ArrayList;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelBienvenida {

	private JPanel panel = null;
	public PanelBienvenida(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1499, 878);
		panel.setLayout(null);
		
		JLabel lbl_FondoBienvenida = new JLabel("");
		lbl_FondoBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
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
		lbl_FondoBienvenida.setIcon(new ImageIcon(PanelBienvenida.class.getResource("/Imagenes/Bienvenida.png")));
		lbl_FondoBienvenida.setBounds(0, 0, 1499, 878);
		panel.add(lbl_FondoBienvenida);
	}

	public JPanel getPanel() {
		return panel;
	}
}
