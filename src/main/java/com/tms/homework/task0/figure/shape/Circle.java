package com.tms.homework.task0.figure.shape;

import com.tms.homework.task0.exception.CircleNotFoundException;
import com.tms.homework.task0.figure.IFigure;
import com.tms.homework.task0.figure.Point;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class Circle extends Figure implements IFigure {

    private Point center;
    private Point pointOnTheCircle;

    public Circle() {
    }

    public Circle(@NotNull Point center, Point pointOnTheCircle) throws CircleNotFoundException {
        this.center = center;
        this.pointOnTheCircle = pointOnTheCircle;
        this.dimensionFirst = Precision.round(center.findDistance(pointOnTheCircle), 3);
        checkIfExists();
    }

    public void setRadius() {
        this.dimensionFirst = Precision.round(center.findDistance(pointOnTheCircle), 3);
    }

    @Override
    public double findArea() {
        return Precision.round(Math.PI * Math.sqrt(Math.pow(dimensionFirst, 2)), 3);
    }

    @Override
    public double findPerimeter() {
        return Precision.round(2 * Math.PI * dimensionFirst, 3);
    }

    @Override
    public String toString() {
        return "Circle[" + center + ", " + dimensionFirst + "]";
    }

    private void checkIfExists() throws CircleNotFoundException {
        if (this.center.equals(this.pointOnTheCircle)) {
            throw new CircleNotFoundException("Error with circle creation!");
        }
    }
}

