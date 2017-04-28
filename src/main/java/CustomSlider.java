import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CustomSlider extends JPanel
						implements ChangeListener{
	public static int redColor;
	public static int blueColor;
	public static int greenColor;
	public static int redColorF, blueColorF, greenColorF;
	public static Color colorF;
	public JPanel panel;
	public Rectangle r;
	public boolean isLive;
	public JFrame frame;
	public JLabel text;

	public CustomSlider()  {
		
		super(true);
		//this.setLayout(new SpringLayout());
		SpringLayout layout = new SpringLayout();
		redColor = 0;
		blueColor=0;
		greenColor=0;
		redColorF = 0;
		blueColorF = 0;
		greenColorF = 0;
		isLive = false;
		panel = Master.getPanelCustom();
		frame = Master.getFrameCustom();
		JSlider sliderOne = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		text = Master.getLabelCustom();

		sliderOne.setMinorTickSpacing(50);
		//sliderOne.setMajorTickSpacing(25);
		sliderOne.setPaintTicks(true);
		sliderOne.setPaintLabels(true);
		sliderOne.setToolTipText("Red Value");

		sliderOne.setLabelTable(sliderOne.createStandardLabels(50));

		sliderOne.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent event) {
				redColor = sliderOne.getValue();
				panel.setBackground(new Color(redColor, blueColor, greenColor));
				frame.setBackground(new Color(redColor, blueColor, greenColor));
				text.setText("All in 1 Planner");
				text.setForeground(Color.BLACK);
				text.setVisible(true);
			 }
			 });
		
		add(sliderOne, SpringLayout.NORTH);
		
		JLabel red = new JLabel("Red");
		add(red, SpringLayout.SOUTH);
		
		//layout.putConstraint(SpringLayout.WEST, sliderOne, 5, SpringLayout.WEST, );
		
		JSlider sliderTwo = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);

		sliderTwo.setMinorTickSpacing(50);
		//sliderTwo.setMajorTickSpacing(50);
		sliderTwo.setPaintTicks(true);
		sliderTwo.setPaintLabels(true);
		sliderTwo.setToolTipText("Green Value");

		sliderTwo.setLabelTable(sliderTwo.createStandardLabels(50));
		
		sliderTwo.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent event) {
				blueColor = sliderTwo.getValue();
				panel.setBackground(new Color(redColor, blueColor, greenColor));
				text.setText("All in 1 Planner");
				text.setForeground(Color.BLACK);
				text.setVisible(true);
			 }
			 });
		
		
		add(sliderTwo, SpringLayout.VERTICAL_CENTER);
		
		JLabel green = new JLabel("Green");
		add(green,SpringLayout.SOUTH);
		
		JSlider sliderThree = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);

		sliderThree.setMinorTickSpacing(50);
		//sliderThree.setMajorTickSpacing(50);
		sliderThree.setPaintTicks(true);
		sliderThree.setPaintLabels(true);
		sliderThree.setToolTipText("Blue Value");

		sliderThree.setLabelTable(sliderThree.createStandardLabels(50));
		
		sliderThree.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent event) {
				greenColor = sliderThree.getValue();
				panel.setBackground(new Color(redColor, blueColor, greenColor));
				text.setText("All in 1 Planner");
				text.setForeground(Color.BLACK);
				text.setVisible(true);
			 }
			 });

		add(sliderThree, SpringLayout.SOUTH);
		
		JLabel blue = new JLabel("Blue");
		add(blue, SpringLayout.SOUTH);
		
		//colorF = Color.black;
		
		
		Color colorTemp = new Color(redColor, greenColor, blueColor);
		colorF = colorTemp;
		
		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				 redColorF = sliderOne.getValue();
				 greenColorF = sliderTwo.getValue();
				 blueColorF = sliderThree.getValue();
				 System.out.println(redColor + " " + greenColor + " " + blueColor);
				 Color color = new Color(redColorF, greenColorF, blueColorF);
				 colorF = color;
				 panel.setBackground(colorF);
				 isLive = true;
				
				 System.out.println(text.getName());
				 if(text.getName() == null)
						 {
				 text.setText("All in 1 Planner");
					text.setForeground(Color.BLACK);
					text.setVisible(true);
					System.out.println(text.getName());
						 }

			 }
			 });
		add(enter, SpringLayout.VERTICAL_CENTER);
		
		frame.addComponentListener(new ComponentListener() {
			@Override
		public void componentHidden(ComponentEvent e) {
				if(redColorF==0 && greenColorF==0 && blueColorF==0 && isLive == false)
				{
					panel.setBackground(Color.WHITE);
				}
	    }

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
	});
		
		
		
	}
		
		
	
	

	public static void main(String[] s) {
		/*System.out.println("Helloooo");
		JFrame frame = new JFrame("RGB Slider");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setContentPane(new CustomSlider());
		frame.setSize(245, 260);
		frame.setVisible(true);*/   
	}
	public static int getR(){
		return redColor;
	}
	
	public static int getG(){
		return greenColor;
	}
	
	public static int getB(){
		return blueColor;
	}
	

	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}