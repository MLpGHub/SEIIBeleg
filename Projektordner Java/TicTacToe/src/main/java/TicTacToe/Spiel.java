package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Spiel extends InfoScreen {
	private int[][] field;
	private boolean state;
	private int cEdge, offX, offY;
	
	private Button[][] fieldb;
	private ActionListener al;

	public Spiel(Driver driver) {
		super(driver, driver.getToolkit().getImage("src/main/resources/spielen.png"));

		state = false;
		
		Dimension d = driver.getSize();
		cEdge = 330;
		offX = (d.width - 3 * cEdge) / 2;
		offY = (d.height - 3 * cEdge) / 2;
		
		
		al = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Button b = (Button)e.getSource();
				if (state) b.setLabel("X");
				else b.setLabel("O");
				b.setEnabled(false);
				state = !state;
				//validate_b();
				//validateField();
			}
		};
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int x = p.x - offX;
				int y = p.y - offY;
				int i, j;
				
				if (x > 3 * cEdge || y > 3 * cEdge) {
					return;
				}
				
				i = y / cEdge;
				j = x / cEdge;

				//disable filled cells
				if (field[i][j] != 0) return;
				
				if (state) field[i][j] = 1;
				else field[i][j] = -1;
				
				//draw Cell??
				//quick and dirty...
				repaint();
				
				state = !state;
				validateField();
	    		/*
	    		if (p.x => minx && p.x <= maxx && p.y => miny && p.y <= maxy) {
	    			//
	    		}
	    		 */
			}});

		//this.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));

		fieldb = new Button[3][3];
		
		field = new int[3][3];
		clearField();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				fieldb[i][j] = new Button();
				System.out.println(fieldb[i][j].getLabel());
				fieldb[i][j].addActionListener(al);
				fieldb[i][j].setFocusable(false);
				this.add(fieldb[i][j]);
				fieldb[i][j].setBounds(100+j*110, 100+i*60, 100, 50);
			}
		}
	}

	public void clearField() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				field[i][j] = 0;
			}
		}
	}
	
	public void validate_b() {
		char c = ' ';
		int checked = 0;
		boolean[] checks = new boolean[8];
		checks[0] = fieldb[0][0].getLabel() != "" && fieldb[0][0].getLabel() == fieldb[0][1].getLabel() && fieldb[0][0].getLabel() == fieldb[0][2].getLabel();
		checks[1] = fieldb[0][0].getLabel() != "" && fieldb[0][0].getLabel() == fieldb[1][0].getLabel() && fieldb[0][0].getLabel() == fieldb[2][0].getLabel();
		checks[2] = fieldb[0][0].getLabel() != "" && fieldb[0][0].getLabel() == fieldb[1][1].getLabel() && fieldb[0][0].getLabel() == fieldb[2][2].getLabel();
		checks[3] = fieldb[0][1].getLabel() != "" && fieldb[0][1].getLabel() == fieldb[1][1].getLabel() && fieldb[0][1].getLabel() == fieldb[2][1].getLabel();
		checks[4] = fieldb[0][2].getLabel() != "" && fieldb[0][2].getLabel() == fieldb[1][2].getLabel() && fieldb[0][2].getLabel() == fieldb[2][2].getLabel();
		checks[5] = fieldb[1][0].getLabel() != "" && fieldb[1][0].getLabel() == fieldb[1][1].getLabel() && fieldb[1][0].getLabel() == fieldb[1][2].getLabel();
		checks[6] = fieldb[2][0].getLabel() != "" && fieldb[2][0].getLabel() == fieldb[2][1].getLabel() && fieldb[2][0].getLabel() == fieldb[2][2].getLabel();
		checks[7] = fieldb[2][0].getLabel() != "" && fieldb[2][0].getLabel() == fieldb[1][1].getLabel() && fieldb[2][0].getLabel() == fieldb[0][2].getLabel();
	
		if (checks[0] || checks[1] || checks[2]) {
			c = fieldb[0][0].getLabel().toCharArray()[0];
		} else if (checks[3]) {
			c = fieldb[0][1].getLabel().toCharArray()[0];
		} else if (checks[4]) {
			c = fieldb[0][2].getLabel().toCharArray()[0];
		} else if (checks[5]) {
			c = fieldb[1][0].getLabel().toCharArray()[0];
		} else if (checks[6] || checks[7]) {
			c = fieldb[2][0].getLabel().toCharArray()[0];
		}
	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (fieldb[i][j].getLabel() != "") {
					checked++;
				}
			}
		}
		
		if (checked == 9) {
			fieldb[0][0].setLabel(""); //clear fieldb
			clearField();
			driver.showSieg("Unentschieden!");
		} else if (c == ' ') {
			return;
		} else {
			fieldb[0][0].setLabel(""); //clear fieldb
			clearField();
			driver.showSieg(""+c+ " hat gewonnen!"); //getDriver()
		}
	}
	
	public void validateField() {
		int checked = 0;
		int[] calculations = new int[8];
		//horizontal
		calculations[0] = field[0][0] + field[0][1] + field[0][2];
		calculations[1] = field[1][0] + field[1][1] + field[1][2];
		calculations[2] = field[2][0] + field[2][1] + field[2][2];
		//vertikal
		calculations[3] = field[0][0] + field[1][0] + field[2][0];
		calculations[4] = field[0][1] + field[1][1] + field[2][1];
		calculations[5] = field[0][2] + field[1][2] + field[2][2];
		//diagonal
		calculations[6] = field[0][0] + field[1][1] + field[2][2];
		calculations[7] = field[2][0] + field[1][1] + field[0][2];
		
		//Hat jemand gewonnen?
		for (int i = 0; i < 8; i++) {
			if (calculations[i] == 3) {
				clearField();
				driver.showSieg("Spieler 1 hat gewonnen!");
			} else if (calculations[i] == -3) {
				clearField();
				driver.showSieg("Spieler 2 hat gewonnen!");
			}
		}
		
		//Unentschieden?
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if (field[j][k] != 0) {
					checked++;
				}
			}
		}
		if (checked == 9) {
			clearField();
			driver.showSieg("Unentschieden!");
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//tmp
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("field[" + i + "][" + j + "]=" + field[i][j]);
				if (field[i][j] == 1) {
					g.setColor(Color.cyan);
					g.fillRect(offX + j * cEdge, offY + i * cEdge, cEdge, cEdge);
				} else if (field[i][j] == -1) {
					g.setColor(Color.orange);
					g.fillRect(offX + j * cEdge, offY + i * cEdge, cEdge, cEdge);
				} else {
					g.setColor(Color.black);
					g.drawRect(offX + j * cEdge, offY + i * cEdge, cEdge, cEdge);
				}
			}
		}
	}
}
