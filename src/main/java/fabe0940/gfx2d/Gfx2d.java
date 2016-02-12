package fabe0940.gfx2d;

import fabe0940.gfx2d.Window;
import fabe0940.gfx2d.util.Point;

public class Gfx2d {
	public static void main(String[] args) {
		Window w;

		w = initGraphics();

		while(true);
	}

	public static Window initGraphics() {
		Window w;
		Viewport v;

		w = new Window(new Point(100, 100), new Point(800, 600));

		v = new Viewport(new Point(0, 600), new Point(400, 600));
		w.addViewport(v);

		v = new Viewport(new Point(400, 600), new Point(400, 600));
		w.addViewport(v);

		return w;
	}
}
