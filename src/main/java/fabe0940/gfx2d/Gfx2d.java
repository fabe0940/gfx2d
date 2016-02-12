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

		/* Initialize window */
		w = initGraphics();

		/* Swing handles all the real work - just idle */
		while(true);
	}

	/* Exponential function */
	public static double f(double x) {
		return 3.0 * Math.exp(-0.33 * x) * Math.sin(3.0 * x);
	}

	/* Discontinuous function */
	public static double g(double x) {
		double numerator;
		double denominator;

		numerator = (3.0 * x * x) - (12.0 * x) - (15.0);
		denominator = (x * x) - (3.0 * x) - (10.0);

		return numerator / denominator;
	}

	/* Loopy function, positive half */
	public static double hUpper(double a, double b, double c, double x) {
		return Math.sqrt((b * c * c * x * x * x) + (a * c * c * x * x));
	}

	/* Loopy function, negative half */
	public static double hLower(double a, double b, double c, double x) {
		return -1.0 * Math.sqrt((b * c * c * x * x * x) + (a * c * c * x * x));
	}

	/* Initialize graphics window */
	public static Window initGraphics() {
		final int STEPS = 1000;
		int i;
		double a;
		double b;
		double c;
		double increment;
		double x;
		Coordinate coord;
		Viewport view;
		Window win;

		/* Create window */
		win = new Window(new Point(100, 100), new Point(1200, 800));

		/* Create viewport */
		view = new Viewport(new Point(10, 390), new Point(380, 380));

		/* Create exponential graph */
		coord = new Coordinate(view, new DPoint(0.0, 3.0 * Math.PI),
			new DPoint(-5.0, 5.0), new Point(0, 190), new Point(380, 380));
		x = 0.0;
		increment = (3 * Math.PI) / STEPS;
		coord.moveTo2D(new DPoint(x, f(x)));
		for (i = 0; i < STEPS; i++) {
			x += increment;
			coord.drawTo2D(new DPoint(x, f(x)));
		}

		/* Render graph */
		win.addViewport(view);

		/* Create viewport */
		view = new Viewport(new Point(410, 390), new Point(380, 380));

		/* Create discontinuous graph */
		coord = new Coordinate(view, new DPoint(-6.0, 6.0),
			new DPoint(-10.0, 10.0), new Point(190, 190), new Point(380, 380));
		x = -6.0;
		increment = 12.0 / STEPS;
		coord.moveTo2D(new DPoint(x, g(x)));
		for (i = 0; i < STEPS; i++) {
			x += increment;
			coord.drawTo2D(new DPoint(x, g(x)));
		}

		/* Render graph */
		win.addViewport(view);

		/* Create viewport */
		view = new Viewport(new Point(10, 790), new Point(380, 380));

		/* Create loopy graph, b = 0.5 */
		coord = new Coordinate(view, new DPoint(-1.0, 1.0),
			new DPoint(-1.0, 1.0), new Point(190, 190), new Point(380, 380));
		a = 0.5;
		b = 0.5;
		c = 1.0;
		x = -1.0;
		increment = 2.0 / STEPS;
		coord.moveTo2D(new DPoint(x, hUpper(a, b, c, x)));
		for (i = 0; i < STEPS; i++) {
			x += increment;
			coord.drawTo2D(new DPoint(x, hUpper(a, b, c, x)));
		}
		x = -1.0;
		coord.moveTo2D(new DPoint(x, hLower(a, b, c, x)));
		for (i = 0; i < STEPS; i++) {
			x += increment;
			coord.drawTo2D(new DPoint(x, hLower(a, b, c, x)));
		}

		/* Render graph */
		win.addViewport(view);

		/* Create viewport */
		view = new Viewport(new Point(410, 790), new Point(380, 380));

		/* Create loopy graph, b = 1.0 */
		coord = new Coordinate(view, new DPoint(-1.0, 1.0),
			new DPoint(-1.0, 1.0), new Point(190, 190), new Point(380, 380));
		a = 0.5;
		b = 1.0;
		c = 1.0;
		x = -1.0;
		increment = 2.0 / STEPS;
		coord.moveTo2D(new DPoint(x, hUpper(a, b, c, x)));
		for (i = 0; i < STEPS; i++) {
			x += increment;
			coord.drawTo2D(new DPoint(x, hUpper(a, b, c, x)));
		}
		x = -1.0;
		coord.moveTo2D(new DPoint(x, hLower(a, b, c, x)));
		for (i = 0; i < STEPS; i++) {
			x += increment;
			coord.drawTo2D(new DPoint(x, hLower(a, b, c, x)));
		}

		/* Render graph */
		win.addViewport(view);

		/* Create viewport */
		view = new Viewport(new Point(810, 790), new Point(380, 380));

		/* Create loopy graph, b = 2.0 */
		coord = new Coordinate(view, new DPoint(-1.0, 1.0),
			new DPoint(-1.0, 1.0), new Point(190, 190), new Point(380, 380));
		a = 0.5;
		b = 2.0;
		c = 1.0;
		x = -1.0;
		increment = 2.0 / STEPS;
		coord.moveTo2D(new DPoint(x, hUpper(a, b, c, x)));
		for (i = 0; i < STEPS; i++) {
			x += increment;
			coord.drawTo2D(new DPoint(x, hUpper(a, b, c, x)));
		}
		x = -1.0;
		coord.moveTo2D(new DPoint(x, hLower(a, b, c, x)));
		for (i = 0; i < STEPS; i++) {
			x += increment;
			coord.drawTo2D(new DPoint(x, hLower(a, b, c, x)));
		}

		/* Render graph */
		win.addViewport(view);

		return win;
	}
}
