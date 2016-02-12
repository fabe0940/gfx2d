package fabe0940.gfx2d;

import fabe0940.gfx2d.Window;
import fabe0940.gfx2d.util.Point;
import javax.swing.*;

public class Viewport {
	private Point position;
	private Point size;

	public Viewport(Point p, Point s) {
		position = p;
		size = s;

		return;
	}

	public Point getPosition() {
		return position;
	}

	public Point getSize() {
		return size;
	}

	public void setViewport(Point p, Point s) {
		this.position = p;
		this.size = s;
	}

	public Point windowToViewport(Point p) {
		Point res;

		res = new Point(0, 0);
		res.x = p.x - position.x;
		res.y = position.y - p.x;

		return res;
	}

	public void draw(Window w) {
		JFrame f = w.getFrame();

		return;
	}
}
