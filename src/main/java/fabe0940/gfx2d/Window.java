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
		frame.setBounds(position.x, position.y, size.x, size.y);
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

		return;
	}
}
