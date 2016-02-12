package fabe0940.gfx2d;

import fabe0940.gfx2d.Constants;
import fabe0940.gfx2d.Viewport;
import fabe0940.gfx2d.util.Point;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.LinkedList;
import javax.swing.*;

public class Window extends JComponent {
	private JFrame frame;
	private List<Viewport> viewports;
	private Point position;
	private Point size;

	public Window(Point p, Point s) {
		position = p;
		size = s;

		frame = new JFrame(Constants.windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(position.x, position.y, size.x, size.y);
		frame.getContentPane().add(this);
		frame.setVisible(true);

		viewports = new LinkedList<Viewport>();

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

	public Point viewportToWindow(Viewport v, Point p) {
		Point res;

		res = new Point(0, 0);
		res.x = v.getPosition().x + p.x;
		res.y = v.getPosition().y - p.y;

		return res;
	}

	public void paintComponent(Graphics g) {
		for (Viewport v : viewports) {
			v.draw(this);
		}

		return;
	}
}
