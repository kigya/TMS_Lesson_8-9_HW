package com.tms.homework.task0.figure;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Point {

    private double x;
    private double y;

    public double findDistance(@NotNull Point point) {
        return Precision.round(Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2)), 3);
    }

    @Override
    public String toString() {
        return "Point[" + x + ", " + y + "]";
    }

}
