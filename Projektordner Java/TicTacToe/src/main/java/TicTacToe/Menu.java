package TicTacToe;
import java.awt.*;
import java.awt.event.*;

public class Menu extends Panel {
	private Driver driver;
	private Image img;

	private Button start;
	private Button regeln;
	private Button infos;

	private Button exit; //temporary exit button

	public Menu(Driver driver) {
		this.driver = driver;
		this.setLayout(null);
		this.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 30));

		this.img = this.getToolkit().getImage("../resources/wellen_fullhd.jpg");
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);
		try {
			mt.waitForID(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		start = new Button("Spiel starten");
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				driver.showSpiel();
			}});

		regeln = new Button("Regeln");
		regeln.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				driver.showRegeln();
			}});

		infos = new Button("Infos");
		infos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				driver.showInfos();
			}});

		exit = new Button("Exit");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				driver.shutdown();
			}});

		this.add(start);
		this.add(regeln);
		this.add(infos);

		this.add(exit);

		//positioning of the components
		//relative positioning??
		start.setBounds(100, 100, 400, 50);
		regeln.setBounds(100, 150, 400, 50);
		infos.setBounds(100, 200, 400, 50);

		exit.setBounds(100, 900, 200, 50);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
		//this.setFont(new Font("Comfortaa", Font.PLAIN, 30));
		g.drawString("TicTacToe", 100, 50);
	}
}
