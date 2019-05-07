package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Sieg extends InfoScreen {
  private int sieger;

  private Image unentschieden;
  private Image spieler1;
  private Image spieler2;
  private Rectangle iDim;
  
  public Sieg(Driver driver) {
	super(driver, driver.getToolkit().getImage("src/main/resources/hintergrund.jpg"));
	sieger = 0;
	
	unentschieden = this.getToolkit().getImage("src/main/resources/ergebnis_unentschieden.jpg");
	spieler1 = this.getToolkit().getImage("src/main/resources/ergebnis_O_gewinnt.jpg");
	spieler2 = this.getToolkit().getImage("src/main/resources/ergebnis_X_gewinnt.jpg");
	
	MediaTracker m = new MediaTracker(this);
	m.addImage(unentschieden, 1);
	m.addImage(spieler1, 2);
	m.addImage(spieler2, 3);
	try {
		m.waitForAll();
	} catch (Exception e) {
		System.out.println(e);
	}
	
	Dimension d = driver.getSize();
	int dx = 893;
	int dy = 341;
	iDim = new Rectangle((d.width - dx) / 2, (d.height - dy) / 2, dx, dy);
  }

  public void setSieger(int s) {
    this.sieger = s;
  }

  @Override
  public void paint(Graphics g) {
	  super.paint(g);
	  paintTxt(g);
	  
	  //g.drawString(text, 100, 100);
  }

  public void paintTxt(Graphics g) {
	  switch (sieger) {
	  case 0: g.drawImage(unentschieden, iDim.x, iDim.y, this); break;
	  case 1: g.drawImage(spieler1, iDim.x, iDim.y, this); break;
	  case -1: g.drawImage(spieler2, iDim.x, iDim.y, this); break;
	  }
	  //g.drawImage(txt, txtDim.x, txtDim.y, txtDim.width, txtDim.height, this);
  }
}
