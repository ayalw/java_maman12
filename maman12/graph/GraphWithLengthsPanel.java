package maman12.graph;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This panel will show a line between points entered by user.
 * @author ayalwarman
 *
 */
public class GraphWithLengthsPanel extends JPanel {

	private static final long serialVersionUID = 7127130509447629392L;

	/**
	 * Every point entered by a user is stored here.
	 */
	private ArrayList<Point> m_points;
	
	/**
	 * This list stores the edges between each point (entered by the user) to its successive.
	 */
	private ArrayList<Edge> m_edges;
	
	public GraphWithLengthsPanel() {
		super();
		m_points = new ArrayList<Point>();
		m_edges = new ArrayList<Edge>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (m_edges.size() < 1) {
			return;
		}
		for (Edge edge : m_edges) {
			g.drawLine(
					edge.getP1().x,
					edge.getP1().y,
					edge.getP2().x,
					edge.getP2().y);
			g.drawString(edge.getLengthString(),
					edge.getMiddle().x,
					edge.getMiddle().y);
		}
	}
	
	public void addPoint(int x, int y) {
		Point p = new Point(x, y);
		if (m_points.size() > 0) {
			m_edges.add(new Edge(m_points.get(m_points.size() - 1), p));
		}
		m_points.add(p);
	}
}
