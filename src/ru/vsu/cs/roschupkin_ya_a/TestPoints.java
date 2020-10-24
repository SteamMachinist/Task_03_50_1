package ru.vsu.cs.roschupkin_ya_a;

public class TestPoints
{
    public TestPoints()
    {}

    Point[] testPoints =
    {
        new Point(0, 0),
        new Point(8, 1),
        new Point(3, 3),
        new Point(4, 6),
        new Point(6, 3),
        new Point(-1, 1),
        new Point(-3, -1),
        new Point(-1.5, 3.5),
        new Point(0, 5),
        new Point(-3, 2),
        new Point(-9, -9)
    };

    SimpleColor[] rightColors =
    {
        SimpleColor.GRAY,
        SimpleColor.ORANGE,
        SimpleColor.YELLOW,
        SimpleColor.BLUE,
        SimpleColor.WHITE,
        SimpleColor.WHITE,
        SimpleColor.BLUE,
        SimpleColor.GREEN,
        SimpleColor.YELLOW,
        SimpleColor.ORANGE,
        SimpleColor.GREEN
    };

    Point getPoint(int testPointNumber)
    {
        return testPoints[testPointNumber];
    }

    SimpleColor getRightColor(int testPointNumber)
    {
        return rightColors[testPointNumber];
    }
}
