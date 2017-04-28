import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MusicMixer extends JPanel implements ActionListener
{
	JFrame player = new JFrame("Media Player");
	
	MusicMixer()
	{
		this.setBackground(Color.BLACK);
		player.add(this);
		player.setSize(400,200);
		player.setLocation(100,100);
		player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
