package ru.vsu.cs.roschupkin_ya_a;

public class Parabola implements Shape
{
    Point apex;
    double quadraticCoefficient;
    String type;

    public Parabola(Point apex, double quadraticCoefficient, String type)
    {
        this.apex = apex;
        this.quadraticCoefficient = quadraticCoefficient;
        this.type = type;
    }

    public boolean isPointInside(Point point)
    {
        if (type.equals("VERTICAL"))
        {
            return (point.getY() >= (quadraticCoefficient * (point.getX() - apex.getX())
                    * (point.getX() - apex.getX()) + apex.getY()));
        }

        if (type.equals("HORIZONTAL"))
        {
            return (point.getX() >= (quadraticCoefficient * (point.getY() - apex.getY())
                    * (point.getY() - apex.getY()) + apex.getX()));
        }

        return false;
    }
}
