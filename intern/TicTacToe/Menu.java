import java.awt.*;
import java.awt.event.*;

public class Menu extends Panel {
	private Label spielinfo;
	private Button start;
	private Button regeln;
	private Button infos;
	private Driver driver;

	public Menu(Driver driver) {
		this.driver = driver;

		spielinfo = new Label("TicTacToe");
		start = new Button("Spiel starten");
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//
			}});
		regeln = new Button("Regeln");
		regeln.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//
			}});
		infos = new Button("Infos");
		infos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//
			}});

		this.add(spielinfo);
		this.add(start);
		this.add(regeln);
		this.add(infos);
	}
}
