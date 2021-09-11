package com.tms.homework.task0;

import com.tms.homework.task0.exception.CircleNotFoundException;
import com.tms.homework.task0.exception.RectangleNotFoundException;
import com.tms.homework.task0.exception.TriangleNotFoundException;
import com.tms.homework.task0.figure.Point;
import com.tms.homework.task0.figure.shape.Circle;
import com.tms.homework.task0.figure.shape.Figure;
import com.tms.homework.task0.figure.shape.Rectangle;
import com.tms.homework.task0.figure.shape.Triangle;
import com.tms.homework.task0.handler.InputHandler;
import org.apache.commons.math3.util.Precision;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task {

    @Contract("null -> new")
    protected static @NotNull Figure createFigureFromConsole(Figure figure) {
        if (figure instanceof Circle) {
            System.out.println("Circle creation...");
            Circle circle = new Circle();
            System.out.println("Circle center. Enter x and y: ");
            assert false;
            circle.setCenter(new Point(InputHandler.inputDoubleField(), InputHandler.inputDoubleField()));
            System.out.println("Arbitrary point on the circle. Enter x and y: ");
            circle.setPointOnTheCircle(new Point(InputHandler.inputDoubleField(), InputHandler.inputDoubleField()));
            circle.setRadius();

            if (circle.getCenter().equals(circle.getPointOnTheCircle())) {
                try {
                    throw new CircleNotFoundException("Error with circle creation!");
                } catch (CircleNotFoundException e) {
                    e.printStackTrace();
                }
            }

            return circle;

        } else if (figure instanceof Triangle) {
            System.out.println("Triangle creation...");
            Triangle triangle = new Triangle();
            System.out.print("Triangle first angle point. Enter x and y: ");
            triangle.setFirstAnglePoint(new Point(InputHandler.inputDoubleField(), InputHandler.inputDoubleField()));
            System.out.println("Triangle second angle point. Enter x and y: ");
            triangle.setSecondAnglePoint(new Point(InputHandler.inputDoubleField(), InputHandler.inputDoubleField()));
            System.out.println("Triangle third angle point. Enter x and y: ");
            triangle.setThirdAnglePoint(new Point(InputHandler.inputDoubleField(), InputHandler.inputDoubleField()));

            if (triangle.getDimensionFirst() + triangle.getDimensionSecond() < triangle.getDimensionThird() ||
                    triangle.getDimensionSecond() + triangle.getDimensionThird() < triangle.getDimensionFirst() ||
                    triangle.getDimensionThird() + triangle.getDimensionFirst() < triangle.getDimensionSecond()) {
                try {
                    throw new TriangleNotFoundException("Error with triangle creation!");
                } catch (TriangleNotFoundException e) {
                    e.printStackTrace();
                }
            }

            return triangle;
        } else {
            System.out.println("Rectangle creation...");
            Rectangle rectangle = new Rectangle();
            System.out.println("Rectangle left bottom point. Enter x and y: ");
            rectangle.setLeftBottomPoint(new Point(InputHandler.inputDoubleField(), InputHandler.inputDoubleField()));
            System.out.println("Rectangle right top point. Enter x and y: ");
            rectangle.setRightTopPoint(new Point(InputHandler.inputDoubleField(), InputHandler.inputDoubleField()));

            if (rectangle.getLeftBottomPoint().equals(rectangle.getRightTopPoint())) {
                try {
                    throw new RectangleNotFoundException("Error with rectangle creation!");
                } catch (RectangleNotFoundException e) {
                    e.printStackTrace();
                }
            }

            return rectangle;
        }
    }

    protected static @NotNull List<Figure> createFigureList(Figure... figures) {
        ArrayList<Figure> figureList = new ArrayList<>(Collections.emptyList());
        Collections.addAll(figureList, figures);
        return figureList;
    }

    protected static double findListPerimeter(@NotNull List<Figure> figureList) {
        double counter = 0;
        for (Figure figure : figureList) {
            counter += figure.findPerimeter();
        }
        return Precision.round(counter, 3);
    }

    protected static double findListArea(@NotNull List<Figure> figureList) {
        double counter = 0;
        for (Figure figure : figureList) {
            counter += figure.findArea();
        }
        return Precision.round(counter, 3);
    }

}
