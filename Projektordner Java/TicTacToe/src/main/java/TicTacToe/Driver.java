package TicTacToe;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

/**
 * Treiber-Klasse für das TicTacToe-Projekt
 * 
 * @author s76954
 *
 */
public class Driver extends Frame {
  private CardLayout cl;

  private Menu menu;
  private InfoScreen regeln;
  private InfoScreen infos;
  private Spiel spiel;
  private Sieg sieg;

  /**
   * Konstruktor, der Vollbild aktiviert und das CardLayout initialisiert
   * Weiterhin werden Instanzen für die benötigten Ansichten generiert.
   */
  public Driver() {
    GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    this.setTitle("TicTacToe");
    cl = new CardLayout();
    this.setLayout(cl);

    // Vollbildmodus
    this.setResizable(false);
    this.setUndecorated(true);
    this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        shutdown();
      }
    });

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

  /**
   * Beendet das Programm
   */
  public void shutdown() {
    dispose();
    System.exit(0);
  }

  /**
   * Zeigt den Menübildschirm
   */
  public void showMenu() {
    spiel.clearField();
    cl.show(this, "menu");
  }

  /**
   * Zeigt den Regelbildschirm
   */
  public void showRegeln() {
    cl.show(this, "regeln");
  }

  /**
   * Zeigt Infobildschirm
   */
  public void showInfos() {
    cl.show(this, "infos");
  }

  /**
   * Zeigt Spielbildschirm
   */
  public void showSpiel() {
    cl.show(this, "spiel");
  }

  /**
   * Übernimmt Gewinner der Partie und zeigt Siegbildschirm
   * 
   * @param s Spezifiziert den Gewinner der Partie
   */
  public void showSieg(int s) {
    sieg.setSieger(s);
    cl.show(this, "sieg");
  }

  /**
   * erstellt einen Treiber und startet das Programm
   * 
   * @param args Kommandozeilen-Parameter
   */
  public static void main(String[] args) {
    new Driver();
  }
}
