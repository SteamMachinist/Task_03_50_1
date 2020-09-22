package ru.vsu.cs.roschupkin_ya_a;

public class HorizontalParabola
{
    public double x0;
    public double y0;
    public double a;

    public HorizontalParabola(double x0, double y0, double a)
    {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointRightOfParabola(double x, double y)
    {
        return (x >= (a * (y - y0) * (y - y0) + x0));
    }
}
