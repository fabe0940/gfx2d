package fabe0940.gfx2d;

import fabe0940.gfx2d.Viewport;
import fabe0940.gfx2d.util.DPoint;
import fabe0940.gfx2d.util.Point;
import java.lang.Math.*;

public class Coordinate {
	private DPoint cursor;
	private DPoint domain;
	private DPoint range;
	private Point origin;
	private Point size;
	private Viewport view;

	public Coordinate(Viewport v, DPoint d, DPoint r, Point o, Point s) {
		cursor = new DPoint(0.0, 0.0);
		domain = d;
		range = r;
		origin = o;
		size = s;
		view = v;

		moveTo2D(new DPoint(domain.x, 0.0));
		drawTo2D(new DPoint(domain.y, 0.0));
		moveTo2D(new DPoint(0.0, range.x));
		drawTo2D(new DPoint(0.0, range.y));

		return;
	}

	public void moveTo2D(DPoint p) {
		cursor = p;

		return;
	}

	public void drawTo2D(DPoint p) {
		view.moveTo2D(coordinateToViewport(cursor));

		cursor = p;
		view.drawTo2D(coordinateToViewport(cursor));

		return;
	}

	public Point coordinateToViewport(DPoint p) {
		Point res;

		res = new Point(0, 0);
		res.x = (int)
			((p.x * (size.x / (Math.abs(domain.x) + Math.abs(domain.x))))
			+ origin.x);
		res.y = (int)
			((p.y * (size.y / (Math.abs(range.x) + Math.abs(range.y))))
			+ origin.y);

		return res;
	}
}
