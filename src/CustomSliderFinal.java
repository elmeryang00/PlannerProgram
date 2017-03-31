import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class CustomSliderFinal extends JPanel {

	public CustomSliderFinal() {
		super(true);
		this.setLayout(new BorderLayout());
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 50, 25);

		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		slider.setLabelTable(slider.createStandardLabels(10));

		add(slider, BorderLayout.CENTER);
	}

	public static void main(String[] s) {
		JFrame frame = new JFrame("Slider Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new CustomSliderFinal());
		frame.pack();
		frame.setVisible(true);
	}
}