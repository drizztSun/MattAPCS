import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIproject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		JFrame x = new JFrame("calculator");
		
		
		x.setSize(350, 400);
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel p = new JPanel();
		JPanel p1 = new JPanel();

		p1.setMaximumSize(new Dimension(150, 100));

		container.add(p1);
		container.add(p);

		
		JButton multiply = new JButton("multiply");
		p.add(multiply);
		JButton add = new JButton("add");
		p.add(add);
		JButton sub = new JButton("subtract");
		p.add(sub);
		JButton div = new JButton("divide");
		p.add(div);


		
		JTextField num1 = new JTextField(28);
		
		JTextField num2 = new JTextField(28);
		
		p.add(num1);
		p.add(num2);
		
		JLabel a = new JLabel("results show here");
		p1.add(a);
		
		multiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(num1.getText());
				int n2 = Integer.parseInt(num2.getText());
				int res = n1*n2;
				a.setText(Integer.toString(res));
			}


		});
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(num1.getText());
				int n2 = Integer.parseInt(num2.getText());
				int res = n1+n2;
				a.setText(Integer.toString(res));
			}


		});
		
		sub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(num1.getText());
				int n2 = Integer.parseInt(num2.getText());
				int res = n1-n2;
				a.setText(Integer.toString(res));
			}


		});
		
		div.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(num1.getText());
				int n2 = Integer.parseInt(num2.getText());
				double res = (n1+0.0)/n2;
				a.setText(Double.toString(res));
			}


		});
		
		
		
		p.setBackground(Color.lightGray);
		x.add(container);


		x.setVisible(true);
		
		
	}

}
