package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Regeln extends InfoScreen {
	private Image txt;
	private Rectangle txtDim;
	
	public Regeln(Driver driver) {
		super(driver, driver.getToolkit().getImage("src/main/resources/regeln.png"));
		
		txt = this.getToolkit().getImage("src/main/resources/regelnTxt.png");
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
