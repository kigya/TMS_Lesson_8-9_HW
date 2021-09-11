/**
 * 0. Написать иерархию классов «Фигуры».
 * Фигура -> Треугольник -> Прямоугольник -> Круг.
 * Реализовать ф-ю подсчета площади для каждого типа фигуры и подсчет периметра.
 * Создать массив из 5 фигур. Вывести на экран сумму периметра всех фигур в массиве.
 */

package com.tms.homework.task0;

import com.tms.homework.task0.exception.CircleNotFoundException;
import com.tms.homework.task0.exception.RectangleNotFoundException;
import com.tms.homework.task0.exception.TriangleNotFoundException;
import com.tms.homework.task0.figure.Point;
import com.tms.homework.task0.figure.shape.Circle;
import com.tms.homework.task0.figure.shape.Figure;
import com.tms.homework.task0.figure.shape.Rectangle;
import com.tms.homework.task0.figure.shape.Triangle;
import lombok.SneakyThrows;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    @SneakyThrows
    public static void main(String[] args) {
        logger.debug("Start\n");
        List<Figure> figureList = new ArrayList<>(Collections.emptyList());
        try {
             figureList = Task.createFigureList(Task.createFigureFromConsole(new Circle()),
                    Task.createFigureFromConsole(new Rectangle()),
                    Task.createFigureFromConsole(new Triangle()),
                    new Triangle(new Point(1, 1), new Point(5, 5), new Point(3, 3)),
                    new Rectangle(new Point(2, 2), new Point(7.2, 7.6)),
                    new Circle(new Point(8, 8), new Point(10, 17.5)));
        } catch (CircleNotFoundException | RectangleNotFoundException | TriangleNotFoundException e) {
            logger.fatal("Exception thrown!\n");
            e.printStackTrace();
        }
        System.out.println("Perimeter sum: ".concat(String.valueOf(Task.findListPerimeter(figureList))));
        System.out.println("Area sum: ".concat(String.valueOf(Task.findListArea(figureList))));
        logger.info("End\n");
    }

}
