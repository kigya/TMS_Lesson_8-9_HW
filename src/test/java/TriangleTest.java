import com.tms.homework.task0.exception.TriangleNotFoundException;
import com.tms.homework.task0.figure.Point;
import com.tms.homework.task0.figure.shape.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void testRectangleCreation() throws TriangleNotFoundException {
        Triangle triangle1 = new Triangle(new Point(3, 6), new Point(7, 9), new Point(5, 9));
        Triangle triangle2 = new Triangle(new Point(1.76, 6.27), new Point(-9, 13), new Point(8, 12));
        try {
            Triangle triangle3 = new Triangle(new Point(3, 6), new Point(3, 6), new Point(9, 17));
            Assert.fail("Error with triangle creation!");
        } catch (TriangleNotFoundException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }
}
