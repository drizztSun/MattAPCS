import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class Graphicstest {

	public static void main(String[] args) {
		JFrame x = new JFrame("My first frame");
		x.setSize(400, 300);
		
		JPanel p = new JPanel();
		
		JLabel a = new JLabel("hello world");
		p.add(a);
		
		JButton b = new JButton("click me");
		p.add(b);
		
		JButton c = new JButton("please dont click me");
		p.add(c);
		
		JTextField field = new JTextField(20);
		
		p.add(field);
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = field.getText();
				a.setText(txt);
			}


		});
		
		x.add(p);
		x.setVisible(true);

	}

}
