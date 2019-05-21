package core;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Klasse des Spielmenüs
 * 
 * @author s76954
 *
 */
public class Menu extends Panel {
  private Driver driver;
  private Image img;

  private Image start;
  private Image regeln;
  private Image infos;
  private Rectangle startDim;
  private Rectangle regelnDim;
  private Rectangle infosDim;

  /**
   * Initialisiert das Menü samt Grafiken
   * 
   * @param driver Referenz zum übergeordneten Treiber
   */
  public Menu(Driver driver) {
    this.driver = driver;
    this.setLayout(null);

    this.img = this.getToolkit().getImage("resources/hintergrund_menue.jpg");
    this.start = this.getToolkit().getImage("resources/menuebutton_start.jpg");
    this.regeln = this.getToolkit().getImage("resources/menuebutton_regeln.jpg");
    this.infos = this.getToolkit().getImage("resources/menuebutton_info.jpg");
    MediaTracker mt = new MediaTracker(this);
    mt.addImage(img, 1);
    mt.addImage(start, 2);
    mt.addImage(regeln, 3);
    mt.addImage(infos, 4);
    try {
      mt.waitForAll();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Scaling for the buttons, just legacy code
    double factor = 1;
    Dimension d = driver.getSize();

    int sx = (int) (start.getWidth(this) * factor);
    int sy = (int) (start.getHeight(this) * factor);
    startDim = new Rectangle((d.width - sx) / 2, 520, sx, sy);

    int rx = (int) (regeln.getWidth(this) * factor);
    int ry = (int) (regeln.getHeight(this) * factor);
    regelnDim = new Rectangle((d.width - rx) / 2, 685, rx, ry);

    int ix = (int) (infos.getWidth(this) * factor);
    int iy = (int) (infos.getHeight(this) * factor);
    infosDim = new Rectangle((d.width - ix) / 2, 850, ix, iy);

    // Eventhandler for the buttons
    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if ((p.x >= startDim.x) && (p.x <= startDim.x + startDim.width) && (p.y >= startDim.y)
            && (p.y <= startDim.y + startDim.height)) { // Start-Button
          driver.showSpiel();
        }
        if ((p.x >= regelnDim.x) && (p.x <= regelnDim.x + regelnDim.width) && (p.y >= regelnDim.y)
            && (p.y <= regelnDim.y + regelnDim.height)) { // Regeln-Button
          driver.showRegeln();
        }
        if ((p.x >= infosDim.x) && (p.x <= infosDim.x + infosDim.width) && (p.y >= infosDim.y)
            && (p.y <= infosDim.y + infosDim.height)) { // Infos-Button
          driver.showInfos();
        }
      }
    });
  }

  /**
   * Zeichnet die Menü-Anzeige
   */
  @Override
  public void paint(Graphics g) {
    paintBackground(g);
    paintStart(g);
    paintRegeln(g);
    paintInfos(g);
  }

  /**
   * Zeichnen des Hintergrundes
   * 
   * @param g Grafik-Kontext
   */
  public void paintBackground(Graphics g) {
    Dimension d = this.getPreferredSize();
    g.drawImage(img, 0, 0, d.width, d.height, this);
  }

  /**
   * Zeichnen des Start-Buttons
   * 
   * @param g Grafik-Kontext
   */
  public void paintStart(Graphics g) {
    g.drawImage(start, startDim.x, startDim.y, startDim.width, startDim.height, this);
  }

  /**
   * Zeichnen des Regeln-Buttons
   * 
   * @param g Grafik-Kontext
   */
  public void paintRegeln(Graphics g) {
    g.drawImage(regeln, regelnDim.x, regelnDim.y, regelnDim.width, regelnDim.height, this);
  }

  /**
   * Zeichnen des Info-Buttons
   * 
   * @param g Grafik-Kontext
   */
  public void paintInfos(Graphics g) {
    g.drawImage(infos, infosDim.x, infosDim.y, infosDim.width, infosDim.height, this);
  }
}
