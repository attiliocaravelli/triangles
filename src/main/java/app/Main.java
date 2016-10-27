/**
 * 
 */
package app;

import app.models.Triangle;

/**
 * Main Class
 * @author Attilio Caravelli
 *
 */
public class Main {

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: triangle sideA sideB sideC");
			System.exit(0);
		}
		try {
			Triangle triangle = new Triangle(args[0],args[1],args[2]); 
			System.out.println("The triangle is " + triangle.getType());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
