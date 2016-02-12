package fabe0940.gfx2d;

import fabe0940.gfx2d.Constants;
import fabe0940.gfx2d.util.Point;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.LinkedList;
import javax.swing;

public class Window extends JComponent {
	private JFrame frame;
	private List<Viewport> viewports;
	private Point size;
	private Point position;

	public Window(Point s, Point p) {
		frame = new JFrame(Constants.windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(s.x, s.y);
		frame.getContentPanel().add(this);
		frame.setVisible(true);

		viewports = new LinkedList<Viewport>();

		return;
	}

	public void setWindow(Point s, Point p) {
		size = s;
		position = p;

		frame.setSize(s.x, s.y);

		return;
	}

	public void paintComponent(Graphics g) {
		/* do the things */

		return;
	}
}
