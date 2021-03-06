import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
 
public class SwingCalendar extends JFrame {
 
  DefaultTableModel model;
  Calendar cal = new GregorianCalendar();
  JLabel label;
 
  SwingCalendar() {
 
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setBackground(new Color(CustomSlider.getR(), CustomSlider.getG(), CustomSlider.getB()));
    this.setTitle("Swing Calandar");
    this.setSize(300,166);
    this.setResizable(false);
    this.setLayout(new BorderLayout());
    this.setVisible(true);
 
 
    label = new JLabel();
    label.setHorizontalAlignment(SwingConstants.CENTER);
 
    JButton b1 = new JButton("<-");
    b1.addActionListener(new ActionListener() {
      @Override
	public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, -1);
        updateMonth();
      }
    });
 
    JButton b2 = new JButton("->");
    b2.addActionListener(new ActionListener() {
      @Override
	public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, +1);
        updateMonth();
      }
    });
 
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(b1,BorderLayout.WEST);
    panel.add(label,BorderLayout.CENTER);
    panel.add(b2,BorderLayout.EAST);
    panel.setBackground(new Color(CustomSlider.getR(), CustomSlider.getG(), CustomSlider.getB()));
 
 
    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    model = new DefaultTableModel(null,columns);
    JTable table = new JTable(model);
    table.setBackground(new Color(CustomSlider.getR(), CustomSlider.getG(), CustomSlider.getB()));
    JScrollPane pane = new JScrollPane(table);
    pane.setBackground(new Color(CustomSlider.getR(), CustomSlider.getG(), CustomSlider.getB()));
 
    this.add(panel,BorderLayout.NORTH);
    this.add(pane,BorderLayout.CENTER);
 
    JPanel panelSouth = new JPanel();
    panelSouth.setVisible(true);
    panelSouth.setBackground(new Color(CustomSlider.getR(), CustomSlider.getG(), CustomSlider.getB()));
    panel.add(panelSouth,BorderLayout.SOUTH);
    
    this.updateMonth();
 
 
  }
 
  void updateMonth() {
    cal.set(Calendar.DAY_OF_MONTH, 1);
 
    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    int year = cal.get(Calendar.YEAR);
    label.setText(month + " " + year);
 
    int startDay = cal.get(Calendar.DAY_OF_WEEK);
    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
 
    model.setRowCount(0);
    model.setRowCount(weeks);
 
    int i = startDay-1;
    for(int day=1;day<=numberOfDays;day++){
      model.setValueAt(day, i/7 , i%7 );    
      i = i + 1;
    }
 
  }
 
  public static void main(String[] arguments) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    //SwingCalendar sc = new SwingCalendar();
  }
 
}
 