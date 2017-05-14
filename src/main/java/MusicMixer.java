import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MusicMixer extends JPanel implements ActionListener
{
	static JFrame player = new JFrame("Media Player");
	JLabel info = new JLabel("Media Player");
	JButton addButton = new JButton("Add Music");
	JButton playButton = new JButton("Play");
	JButton pauseButton = new JButton("Pause");
	JButton stopButton = new JButton("Stop");
	Font customFont = new Font("",Font.BOLD,20);
	JComboBox list =new JComboBox();
	JFileChooser browser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV Sound","wav");
	int returnValue;
	String[] musics = new String[10];
	int index = 0;
	File selectedFile;
	File sound;
	AudioInputStream ais;
	Clip clip;
	boolean playing;
	long time;
	int playIndex;
	
	MusicMixer()
	{
		
		this.setBackground(Color.BLACK);
		player.add(this);
		
		addButton.addActionListener(this);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);
		pauseButton.addActionListener(this);
		
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
		
		pauseButton.setFont(customFont);
		pauseButton.setBackground(Color.black);
		pauseButton.setForeground(Color.orange);
		player.add(pauseButton,BorderLayout.PAGE_END);
		
		list.setBackground(Color.black);
		list.setForeground(Color.CYAN);
		player.add(list,BorderLayout.PAGE_START);
		
		browser.setFileFilter(filter);
		
		player.setSize(400,200);
		player.setLocation(800,100);
		player.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		player.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==addButton)
		{
			returnValue = browser.showOpenDialog(player);
			
			if(returnValue==browser.APPROVE_OPTION)
			{
				selectedFile = browser.getSelectedFile();
				musics[index] = selectedFile.toString();
				list.addItem("Song - "+index);
				index++;
			}
		}
		else if(ae.getSource()==playButton)
		{
			try
			{
				if(list.getSelectedIndex()==0&&playing==false&&list.getSelectedIndex()!=playIndex)
				{
					time=0;
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==0&&playing==false)
				{
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==1&&playing==false&&list.getSelectedIndex()!=playIndex)
				{
					time=0;
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==1&&playing==false)
				{
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==2&&playing==false&&list.getSelectedIndex()!=playIndex)
				{
					time=0;
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==2&&playing==false)
				{
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==3&&playing==false&&list.getSelectedIndex()!=playIndex)
				{
					time=0;
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==3&&playing==false)
				{
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==4&&playing==false&&list.getSelectedIndex()!=playIndex)
				{
					time=0;
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
				else if(list.getSelectedIndex()==4&&playing==false)
				{
					playIndex=list.getSelectedIndex();
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.setMicrosecondPosition(time);
					clip.start();
					playing=true;
				}
			}
			catch(Exception e){JOptionPane.showMessageDialog(null, e);}
		}
		
		else if(ae.getSource()==stopButton)
		{
			clip.stop();
			playing=false;
			time=0;
		}
		
		else if(ae.getSource()==pauseButton)
		{
			time=clip.getMicrosecondPosition();
			clip.stop();
			playing=false;
		}
		
		
		
	}
	 public static JFrame getFrameMusic(){
		 return player;
	 }
	

	
}
