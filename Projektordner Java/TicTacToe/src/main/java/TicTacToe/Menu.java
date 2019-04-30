package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Menu extends Panel {
	private Driver driver;
	private Image img;
	
	private Image start;
	private Image regeln;
	private Image infos;
	private Rectangle startDim;
	private Rectangle regelnDim;
	private Rectangle infosDim;

	private Button exit; //temporary exit button

	public Menu(Driver driver) {
		this.driver = driver;
		this.setLayout(null);
		this.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 30));

		this.img = this.getToolkit().getImage("src/main/resources/menu.png");
		this.start = this.getToolkit().getImage("src/main/resources/StartenButton.png");
		this.regeln = this.getToolkit().getImage("src/main/resources/RegelnButton.png");
		this.infos = this.getToolkit().getImage("src/main/resources/InfosButton.png");
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

		
		double factor = 2/3.;
	    Dimension d = driver.getSize();
	    
	    int sx = (int)(start.getWidth(this) * factor);
		int sy = (int)(start.getHeight(this) * factor);
	    startDim = new Rectangle((d.width - sx) / 2, 100, sx, sy);
		
	    int rx = (int)(regeln.getWidth(this) * factor);
		int ry = (int)(regeln.getHeight(this) * factor);
	    regelnDim = new Rectangle((d.width - rx) / 2, 400, rx, ry);
	    
	    int ix = (int)(infos.getWidth(this) * factor);
		int iy = (int)(infos.getHeight(this) * factor);
	    infosDim = new Rectangle((d.width - ix) / 2, 700, ix, iy);
	    
		
	    this.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		Point p = e.getPoint();
	    		if ((p.x >= startDim.x) && (p.x <= startDim.x + startDim.width) 
	    			&& (p.y >= startDim.y) && (p.y <= startDim.y + startDim.height)) { //Start-Button
	    			driver.showSpiel();
	    		}
	    		if ((p.x >= regelnDim.x) && (p.x <= regelnDim.x +regelnDim.width) 
	    			&& (p.y >= regelnDim.y) && (p.y <= regelnDim.y + regelnDim.height)) { //Regeln-Button
	    			driver.showRegeln();
	    		}
	    		if ((p.x >= infosDim.x) && (p.x <= infosDim.x +infosDim.width) 
	    			&& (p.y >= infosDim.y) && (p.y <= infosDim.y + infosDim.height)) { //Infos-Button
	    			driver.showRegeln();
	    		}
	    		/*
	    		if (p.x => minx && p.x <= maxx && p.y => miny && p.y <= maxy) {
	    			//
	    		}
	    		 */
	    	}});
	    

		exit = new Button("Exit");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				driver.shutdown();
			}});

		this.add(exit);
		exit.setBounds(100, 900, 200, 50);
	}

	@Override
	public void paint(Graphics g) {
		paintBackground(g);
		paintStart(g);
		paintRegeln(g);
		paintInfos(g);
		
		//this.setFont(new Font("Comfortaa", Font.PLAIN, 30));
		//g.drawString("TicTacToe", 100, 50);
	}
	
	public void paintBackground(Graphics g) {
		Dimension d = this.getPreferredSize();
		g.drawImage(img, 0, 0, d.width, d.height, this);
	}
	
	public void paintStart(Graphics g) {
		g.drawImage(start, startDim.x, startDim.y, startDim.width, startDim.height, this);
	}
	
	public void paintRegeln(Graphics g) {
		g.drawImage(regeln, regelnDim.x, regelnDim.y, regelnDim.width, regelnDim.height, this);
	}
	
	public void paintInfos(Graphics g) {
		g.drawImage(infos, infosDim.x, infosDim.y, infosDim.width, infosDim.height, this);
	}
}
