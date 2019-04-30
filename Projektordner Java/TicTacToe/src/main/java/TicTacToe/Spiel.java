package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Spiel extends InfoScreen {
	private Button[][] fieldb;
	private int[][] field;
	private boolean state;
	private ActionListener al;

	public Spiel(Driver driver) {
		super(driver, driver.getToolkit().getImage("src/main/resources/spielen.png"));

		state = false;
		al = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Button b = (Button)e.getSource();
				if (state) b.setLabel("X");
				else b.setLabel("O");
				b.setEnabled(false);
				state = !state;
				validate();
			}
		};

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
	
	public void validate() {
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
}
