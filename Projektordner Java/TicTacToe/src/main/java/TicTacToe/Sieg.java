package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Sieg extends InfoScreen {
  private String text;

  private Image txt;
  private Rectangle txtDim;
  
  public Sieg(Driver driver) {
	super(driver, driver.getToolkit().getImage("src/main/resources/hintergrund.jpg"));
	text = "";
	  
	txt = this.getToolkit().getImage("src/main/resources/old/regelnTxt.png");
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

  public void setText(String s) {
    this.text = s;
  }

  @Override
  public void paint(Graphics g) {
	  super.paint(g);
	  paintTxt(g);
	  
	  //g.drawString(text, 100, 100);
  }

  public void paintTxt(Graphics g) {
	  g.drawImage(txt, txtDim.x, txtDim.y, txtDim.width, txtDim.height, this);
  }
}
