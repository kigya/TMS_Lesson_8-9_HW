import com.tms.homework.task0.exception.CircleNotFoundException;
import com.tms.homework.task0.figure.Point;
import com.tms.homework.task0.figure.shape.Circle;
import org.junit.Assert;
import org.junit.Test;

public class CircleTest {

    @Test
    public void testFigureCreation() throws CircleNotFoundException {
        Circle circle1 = new Circle(new Point(0, 0), new Point(5, 5));
        Circle circle2 = new Circle(new Point(1.5, -6.233), new Point(9.999, 0));
        try {
            Circle circle3 = new Circle(new Point(1, 1), new Point(1, 1));
            Assert.fail("Error with circle creation!");
        } catch (CircleNotFoundException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

}
