import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.border.EtchedBorder;

public class MasterCreater {

public static JLabel textFinal;
public JPanel panel;
public JMenuBar bar;

	
public void textDraw(){
	JLabel text = new JLabel("All in 1 Planner"); // Displays text Maze
	// Runner
	
text.setTransferHandler(new TransferHandler("text"));
text.setBounds(410, 120, 500, 70); // Sets boundaries of the Text
text.setFont(new Font("Serif", Font.PLAIN, 30));
text.setForeground(Color.BLACK);
textFinal = text;

panel = Master.getPanelCustom();
panel.add(text);

text.setVisible(true);

}

public static JLabel getText(){
	return textFinal;
}
}
