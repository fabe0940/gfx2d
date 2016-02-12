package fabe0940.gfx2d;

import fabe0940.gfx2d.Constants;
import fabe0940.gfx2d.Viewport;
import fabe0940.gfx2d.util.Point;
import java.awt.Graphics;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Window extends JComponent {
	private JFrame frame;
	private Point position;
	private Point size;
	private List<Viewport> viewports;

	public Window(Point p, Point s) {
		position = p;
		size = s;
		viewports = new LinkedList<Viewport>();

		frame = new JFrame(Constants.windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(position.x, position.y, size.x, size.y + 28);
		frame.getContentPane().add(this);
		frame.setVisible(true);

		return;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setWindow(Point p, Point s) {
		this.position = p;
		this.size = s;

		frame.setBounds(p.x, p.y, s.x, s.y);

		return;
	}

	public void addViewport(Viewport v) {
		viewports.add(v);

		return;
	}

	public void removeViewport(Viewport v) {
		int i;

		i = viewports.indexOf(v);
		if (i != -1) {
			viewports.remove(i);
		}
	}

	public void paintComponent(Graphics g) {
		for (Viewport v : viewports) {
			v.draw(g);
		}

		drawText(g);

		return;
	}

	private void drawText(Graphics g) {
		g.drawString("y = 3.0e^(-0.33x)sin(3x)", 10, 15);
		g.drawString("y = (3x^2 - 12x - 15) / (x^2 - 3x - 10)", 410, 15);
		g.drawString("y^2 - bc^2x^3 - ac^x^2 = 0 with b = 0.5", 10, 415);
		g.drawString("y^2 - bc^2x^3 - ac^x^2 = 0 with b = 1.0", 410, 415);
		g.drawString("y^2 - bc^2x^3 - ac^x^2 = 0 with b = 2.0", 810, 415);

		g.drawString("Mason Fabel (fabe0940)", 810, 15);
		g.drawString("CS324", 810, 25);
		g.drawString("Homework 2", 810, 35);
	}
}
