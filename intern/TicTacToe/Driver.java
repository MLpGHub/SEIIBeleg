import java.awt.*;
import java.awt.event.*;

public class Driver extends Frame {
	private GraphicsDevice gd;
	private CardLayout cl;

	private Menu menu;
	private Regeln regeln;
	private Infos infos;
	private Spiel spiel;
	private Sieg sieg;

	public Driver() {
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getDefaultScreenDevice();

		this.setTitle("TicTacToe");
		cl = new CardLayout();
		this.setLayout(cl);

		//make Frame fullscreen
		this.setResizable(false); //neccessary?
		this.setUndecorated(true);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		gd.setFullScreenWindow(this);

		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				shutdown();
			}});

		menu = new Menu(this);
		regeln = new Regeln();
		infos = new Infos();
		spiel = new Spiel();
		sieg = new Sieg();

		this.add("menu", menu);
		this.add("regeln", regeln);
		this.add("infos", infos);
		this.add("spiel", spiel);
		this.add("sieg", sieg);

		this.setVisible(true);
	}

	public void shutdown() {
		dispose();
		System.exit(0);
	}

	public void showMenu() {
		cl.show(this, "menu");
		System.out.println("showMenu()");
	}

	public void showRegeln() {
		cl.show(this, "regeln");
		System.out.println("showRegeln()");
	}

	public void showInfos() {
		cl.show(this, "infos");
		System.out.println("showInfos()");
	}

	public void showSpiel() {
		cl.show(this, "spiel");
		System.out.println("showSpiel()");
	}

	public void showSieg() {
		cl.show(this, "sieg");
		System.out.println("showSieg()");
	}

	public static void main(String[] args) {
		new Driver();
	}
}
