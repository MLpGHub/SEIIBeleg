package TicTacToe;
import java.awt.*;
import java.awt.event.*;

//parent class for Regeln, Infos and maybe also Sieg

public abstract class InfoScreen extends Panel {
  protected Driver driver;
  //protected Button back;
  protected Image background;
  protected Image backButton;
  protected Rectangle backDimension;

  public InfoScreen(Driver driver, Image background) {
    this.driver = driver;
    this.setLayout(null);

    this.background = background;
    this.backButton = this.getToolkit().getImage("src/main/resources/ZurückButton.png");
    
    MediaTracker m = new MediaTracker(this);
    m.addImage(this.background, 1);
    m.addImage(this.backButton, 2);
    try {
    	m.waitForAll();
    } catch (Exception e) {
    	System.out.println(e);
    }
    
    
    double factor = 2/3.;
    Dimension d = this.getPreferredSize();
    d = driver.getSize();
    int margin = 50;
    
    int bx = (int)(backButton.getWidth(this) * factor);
	int by = (int)(backButton.getHeight(this) * factor);
    backDimension = new Rectangle(d.width - margin - bx, d.height - margin - by, bx, by);
    
    this.addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		Point p = e.getPoint();
    		if ((p.x >= backDimension.x) && (p.x <= backDimension.x + backDimension.width) 
    			&& (p.y >= backDimension.y) && (p.y <= backDimension.y + backDimension.height)) { //zurück-Button
    			driver.showMenu();
    		}
    		/*
    		if (p.x => minx && p.x <= maxx && p.y => miny && p.y <= maxy) {
    			//
    		}
    		 */
    	}});
    
  }
  
  @Override
  public void paint(Graphics g) {
	  //Dimension d = this.getPreferredSize();
	  
	  
	  paintBackground(g);
	  paintBackButton(g);
  }
  
  public void paintBackground(Graphics g) {
	  Dimension d = this.getPreferredSize();
	  g.drawImage(background, 0, 0, d.width, d.height, this);
  }
  
  public void paintBackButton(Graphics g) {
	  g.drawImage(backButton,  backDimension.x,  backDimension.y, backDimension.width, backDimension.height, this);
  }
}
