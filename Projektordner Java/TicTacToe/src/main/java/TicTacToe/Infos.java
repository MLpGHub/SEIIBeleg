package TicTacToe;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;

public class Infos extends InfoScreen {
	private Image txt;
	private Rectangle txtDim;
	
	public Infos(Driver driver) {
		super(driver, driver.getToolkit().getImage("src/main/resources/infos.png"));
		
		txt = this.getToolkit().getImage("src/main/resources/regelnTxt.png"); //muss noch geändert werden!
		MediaTracker m = new MediaTracker(this);
		m.addImage(txt, 1);
		try {
			m.waitForAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		double factor = 2/3.;
		Dimension d = driver.getSize();
		int dx = (int)(txt.getWidth(this) * factor);
		int dy = (int)(txt.getHeight(this) * factor);
		txtDim = new Rectangle((d.width - dx) / 2, (d.height - dy) / 2, dx, dy);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		paintTxt(g);
	}
	
	public void paintTxt(Graphics g) {
		g.drawImage(txt, txtDim.x, txtDim.y, txtDim.width, txtDim.height, this);
	}
}
