package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Spiel extends InfoScreen { //extends Panel
	private Button[][] field;
	private boolean state;
	private ActionListener al;

	public Spiel(Driver driver) {
		super(driver);

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

		this.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));

		field = new Button[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				field[i][j] = new Button();
				System.out.println(field[i][j].getLabel());
				field[i][j].addActionListener(al);
				field[i][j].setFocusable(false);
				this.add(field[i][j]);
				field[i][j].setBounds(100+j*110, 100+i*60, 100, 50);
			}
		}
  }

	public void validate() {
		char c = ' ';
		boolean[] checks = new boolean[8];
		checks[0] = field[0][0].getLabel() != "" && field[0][0].getLabel() == field[0][1].getLabel() && field[0][0].getLabel() == field[0][2].getLabel();
		checks[1] = field[0][0].getLabel() != "" && field[0][0].getLabel() == field[1][0].getLabel() && field[0][0].getLabel() == field[2][0].getLabel();
		checks[2] = field[0][0].getLabel() != "" && field[0][0].getLabel() == field[1][1].getLabel() && field[0][0].getLabel() == field[2][2].getLabel();
		checks[3] = field[0][1].getLabel() != "" && field[0][1].getLabel() == field[1][1].getLabel() && field[0][1].getLabel() == field[2][1].getLabel();
		checks[4] = field[0][2].getLabel() != "" && field[0][2].getLabel() == field[1][2].getLabel() && field[0][2].getLabel() == field[2][2].getLabel();
		checks[5] = field[1][0].getLabel() != "" && field[1][0].getLabel() == field[1][1].getLabel() && field[1][0].getLabel() == field[1][2].getLabel();
		checks[6] = field[2][0].getLabel() != "" && field[2][0].getLabel() == field[2][1].getLabel() && field[2][0].getLabel() == field[2][2].getLabel();
		checks[7] = field[2][0].getLabel() != "" && field[2][0].getLabel() == field[1][1].getLabel() && field[2][0].getLabel() == field[0][2].getLabel();

		if (checks[0] || checks[1] || checks[2]) {
			c = field[0][0].getLabel().toCharArray()[0];
		} else if (checks[3]) {
			c = field[0][1].getLabel().toCharArray()[0];
		} else if (checks[4]) {
			c = field[0][2].getLabel().toCharArray()[0];
		} else if (checks[5]) {
			c = field[1][0].getLabel().toCharArray()[0];
		} else if (checks[6] || checks[7]) {
			c = field[2][0].getLabel().toCharArray()[0];
		}

		if (c == ' ') {
			return;
		} else {
			driver.showSieg(""+c+ " hat gewonnen!"); //getDriver()
		}
	}
}
