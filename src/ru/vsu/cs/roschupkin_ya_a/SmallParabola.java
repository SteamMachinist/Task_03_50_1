package ru.vsu.cs.roschupkin_ya_a;

public class SmallParabola
{
    public double x0;
    public double y0;
    public double a;

    public SmallParabola (double x0, double y0, double a)
    {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointHigherSmallParabola (double x, double y)
    {
        return (y >= (a * (x - x0) * (x - x0) + y0));
    }
}
