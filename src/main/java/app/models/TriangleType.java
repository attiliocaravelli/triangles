package app.models;

 /**
 * Types of triangles
 */
public enum TriangleType { 
	ISOSCELES("isosceles"),
	EQUILATERAL("equilateral"), 
	SCALENE("scalene");

    private final String text;

    /**
     * @param text
     */
    private TriangleType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}