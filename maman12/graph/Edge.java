package maman12.graph;

import java.awt.Point;

public class Edge {
	
	private Point m_p1;
	private Point m_p2;
	private Point m_pMiddle;
	private double m_length;
	
	public Edge(Point p1, Point p2) {
		m_p1 = p1;
		m_p2 = p2;
		m_pMiddle = new Point(p1.x + ((p2.x - p1.x) / 2),
				p1.y + ((p2.y - p1.y) / 2));
		m_length = Math.sqrt(
				Math.pow(p2.x - p1.x, 2)
				+ Math.pow(p2.y - p1.y, 2));
	}
	
	public Point getP1() {
		return new Point(m_p1.x, m_p1.y);
	}
	
	public Point getP2() {
		return new Point (m_p2.x, m_p2.y);
	}
	
	public Point getMiddle() {
		return new Point(m_pMiddle.x, m_pMiddle.y);
	}
	
	public double getLength() {
		return m_length;
	}
	
	public String getLengthString() {
		return String.format("%.2f", m_length);
	}
}
