
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class Master {
	static int a = 0;
	public static JMenu background;
	private static JLabel statusbar;
	private static int redCustom, blueCustom, greenCustom;
	public static JPanel panelF;
	public static JFrame frameF;
	public static JLabel textF;
	public static int red, green, blue;
	AudioPlayer[] player = new AudioPlayer[4];
	public Minim minim;
	public static JFrame musicPlayer;
	public static JMenuBar menuBarF;
	public static JLabel textFinal;

	// Timer timer = new Timer(this, 1000/60);
	// public void actionPerformed(ActionEvent e) //Checks Rando to see if it is
	// pressed

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			// UIManager.setLookAndFeel(
			// UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			// UIManager.setLookAndFeel("com.infonodelookandfeel.InfoNodeLookAndFeel");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame();

		// Creates Main Screen JFrame
		JPanel panel = new JPanel();
		frame.setSize(1000, 1000); // Sets size of JFrame
		Random c = new Random();
		panel.setBackground(Color.WHITE);

		panelF = panel;
		// be exited
		panel.setLayout(null); // Allows the JButtons and JLabels to be moved
		// panel.setBackground(Color.black);

		textFinal = MasterCreater.getText();
		
		MasterCreater textCreate = new MasterCreater();
		textCreate.textDraw();

		MusicMixer mm = new MusicMixer();// Displays the music mixer to
		// play .wav files
		musicPlayer = MusicMixer.getFrameMusic();
		musicPlayer.setVisible(false);
		
		
		red = CustomSlider.getR();
		green = CustomSlider.getG();
		blue = CustomSlider.getB();
		
				
		/*
		 * JLabel text = new JLabel("All in 1 Planner"); // Displays text Maze
		 * // Runner
		 * 
		 * text.setTransferHandler(new TransferHandler("text"));
		 * text.setBounds(410, 120, 500, 70); // Sets boundaries of the Text
		 * text.setFont(new Font("Serif", Font.PLAIN, 30));
		 * text.setForeground(Color.BLACK);
		 * 
		 * textF = text; frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 * //frame.add(text); //frame.getContentPane().add(text);
		 * 
		 * panel.add(text); text.setVisible(true);
		 * 
		 */
		/*
 		 * AudioPlayer[] player = new AudioPlayer[4]; Minim minim; int count;
		 * minim = new Minim(this);
		 * 
		 * count=(int)(Math.random()*4 + 1); player[0] =
		 * minim.loadFile("Carefree.mp3"); player[1] =
		 * minim.loadFile("jazz.mp3"); player[2] =
		 * minim.loadFile("ericDubstep.wav"); player[3] =
		 * minim.loadFile("extremeaction.mp3"); player[count].play();
		 */

		JButton Alarm = new JButton(" Alarm "); // New Button for Random
		Alarm.setToolTipText("Alarm");
		Alarm.setTransferHandler(new TransferHandler("text"));
		Alarm.setVisible(true); // Play
		Alarm.setBounds(490, 200, 450, 90); // Sets boundaries of the Buttons
		Alarm.setForeground(Color.BLACK);
		Alarm.addActionListener(new ActionListener() { // Allows Button Rando to
														// be pressed

			@Override
			public void actionPerformed(ActionEvent e) // Checks Rando to see if
														// it is pressed
			{
				AlarmClock s = new AlarmClock();
				s.init();
			}
		});
		panel.add(Alarm);

		JButton breakRoom = new JButton(" Break Room "); // New Button for
															// Random
		breakRoom.setToolTipText("Break Room");
		breakRoom.setTransferHandler(new TransferHandler("text"));
		breakRoom.setVisible(true); // Play
		breakRoom.setBounds(40, 200, 450, 90); // Sets boundaries of the Buttons
		breakRoom.addActionListener(new ActionListener() { // Allows Button
															// Rando to be
															// pressed

			@Override
			public void actionPerformed(ActionEvent e) // Checks Rando to see if
														// it is pressed
			{
				BreakRoom.Create();

			}

		});
		panel.add(breakRoom);

		JButton Calendar = new JButton(" Calendar "); // New Button for Random
		Calendar.setToolTipText("Calendar");
		Calendar.setTransferHandler(new TransferHandler("text"));
		Calendar.setVisible(true); // Play
		Calendar.setBounds(40, 340, 450, 90); // Sets boundaries of the Buttons
		Calendar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) // Checks Rando to see if
														// it is pressed
			{
				SwingCalendar s = new SwingCalendar();
				s.updateMonth();
				SwingCalendar.main(args);

			}
		});

		panel.add(Calendar);

		JButton notePad = new JButton(" NotePad "); // New Button for Random
		notePad.setToolTipText("Note Pad");
		notePad.setTransferHandler(new TransferHandler("text"));
		notePad.setVisible(true); // Play
		notePad.setBounds(490, 340, 450, 90); // Sets boundaries of the Buttons
		notePad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) // Checks Rando to see if
														// it is pressed
			{
				NotePad app = new NotePad();
				app.setVisible(true);

			}
		});

		panel.add(notePad);

		JButton Calculator = new JButton(" Calculator ");
		Calculator.setToolTipText("Calculator");
		Calculator.setTransferHandler(new TransferHandler("text"));
		Calculator.setVisible(true);
		Calculator.setBounds(40, 480, 450, 90);
		Calculator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calculator calc = new Calculator();
				calc.pack();
			}
		});

		panel.add(Calculator);
		frame.add(panel);
		frame.setVisible(true); // Makes it visible

		JButton ToDo = new JButton(" To-Do List "); // New Button for Random
		ToDo.setToolTipText("To-Do List");
		ToDo.setTransferHandler(new TransferHandler("text"));
		ToDo.setVisible(true); // Play
		ToDo.setBounds(490, 480, 450, 90); // Sets boundaries of the Buttons
		ToDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) // Checks Rando to see if
														// it is pressed
			{
				ToDoList list = new ToDoList();
				list.setVisible(true);

			}
		});

		panel.add(ToDo);

		JPopupMenu menu = new JPopupMenu(); // Pop-Up Menu

		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					menu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		JMenu misc = new JMenu("Misc.");
		menu.add(misc);

		JMenuItem TitleEdit = new JMenuItem("Custom Edit");
		TitleEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TitleEdit.setToolTipText("Custom your Program by changing the Text");
				JFrame f = new JFrame();
				f.setSize(600, 100);
				f.setVisible(true);

				JTextField Field = new JTextField("Insert New Title");
				Field.setToolTipText("Insert Text and Drop onto the Main Text");
				f.add(Field);

				Field.setBounds(30, 50, 150, 25);
				Field.setDragEnabled(true);
				f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

				frame.add(f);
				System.out.println("hello");
			}
		});
		misc.add(TitleEdit);

		JMenu textMenu = new JMenu("Text");
		menu.add(textMenu);

		JMenuItem Black = new JMenuItem("Black");
		Black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 textFinal.setForeground(Color.BLACK);

			}
		});

		textMenu.add(Black);

		JMenuItem BlueText = new JMenuItem("Blue");
		BlueText.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
				{
					textFinal.setForeground(Color.BLUE);
					System.out.println("hello");
				}

		});

		textMenu.add(BlueText);
		background = new JMenu("Background");
		menu.add(background);

		JMenuItem custom = new JMenuItem("Custom");

		custom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("RGB Slider");
				frameF = frame;
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setContentPane(new CustomSlider());
				frame.setSize(245, 260);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				redCustom = CustomSlider.getR();
				greenCustom = CustomSlider.getG();
				blueCustom = CustomSlider.getB();

			}
		});
		background.add(custom);

		JMenuItem tipOfDay = new JMenuItem("Tip of the Day");
		tipOfDay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TipOfDay f = new TipOfDay();
				frame.add(f);
			}
		});
		menu.add(tipOfDay);

		JMenuItem menuItemClose = new JMenuItem("Close", KeyEvent.VK_W);
		menuItemClose.setMnemonic(KeyEvent.VK_W);
		menuItemClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItemClose);

		panel.add(menu);

		JMenuBar menubar = new JMenuBar(); // Menubar
		menuBarF = menubar;

		JMenu Open = new JMenu("Open");
		Open.setMnemonic(KeyEvent.VK_F);
		JMenu view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);
		JCheckBoxMenuItem sbar = new JCheckBoxMenuItem("Show StatuBar");
		sbar.setState(true);
		sbar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (statusbar.isVisible()) {
					statusbar.setVisible(false);
				} else {
					statusbar.setVisible(true);
				}
			}
		});

		JMenuItem CalendarButton = new JMenuItem("Calendar");
		CalendarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hi");
				SwingCalendar g = new SwingCalendar();
				g.updateMonth();
				SwingCalendar.main(args);
			}
		});
		Open.add(CalendarButton);

		JMenuItem BreakRoomButton = new JMenuItem("Break Room");
		BreakRoomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BreakRoom.Create();
			}
		});
		Open.add(BreakRoomButton);

		JMenuItem AlarmButton = new JMenuItem("Alarm");
		AlarmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AlarmClock zBo = new AlarmClock();
				zBo.init();
			}
		});
		Open.add(AlarmButton);

		JMenuItem NotePadButton = new JMenuItem("Note Pad");
		NotePadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NotePad yo = new NotePad();
				yo.setVisible(true);
			}
		});
		Open.add(NotePadButton);

		JMenuItem CalculatorButton = new JMenuItem("Calculator");
		CalculatorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calculator hi = new Calculator();
				hi.pack();
				System.out.println("hi");
			}
		});
		Open.add(CalculatorButton);

		JMenu help = new JMenu("Help");

		JMenuItem helpTab = new JMenuItem("Help");
		helpTab.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpMenu help = new HelpMenu();
				frame.add(help);
			}
		});
		menubar.add(help);
		help.add(helpTab);

		JMenu Music = new JMenu("Music");

		JCheckBoxMenuItem musicBar = new JCheckBoxMenuItem("Show Music");
		musicBar.setState(false);
		musicBar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (musicPlayer.isVisible()) {
					musicPlayer.setVisible(false);
				} else {
					musicPlayer.setVisible(true);
				}
			}
		});
		Music.add(musicBar);
		menubar.add(Music);

		view.add(sbar);
		menubar.add(Open);
		menubar.add(view);
		menubar.setSize(300, 20);
		frame.setJMenuBar(menubar);
		statusbar = new JLabel(" Statusbar");
		statusbar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panel.add(statusbar, BorderLayout.SOUTH);

		menubar.setVisible(true);

	}

	public static JPanel getPanelCustom() {
		return panelF;
	}

	public static JFrame getFrameCustom() {
		return frameF;
	}

	public static JLabel getLabelCustom() {
		return textF;
	}

	public static JMenuBar getMenuBar() {
		return menuBarF;

	}

}

/**
 * int Timer = 90000; //Changes color of the JText All in One PLanner
 * while(Timer >0) { Timer--; if(Timer<=0) {
 * 
 * for(int r = 0; r<250; r++) { //Random rand = new Random(); for (int g = 0;
 * g<250; g++) { for(int b = 0; b<250; b++) { text.setForeground(new
 * Color(r,g,b, 250)); Timer = 90000; } } //text.setForeground(new
 * Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)
 * )); //text.setBackground(new
 * Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)
 * )); } }
 * 
 * }
 **/
