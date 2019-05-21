package core;

import org.junit.Test;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import core.Driver;
import core.InfoScreen;
import core.Sieg;
import core.Spiel;

public class TicTacToeTests {
  public Dimension screen;
  
  public TicTacToeTests() {
    screen = Toolkit.getDefaultToolkit().getScreenSize();
  }

  @Test
  public void driverScreenSizeTest() {
    Driver driver = new Driver();
    Dimension d = driver.getSize();
    assert (screen.width == d.width);
    assert (screen.height == d.height);
  }
  
  @Test
  public void infoScreenTest() {
    Image i = Toolkit.getDefaultToolkit().getImage("src/main/resources/regeln.jpg");
    InfoScreen is = new InfoScreen(new Driver(), i);
    assert (is.background != null);
  }
  
  @Test
  public void siegTest() {
    Sieg s = new Sieg(new Driver());
    s.setSieger(1);
    int sieger = s.getSieger();
    assert (sieger == 1);
  }
  
  @Test
  public void spielTest() {
    Spiel s = new Spiel(new Driver());
    int[][] field = s.getField();
    
    for (int i = 0; i < 3; i++) {
    	for (int j = 0; j < 3; j++) {
    		assert (field[i][j] == 0);
    	}
    }
  }
}
