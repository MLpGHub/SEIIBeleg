import java.awt.*;
import java.awt.event.*;

public class Sieg extends InfoScreen {
  private String text;

  public Sieg(Driver driver) {
    super(driver);
    text = "";
  }

  public void setText(String s) {
    this.text = s;
  }

  @Override
  public void paint(Graphics g) {
    //this.setFont(new Font("DejaVu Sans", Font.BOLD, 40));
    g.drawString(text, 100, 100);
  }

}
