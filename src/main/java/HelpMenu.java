
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

public class HelpMenu extends JDialog {
	public int nFin;
	public HelpMenu() {
		setTitle("Help Menu");
		JPanel basic = new JPanel();
		
		basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
		add(basic);

		
		JPanel topPanel = new JPanel(new BorderLayout(0, 0));
		topPanel.setMaximumSize(new Dimension(450, 0));
		 
		JLabel hint = new JLabel("Planner Program Tutorial");
		hint.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
		topPanel.add(hint);
		
		ImageIcon icon = new ImageIcon("jdev.png");
		JLabel label = new JLabel(icon);
		label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		topPanel.add(label, BorderLayout.EAST);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.gray);
		topPanel.add(separator, BorderLayout.SOUTH);
		basic.add(topPanel);
		
		JPanel textPanel = new JPanel(new BorderLayout());
		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15,25));
		
		JTextPane pane = new JTextPane();
		pane.setContentType("text/html");
		String firstPanel = "</p><b>Getting Started</b></p>" + "<p>Welcome to the All in 1 Planner built to maximize your Productivity<p>" + "</p>Click Next to continue the Start-Up Tutorial </p>";
		String secondPanel = "</p><b>Features</b></p>" + "<p>The All in 1 Planner contains multiple features built to double your efficiency<p>" + "The planner contains a Calendar, Calculator, Alarm, Notepad, and a To Do List that can be used in sync<p>" + " When you need a break, click the Break Room button and enjoy a variety of Brain relaxing games <p>";
		String thirdPanel = "</p><b>Hidden Features</b></p>" + "<p>Hovering over all buttons will reveal the function in a Tool Tip<p>" + "You can also Access features from the Menu Bar at the top of the Main Screen</p>";
		String fourthPanel = "</p><b>Congratulations!</b></p>" + "<p>You have finished the tutorial<p>" + "<p>Click the Exit Button to return to your program<p>";
		//String fifthPanel = "</p><b>Congratulations!</b></p>" + "<p>You have finished the tutorial<p>" + "<p>Click the Exit Button to return to your program<p>";
		
		 ArrayList <String> tips = new ArrayList<String>();
		 tips.add(firstPanel);
		 tips.add(secondPanel);
		 tips.add(thirdPanel);
		 tips.add(fourthPanel);
		 //tips.add(fifthPanel);
		 
		 int n = 0;
		 nFin = n;
		
		pane.setText(tips.get(nFin));
		pane.setEditable(false);
		textPanel.add(pane);
		basic.add(textPanel);
		 
		JPanel boxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		 
		JCheckBox box = new JCheckBox("Show Tips at startup");
		box.setMnemonic(KeyEvent.VK_S);
		boxPanel.add(box);
		basic.add(boxPanel);
		
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ntip = new JButton("Next");
		JButton ptip = new JButton("Previous");
		ptip.setVisible(false);
		ntip.setMnemonic(KeyEvent.VK_N);
		ntip.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				 nFin ++;
				 pane.setText(tips.get(nFin));
				 if(nFin>=tips.size()-1)
				 {
					 ntip.setVisible(false);
				 }
				 else
				 {
					 ntip.setVisible(true);
				 }
				 
				 if(nFin>=0)
				 {
					 ptip.setVisible(true);
					 
				 }
				 
				 
				 }
				 
				 
			 
			 });
		 
		

		
		ptip.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				 nFin --;
				 pane.setText(tips.get(nFin));
				 if(nFin==0)
					 {
						 ptip.setVisible(false);
						 
					 }
				 
				 if(nFin==tips.size()-2)
				 {
					 ptip.setVisible(false);
					 ntip.setVisible(true);
					 ptip.setVisible(true);
					 System.out.println("hello");
				 }
			 }
			 });
		
		 
		 
		 basic.add(bottom);
		 bottom.setMaximumSize(new Dimension(450, 0));
		 setSize(new Dimension(450, 350));
		 bottom.add(ptip);
		 bottom.add(ntip);
		 setResizable(true);
		 setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 setVisible(true);
		 
		 JDialog theWindow = this;
		 
		 JButton close = new JButton("Close");
		 close.addActionListener(new ActionListener() { 
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) //Checks Rando to see if it is pressed
		         {
					//basic.setVisible(false);
					theWindow.setVisible(false);
					
					System.out.println("hello");
					
		         }
				});  
		 		close.setMnemonic(KeyEvent.VK_C);
				 bottom.add(close);
		 		
		 }
	 public static void main(String[] args) {
		 new HelpMenu();
		 }
		}