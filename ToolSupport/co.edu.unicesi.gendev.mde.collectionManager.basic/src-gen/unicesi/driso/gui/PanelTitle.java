package unicesi.driso.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitle extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelTitle() {
		setLayout(new BorderLayout());
		JLabel title = new JLabel();
		title.setText("MusicStore Information Manager");
		title.setFont(new Font(title.getFont().getName(), Font.BOLD, 16));
		double scale = 0.2;
		ImageIcon src = new ImageIcon("images/musicStore.png");
		int w = (int) (scale * src.getImage().getWidth(this));
		int h = (int) (scale * src.getImage().getHeight(this));
		int type = BufferedImage.TYPE_INT_RGB;
		BufferedImage dst = new BufferedImage(w, h, type);
		Graphics2D g2 = dst.createGraphics();
		g2.drawImage(src.getImage(), 0, 0, w, h, this);
		g2.dispose();
		title.setIcon(new ImageIcon(dst));
		add(title);
	}
}
