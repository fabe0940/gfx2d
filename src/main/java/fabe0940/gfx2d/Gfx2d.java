package fabe0940.gfx2d;

import fabe0940.gfx2d.Window;
import fabe0940.gfx2d.util.Point;
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
		Point origin;
		Viewport v;
		Window w;

		w = new Window(new Point(100, 100), new Point(800, 600));

		v = new Viewport(new Point(5, 595), new Point(390, 590));
		v.moveTo2D(new Point(0, 0));
		v.drawTo2D(v.getSize());
		w.addViewport(v);

		v = new Viewport(new Point(405, 595), new Point(390, 590));
		v.moveTo2D(new Point(0, 0));
		v.drawTo2D(v.getSize());
		w.addViewport(v);

		v = new Viewport(new Point(100, 500), new Point(600, 400));
		v.moveTo2D(new Point(0, 0));
		v.drawTo2D(v.getSize());
		w.addViewport(v);

		return w;
	}

	public static double f(double x) {
		return 3.0 * Math.exp(-0.33 * x) * Math.sin(Math.toRadians(3.0 * x));
	}

	public static double g(double x) {
		return x;
	}
}
