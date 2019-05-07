package TicTacToe;
import java.awt.*;
import java.awt.event.*;

// Project -> Properties -> Builders ... (Gradle)
// Help -> Eclipse Marketplace ... -> Gradle
// ProGuard ??
// TODO: JUnit Tests

public class Driver extends Frame {
	private GraphicsDevice gd;
	private CardLayout cl;

	private Menu menu;
	private InfoScreen regeln;
	private InfoScreen infos;
	private Spiel spiel;
	private Sieg sieg;

	public Driver() {
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getDefaultScreenDevice();

		this.setTitle("TicTacToe");
		cl = new CardLayout();
		this.setLayout(cl);

		//make Frame fullscreen
		this.setResizable(false);
		this.setUndecorated(true);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		//needed? we just develop for windows...
		String os = System.getProperty("os.name");
		if (os == "Linux") {
			gd.setFullScreenWindow(this);
		}

		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				shutdown();
			}});

		menu = new Menu(this);
		regeln = new InfoScreen(this, this.getToolkit().getImage("src/main/resources/regeln.jpg"));
		infos = new InfoScreen(this, this.getToolkit().getImage("src/main/resources/info.jpg"));
		spiel = new Spiel(this);
		sieg = new Sieg(this);

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
		spiel.clearField();
		cl.show(this, "menu");
	}

	public void showRegeln() {
		cl.show(this, "regeln");
	}

	public void showInfos() {
		cl.show(this, "infos");
	}

	public void showSpiel() {
		cl.show(this, "spiel");
	}

	public void showSieg(int s) {
		sieg.setSieger(s);
		cl.show(this, "sieg");
	}

	public static void main(String[] args) {
		new Driver();
	}
}
