package com.tms.homework.task0.figure.shape;

import com.tms.homework.task0.exception.TriangleNotFoundException;
import com.tms.homework.task0.figure.IFigure;
import com.tms.homework.task0.figure.Point;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;
import org.jetbrains.annotations.NotNull;

@Setter
@Getter
public class Triangle extends Figure implements IFigure {

    private Point firstAnglePoint;
    private Point secondAnglePoint;
    private Point thirdAnglePoint;
    private double dimensionSecond;
    private double dimensionThird;

    public Triangle() {
    }

    public Triangle(@NotNull Point firstAnglePoint, Point secondAnglePoint, Point thirdAnglePoint)
            throws TriangleNotFoundException {
        this.firstAnglePoint = firstAnglePoint;
        this.secondAnglePoint = secondAnglePoint;
        this.thirdAnglePoint = thirdAnglePoint;
        this.dimensionFirst = firstAnglePoint.findDistance(secondAnglePoint);
        this.dimensionSecond = secondAnglePoint.findDistance(thirdAnglePoint);
        this.dimensionThird = thirdAnglePoint.findDistance(firstAnglePoint);
        checkIfExist();
    }

    public double getDimensionFirst() {
        return dimensionFirst;
    }

    @Override
    public double findArea() {
        return Precision.round((Math.sqrt(findPerimeter() *
                (findPerimeter() - dimensionFirst) *
                (findPerimeter() - dimensionSecond) *
                (findPerimeter() - dimensionThird))), 3);
    }

    @Override
    public double findPerimeter() {
        return Precision.round((dimensionFirst + dimensionSecond + dimensionThird), 3);
    }

    @Override
    public String toString() {
        return "Triangle[" +
                "firstAnglePoint=" + firstAnglePoint +
                ", secondAnglePoint=" + secondAnglePoint +
                ", thirdAnglePoint=" + thirdAnglePoint +
                ']';
    }

    private void checkIfExist() throws TriangleNotFoundException {
        if (getDimensionFirst() + getDimensionSecond() < getDimensionThird() ||
                getDimensionSecond() + getDimensionThird() < getDimensionFirst() ||
                getDimensionFirst() + getDimensionThird() < getDimensionSecond() ||
                getDimensionFirst() == getDimensionSecond() ||
                getDimensionSecond() == getDimensionThird() ||
                getDimensionFirst() == getDimensionThird()) {
            throw new TriangleNotFoundException("Error with triangle creation!");
        }
    }
}
