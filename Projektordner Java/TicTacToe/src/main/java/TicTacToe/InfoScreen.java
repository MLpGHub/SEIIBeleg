package TicTacToe;

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
 * Superklasse für Spiel und Sieg
 * 
 * @author s76954
 *
 */
public class InfoScreen extends Panel {
  protected Driver driver;
  protected Image background;
  protected Image backButton;
  protected Rectangle backDimension;

  /**
   * Initialisierung des InfoScreens
   * 
   * @param driver     Referenz des übergeordneten Treibers
   * @param background Hintergrundbild
   */
  public InfoScreen(Driver driver, Image background) {
    this.driver = driver;
    this.setLayout(null);

    this.background = background;
    this.backButton = this.getToolkit().getImage("src/main/resources/ingamebutton_zurueck.jpg");

    MediaTracker m = new MediaTracker(this);
    m.addImage(this.background, 1);
    m.addImage(this.backButton, 2);
    try {
      m.waitForAll();
    } catch (Exception e) {
      System.out.println(e);
    }

    double factor = 1;
    Dimension d = driver.getSize();
    int margin = 50;

    int bx = (int) (backButton.getWidth(this) * factor);
    int by = (int) (backButton.getHeight(this) * factor);
    backDimension = new Rectangle(d.width - margin - bx, d.height - margin - by, bx, by);

    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if ((p.x >= backDimension.x) && (p.x <= backDimension.x + backDimension.width)
            && (p.y >= backDimension.y) && (p.y <= backDimension.y + backDimension.height)) { // zurück-Button
          driver.showMenu();
        }
      }
    });
  }

  /**
   * Zeichnen des InfoScreens
   */
  @Override
  public void paint(Graphics g) {
    paintBackground(g);
    paintBackButton(g);
  }

  /**
   * Zeichnen des Hintergrundes
   * 
   * @param g Grafik-Kontext
   */
  public void paintBackground(Graphics g) {
    Dimension d = this.getPreferredSize();
    g.drawImage(background, 0, 0, d.width, d.height, this);
  }

  /**
   * Zeichnen des Zurück-Buttons
   * 
   * @param g Grafik-Kontext
   */
  public void paintBackButton(Graphics g) {
    g.drawImage(backButton, backDimension.x, backDimension.y, backDimension.width,
        backDimension.height, this);
  }
}
