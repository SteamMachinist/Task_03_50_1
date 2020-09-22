package ru.vsu.cs.roschupkin_ya_a;

public class BigSquare
{
    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public BigSquare(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean isPointInBigSquare(double x, double y)
    {
        return ((x >= x1) && (x <= x2) && (y >= y1) && (y <= y2));
    }
}
