import java.awt.*;
import java.awt.event.*;

public class Driver extends Frame {
	Menu menu;
	Regeln regeln;
	Infos infos;
	Spiel spiel;
	Sieg sieg;

	public Driver() {
		menu = new Menu(this);
		/*
		regeln = new Regeln();
		infos = new Infos();
		spiel = new Spiel();
		sieg = new Sieg();
		*/

		//this.setLayout(new CardLayout());
		this.add(menu);
		//etc

		//with buttons switch layout
	}



	public static void main(String[] args) {
		Driver d = new Driver();
	}
}
