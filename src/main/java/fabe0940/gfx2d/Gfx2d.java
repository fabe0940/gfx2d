package fabe0940.gfx2d;

import fabe0940.gfx2d.Coordinate;
import fabe0940.gfx2d.Viewport;
import fabe0940.gfx2d.Window;
import fabe0940.gfx2d.util.Point;
import fabe0940.gfx2d.util.DPoint;
import java.lang.Math.*;

public class Gfx2d {
	public static void main(String[] args) {
		Window w;

		w = initGraphics();

		while(true);
	}

	public static Window initGraphics() {
		final int STEPS = 1000;
		int i;
		double x;
 		double scaleX;
		double scaleY;
		double increment;
		Coordinate c;
		Point origin;
		Viewport v;
		Window w;

		w = new Window(new Point(100, 100), new Point(1200, 400));

		v = new Viewport(new Point(0, 400), new Point(400, 400));
		c = new Coordinate(v, new DPoint(-1.0, 1.0), new DPoint(-1.0, 1.0),
			new Point(200, 200), new Point(390, 390));
		w.addViewport(v);

		v = new Viewport(new Point(400, 400), new Point(400, 400));
		c = new Coordinate(v, new DPoint(-1.0, 1.0), new DPoint(-1.0, 1.0),
			new Point(200, 200), new Point(390, 390));
		w.addViewport(v);

		v = new Viewport(new Point(800, 400), new Point(400, 400));
		c = new Coordinate(v, new DPoint(-1.0, 1.0), new DPoint(-1.0, 1.0),
			new Point(200, 200), new Point(390, 390));
		w.addViewport(v);

		return w;
	}

	public static double f(double x) {
		return 3.0 * Math.exp(-0.33 * x) * Math.sin(Math.toRadians(3.0 * x));
	}

	public static double g(double x) {
		double numerator;
		double denominator;

		numerator = (3.0 * x * x) - (12.0 * x) - (15.0);
		denominator = (x * x) - (3.0 * x) - (10.0);

		return numerator / denominator;
	}

	public static double hUpper(double a, double b, double c, double x) {
		return Math.sqrt((b * c * c * x * x * x) + (a * c * c * x * x));
	}

	public static double hLower(double a, double b, double c, double x) {
		return -1.0 * Math.sqrt((b * c * c * x * x * x) + (a * c * c * x * x));
	}
}
