import com.tms.homework.task0.exception.CircleNotFoundException;
import com.tms.homework.task0.exception.RectangleNotFoundException;
import com.tms.homework.task0.figure.Point;
import com.tms.homework.task0.figure.shape.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    @Test
    public void testRectangleCreation() throws RectangleNotFoundException {
        Rectangle rectangle1 = new Rectangle(new Point(3, 6), new Point(7, 9));
        Rectangle rectangle2 = new Rectangle(new Point(1.76, 6.27), new Point(-9, 13));
        try {
            Rectangle rectangle3 = new Rectangle(new Point(3, 6), new Point(3, 6));
            Assert.fail("Error with rectangle creation!");
        } catch (RectangleNotFoundException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }
}
