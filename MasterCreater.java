import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class MasterCreater {

public JLabel textFinal;
public JPanel panel;
	
public void textDraw(){
	JLabel text = new JLabel("All in 1 Planner"); // Displays text Maze
	// Runner
	//textFinal = text;
text.setTransferHandler(new TransferHandler("text"));
text.setBounds(410, 120, 500, 70); // Sets boundaries of the Text
text.setFont(new Font("Serif", Font.PLAIN, 30));
text.setForeground(Color.BLACK);

panel = Master.getPanelCustom();
panel.add(text);

text.setVisible(true);

}
}
