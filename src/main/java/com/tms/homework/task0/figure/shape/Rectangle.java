package com.tms.homework.task0.figure.shape;


import com.tms.homework.task0.exception.RectangleNotFoundException;
import com.tms.homework.task0.figure.IFigure;
import com.tms.homework.task0.figure.Point;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class Rectangle extends Figure implements IFigure {

    private Point leftBottomPoint;
    private Point rightTopPoint;
    private double dimensionSecond;

    public Rectangle() {
    }

    public Rectangle(@org.jetbrains.annotations.NotNull Point leftBottomPoint, @NotNull Point rightTopPoint)
            throws RectangleNotFoundException {
        this.leftBottomPoint = leftBottomPoint;
        this.rightTopPoint = rightTopPoint;
        this.dimensionFirst = Precision.round((leftBottomPoint
                .findDistance(new Point(leftBottomPoint.getX(), rightTopPoint.getY()))), 3);
        this.dimensionSecond = Precision.round((rightTopPoint
                .findDistance(new Point(leftBottomPoint.getX(), rightTopPoint.getY()))), 3);
        checkIfExists();
    }

    @Override
    public double findArea() {
        return Precision.round((dimensionFirst * dimensionSecond), 3);
    }

    @Override
    public double findPerimeter() {
        return Precision.round(((dimensionFirst + dimensionSecond) * 2), 3);
    }

    @Override
    public String toString() {
        return "Rectangle[Diagonal points: " + leftBottomPoint + ", " + rightTopPoint + "]";
    }

    private void checkIfExists() throws RectangleNotFoundException {
        if (this.leftBottomPoint.equals(this.rightTopPoint)) {
            throw new RectangleNotFoundException("Error with rectangle creation!");
        }
    }

}
