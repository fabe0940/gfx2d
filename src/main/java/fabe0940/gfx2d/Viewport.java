package fabe0940.gfx2d;

import fabe0940.gfx2d.Window;
import fabe0940.gfx2d.util.Point;
import fabe0940.gfx2d.util.Line;
import java.awt.Graphics;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JFrame;

public class Viewport {
	private Point cursor;
	private Point position;
	private Point size;
	private List<Line> lines;

	public Viewport(Point p, Point s) {
		cursor = new Point(0, 0);
		position = p;
		size = s;
		lines = new LinkedList<Line>();

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

		return;
	}

	public void moveTo2D(Point p) {
		cursor = p;

		return;
	}

	public void drawTo2D(Point p) {
		Line l;

		l = new Line(cursor, p);
		cursor = p;

		if (cursor.x >= 0 && cursor.x <= this.size.x) {
			if (cursor.y >= 0 && cursor.y <= this.size.y) {
				lines.add(l);
			}
		}

		return;
	}

	public Point viewportToWindow(Point p) {
		Point res;

		res = new Point(0, 0);
		res.x = this.position.x + p.x;
		res.y = this.position.y - p.y;

		return res;
	}

	public Point windowToViewport(Point p) {
		Point res;

		res = new Point(0, 0);
		res.x = p.x - this.position.x;
		res.y = this.position.y - p.x;

		return res;
	}

	public void draw(Graphics g) {
		Point from;
		Point to;

		for (Line l : lines) {
			from = viewportToWindow(l.start);
			to = viewportToWindow(l.end);
			g.drawLine(from.x, from.y, to.x, to.y);
		}

		return;
	}
}
