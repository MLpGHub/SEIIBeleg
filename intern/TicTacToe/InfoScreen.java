import java.awt.*;
import java.awt.event.*;

//parent class for Regeln, Infos and maybe also Sieg

public class InfoScreen extends Panel {
  protected Driver driver;
  protected Button back;

  public InfoScreen(Driver driver) {
    this.driver = driver;
    this.setLayout(null);

    back = new Button("zurück");
    back.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        driver.showMenu();
      }});
    this.add(back);

    back.setBounds(600, 600, 100, 50);
  }
}
