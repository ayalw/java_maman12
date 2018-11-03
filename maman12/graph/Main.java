package maman12.graph;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Lines");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
		GraphWithLengthsPanel panel = new GraphWithLengthsPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		frame.add(panel);
		panel.setVisible(true);
		String userInput = "";
		while(true) {
			userInput = JOptionPane.showInputDialog("Please Insert Point: ");
			if (userInput == null || userInput.isEmpty()) {
				break;
			} 
			if (!userInput.contains(",")) {
				showError(panel);
				continue;
			}
			String[] parts = userInput.split(",");
			try {
				int x = Integer.parseInt(parts[0]);
				int y = Integer.parseInt(parts[1]);	
				if (x < 0 || x > 400 || y < 0 || y > 400) {
					showError(panel);
					continue;
				}
				panel.addPoint(x, y);
				panel.repaint();
			}
			catch(NumberFormatException e) {
				showError(panel);
				continue;
			}
		}
		System.exit(0);
	}
	
	private static void showError(JComponent component) {
	    JOptionPane.showMessageDialog(component, "Please insert X,Y format separated by a comma. X and Y must be between 0 to 400.", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
