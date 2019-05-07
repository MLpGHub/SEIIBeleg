package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Spiel extends InfoScreen {
	private int[][] field;
	private boolean state;
	private int cEdge, offX, offY;
	private Image o;
	private Image x;

	public Spiel(Driver driver) {
		super(driver, driver.getToolkit().getImage("src/main/resources/spielfeld.jpg"));

		o = this.getToolkit().getImage("src/main/resources/zeichen_O_ohne_hintergrund.png"); //zeichen_O_mit_hintergrund.jpg
		x = this.getToolkit().getImage("src/main/resources/zeichen_X_ohne_hintergrund.png"); //zeichen_X_mit_hintergrund.jpg
		
		state = false;
		
		Dimension d = driver.getSize();
		cEdge = 250;
		offX = (d.width - 3 * cEdge) / 2;
		offY = (d.height - 3 * cEdge) / 2 - 10;
		
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
			}});
		
		field = new int[3][3];
		clearField();
	}

	public void clearField() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				field[i][j] = 0;
			}
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
				driver.showSieg(1);
			} else if (calculations[i] == -3) {
				clearField();
				driver.showSieg(-1);
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
			driver.showSieg(0);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int iEdge = 165;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				//System.out.println("field[" + i + "][" + j + "]=" + field[i][j]);
				if (field[i][j] == 1) {
					g.setColor(Color.cyan);
					//g.fillRect(offX + j * cEdge, offY + i * cEdge, cEdge, cEdge);
					g.drawImage(o, offX + j * cEdge + 42, offY + i * cEdge + 42, iEdge, iEdge, this);
				} else if (field[i][j] == -1) {
					g.setColor(Color.orange);
					//g.fillRect(offX + j * cEdge, offY + i * cEdge, cEdge, cEdge);
					g.drawImage(x, offX + j * cEdge + 42, offY + i * cEdge + 42, iEdge, iEdge, this);
				} else {
					g.setColor(Color.black);
					//g.drawRect(offX + j * cEdge, offY + i * cEdge, iEdge, iEdge);
				}
			}
		}
	}
}
