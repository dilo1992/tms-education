package by.teachmeskills.homework.lesson7.exercise2;

import by.teachmeskills.classwork.lesson7.Figure;

public class Circle extends Figure {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int getPerimeter() {
        return (int) (2*Math.PI*radius);
    }

    @Override
    public int getArea() {
        return (int) (Math.PI*Math.sqrt(radius));
    }
}

