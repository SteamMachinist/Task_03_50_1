package ru.vsu.cs.roschupkin_ya_a;

public enum TestPoints
{
    pointGray(new Point(0, 0), SimpleColor.GRAY),
    pointOrange1(new Point(8, 1), SimpleColor.ORANGE),
    pointYellow1(new Point(3, 3), SimpleColor.YELLOW),
    pointBlue1(new Point(4, 6), SimpleColor.BLUE),
    pointWhite1(new Point(6, 3), SimpleColor.WHITE),
    pointWhite2(new Point(-1, 1), SimpleColor.WHITE),
    pointBlue2(new Point(-3, -1), SimpleColor.BLUE),
    pointGreen1(new Point(-1.5, 3.5), SimpleColor.GREEN),
    pointYellow2(new Point(0, 5), SimpleColor.YELLOW),
    pointOrange2(new Point(-3, 2), SimpleColor.ORANGE),
    pointGreen2(new Point(-9, -9), SimpleColor.GREEN);


    TestPoints(Point point, SimpleColor rightColor)
    {
        this.point = point;
        this.rightColor = rightColor;
    }

    final Point point;
    final SimpleColor rightColor;

    public Point getPoint()
    {
        return point;
    }

    public SimpleColor getRightColor()
    {
        return rightColor;
    }
}
