package TicTacToe;

//noch entfernen und durch ausschließlich benötigte Pakete ersetzen
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import org.junit.jupiter.api.Test;

class TicTacToeTests {
  public Dimension screen;
  public BufferedImage img;
  public Graphics g;
  
  public TicTacToeTests() {
    screen = Toolkit.getDefaultToolkit().getScreenSize();
    img = new BufferedImage(screen.width, screen.height, BufferedImage.TYPE_INT_ARGB);
    g = img.createGraphics();
  }

  // DRIVER
  
  @Test
  void driverScreenSizeTest() {
    Driver driver = new Driver();
    Dimension d = driver.getSize();
    assert (screen.width == d.width);
    assert (screen.height == d.height);
  }
  
  @Test
  void driverTest() {
    Driver driver = new Driver();
    driver.paint(g);
    driver.getWindowListeners();
    // CardLayout weiß nicht, was grad gezeigt wird
    // -> schlechte Überprüfung von show*()
  }

  // INFOSCREEN
  
  @Test
  void infoScreenTest() {
    Image i = Toolkit.getDefaultToolkit().getImage("src/main/resources/regeln.jpg");
    InfoScreen is = new InfoScreen(new Driver(), i);
    is.getMouseListeners();
    // folgende Member sind protected und deshalb nach außen sich- und zugreifbar:
    assert (is.background != null);
    assert (is.backButton != null);
    assert (is.driver != null);
    assert (is.backDimension != null);
    // paint, paintBackground, paintBackButton
  }
  
  @Test
  void infoScreenPaintTest() {
    Image i = Toolkit.getDefaultToolkit().getImage("src/main/resources/regeln.jpg");
    InfoScreen is = new InfoScreen(new Driver(), i);
    is.paint(g);
  }
  
  // MENU
  
  @Test
  void menuTest() {
    Menu m = new Menu(new Driver());
    m.getMouseListeners();
 // paint, paintBackground, paintStart, paintRegeln, paintInfos
  }
  
  @Test
  void menuPaintTest() {
    Menu m = new Menu(new Driver());
    m.paint(g);
  }
  
  // SIEG

  
  @Test
  void siegTest() {
    Sieg s = new Sieg(new Driver());
    s.setSieger(1);
 // paint, paintTxt
  }
  
  @Test
  void siegPaintTest() {
    Sieg s = new Sieg(new Driver());
    s.paint(g);
  }
  
  // SPIEL
  
  @Test
  void spielTest() {
    Spiel s = new Spiel(new Driver());
    s.getMouseListeners();
    s.clearField();
    s.validateField();
  }
  
  @Test
  void spielPaintTest() {
    Spiel s = new Spiel(new Driver());
    s.paint(g);
  }
  
}
