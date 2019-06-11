package core;

import org.junit.Ignore;
import org.junit.Test;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
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
    Image i = Toolkit.getDefaultToolkit().getImage("src/core/resources/regeln.jpg");
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

  @Test
  //@Ignore
  public void aboutTest() {
    BufferedImage ai = null;
    try {
      //System.out.println("Working Directory = " + System.getProperty("user.dir"));
      ai = ImageIO.read(new FileImageInputStream(new File("../resources/about.jpg")));
    } catch (Exception e) {
      System.out.println(e);
    }
    InfoScreen about = new InfoScreen(new Driver(), ai);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage testImg = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
    Graphics testg = testImg.getGraphics();
    int[] refData = new int[(ByteBuffer.wrap(((DataBufferByte)ai.getData().getDataBuffer()).getData()).asIntBuffer()).remaining()];
    int[] testData;
    
    about.paint(testg);
    testData = ((DataBufferInt)testImg.getData().getDataBuffer()).getData();
    
    //System.out.println("len(rD)=" + refData.length + ", len(tD)=" + testData.length);
    
    for (int i = 0; i < refData.length; i++) {
      //System.out.println("a[i]=" + a[i] + ", tD[i]=" + testData[i]);
      //System.out.println("rD[i] = " + String.format("0x%08X", refData[i]) 
      //  + ", tD[i] = " + testData[i]);
      assert(refData[i] == testData[i]);
    }
  }
}
