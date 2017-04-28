import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MusicMixer extends JPanel implements ActionListener
{
	JFrame player = new JFrame("Media Player");
	JLabel info = new JLabel("Media Player");
	JButton addButton = new JButton("Add Music");
	JButton playButton = new JButton("Play");
	JButton stopButton = new JButton("Stop");
	Font customFont = new Font("",Font.BOLD,20);
	
	MusicMixer()
	{
		this.setBackground(Color.BLACK);
		player.add(this);
		
		addButton.addActionListener(this);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		info.setFont(new Font("",Font.ITALIC,20));
		player.add(info,BorderLayout.PAGE_END);
		
		addButton.setFont(customFont);
		addButton.setBackground(Color.black);
		addButton.setForeground(Color.blue);
		player.add(addButton,BorderLayout.LINE_START);
		
		playButton.setFont(customFont);
		playButton.setBackground(Color.black);
		playButton.setForeground(Color.green);
		player.add(playButton,BorderLayout.CENTER);
		
		stopButton.setFont(customFont);
		stopButton.setBackground(Color.black);
		stopButton.setForeground(Color.red);
		player.add(stopButton,BorderLayout.LINE_END);
		
		player.setSize(400,200);
		player.setLocation(800,100);
		player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
