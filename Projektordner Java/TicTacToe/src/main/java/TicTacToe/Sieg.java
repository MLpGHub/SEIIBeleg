package TicTacToe;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;

/**
 * Anzeige für das Spielergebnis
 * 
 * @author s76954
 *
 */
public class Sieg extends InfoScreen {
  private int sieger;

  private Image unentschieden;
  private Image spieler1;
  private Image spieler2;
  private Rectangle iDim;

  /**
   * Initialsiert den Sieg-Bildschirm und lädt die benötigten Bilder
   * 
   * @param driver Referenz zum übergeordneten Treiber
   */
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

  /**
   * Setzt die Informationen zum Sieger
   * 
   * @param s gewinnender Spieler
   */
  public void setSieger(int s) {
    this.sieger = s;
  }

  /**
   * Zeichnen des Sieg-Bildschirms
   */
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    paintTxt(g);
  }

  /**
   * Zeichnet die entsprechende Gewinn-Grafik
   * 
   * @param g Grafik-Kontext
   */
  public void paintTxt(Graphics g) {
    switch (sieger) {
      case 0:
        g.drawImage(unentschieden, iDim.x, iDim.y, this);
        break;
      case 1:
        g.drawImage(spieler1, iDim.x, iDim.y, this);
        break;
      case -1:
        g.drawImage(spieler2, iDim.x, iDim.y, this);
        break;
    }
  }
}
