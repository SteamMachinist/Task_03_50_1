package ru.vsu.cs.roschupkin_ya_a;

public class Picture
{
    Square smallSquare;
    Square bigSquare;
    Parabola smallParabola;
    Parabola bigParabola;
    Parabola horizontalParabola;

    public Picture(Square smallSquare, Square bigSquare,
                   Parabola smallParabola, Parabola bigParabola, Parabola horizontalParabola)
    {
        this.smallSquare = smallSquare;
        this.bigSquare = bigSquare;
        this.smallParabola = smallParabola;
        this.bigParabola = bigParabola;
        this.horizontalParabola = horizontalParabola;
    }

    SimpleColor getColor(Point point)
    {
        if (smallParabola.isPointInside(point)
                && bigSquare.isPointInside(point)) return SimpleColor.GREEN;

        if (smallParabola.isPointInside(point)) return SimpleColor.ORANGE;

        if (bigParabola.isPointInside(point)
                && bigSquare.isPointInside(point)) return SimpleColor.WHITE;

        if (bigParabola.isPointInside(point) && (point.getY() >= 4)) return SimpleColor.YELLOW;

        if (bigParabola.isPointInside(point)) return SimpleColor.BLUE;

        if (horizontalParabola.isPointInside(point) &&
                smallSquare.isPointInside(point)) return SimpleColor.WHITE;

        if (horizontalParabola.isPointInside(point) &&
                !(bigSquare.isPointInside(point))) return SimpleColor.ORANGE;

        if (bigSquare.isPointInside(point)
                && smallSquare.isPointInside(point)) return SimpleColor.YELLOW;

        if (smallSquare.isPointInside(point)) return SimpleColor.BLUE;

        if (bigSquare.isPointInside(point)) return SimpleColor.GRAY;

        return SimpleColor.GREEN;
    }
}
