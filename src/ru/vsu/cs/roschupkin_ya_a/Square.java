package ru.vsu.cs.roschupkin_ya_a;

public class Square implements Shape
{
    Point smallestPoint;
    Point biggestPoint;

    public Square(Point smallestPoint, Point biggestPoint)
    {
        this.smallestPoint = smallestPoint;
        this.biggestPoint = biggestPoint;
    }

    public boolean isPointInside(Point point)
    {
        return ((point.getX() >= smallestPoint.getX()) && (point.getX() <= biggestPoint.getX())
                && (point.getY() >= smallestPoint.getY()) && (point.getY() <= biggestPoint.getY()));
    }
}
