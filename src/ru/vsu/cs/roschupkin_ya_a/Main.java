package ru.vsu.cs.roschupkin_ya_a;

import java.util.Locale;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        printExamples();

        double x = readCoordinate('X');
        double y = readCoordinate('Y');
        printColorForPoint(x, y, getColor(x, y));
    }

    static void printExamples()
    {
        for (int i = 0; i < 11; i++)
        {
            printColorForPoint(readExamplesX(i), readExamplesY(i),
                    getColor(readExamplesX(i), readExamplesY(i)));
        }
    }

    static double readExamplesX(int i)
    {
        double [] xExamples = {0, 8, 3, 4, 6, -1, -3, -1.5 ,0, -3, -9};
        return xExamples[i];
    }

    static double readExamplesY(int i)
    {
        double [] yExamples = {0, 1, 3, 6, 3, 1, -1, 3.5 ,5, 2, -9};
        return yExamples[i];
    }

    static void printColorForPoint (double x, double y, SimpleColor areaColor)
    {
        System.out.printf("(%.3f ; %.3f) -> %s \n", x, y, areaColor);
    }

    static double readCoordinate(char coordinateName)
    {
        System.out.printf("Input %c: ", coordinateName);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    static SimpleColor getColor (double x, double y)
    {
        if (isColorOrange(x, y)) return SimpleColor.ORANGE;

        if (isColorWhite(x, y)) return SimpleColor.WHITE;

        if (isColorBlue(x, y)) return SimpleColor.BLUE;

        if (isColorYellow(x, y)) return SimpleColor.YELLOW;

        if (isColorGray(x, y)) return SimpleColor.GRAY;

        return SimpleColor.GREEN;
    }

    public static final HorizontalParabola horizontalParabola = new HorizontalParabola(3, -1, 0.125);
    public static final BigSquare bigSquare = new BigSquare (-2, -5, 6, 4);
    public static final SmallSquare smallSquare = new SmallSquare(2, 2, 7, 7);
    public static final BigParabola bigParabola = new BigParabola(-3, -3 , 0.5);
    public static final SmallParabola smallParabola = new SmallParabola(-3, 0, 1);

    static boolean isColorOrange (double x, double y)
    {
        return (smallParabola.isPointHigherSmallParabola(x, y) && !bigSquare.isPointInBigSquare(x, y))

                || (horizontalParabola.isPointRightOfParabola(x, y) && !bigSquare.isPointInBigSquare(x, y)
                && !smallSquare.isPointInSmallSquare(x, y));
    }

    static boolean isColorWhite (double x, double y)
    {
        return (bigParabola.isPointHigherBigParabola(x, y) && bigSquare.isPointInBigSquare(x, y) &&
               !smallParabola.isPointHigherSmallParabola(x, y))

                || (smallSquare.isPointInSmallSquare(x, y) && horizontalParabola.isPointRightOfParabola(x, y));

    }

    static boolean isColorBlue (double x, double y)
    {
        return (bigParabola.isPointHigherBigParabola(x, y) && !smallParabola.isPointHigherSmallParabola(x, y)
                && !bigSquare.isPointInBigSquare(x, y) && (x <= -2))

                || (smallSquare.isPointInSmallSquare(x, y) && !horizontalParabola.isPointRightOfParabola(x, y)
                && !bigSquare.isPointInBigSquare(x, y));
    }

    static boolean isColorYellow (double x, double y)
    {
        return (bigParabola.isPointHigherBigParabola(x, y) && !smallParabola.isPointHigherSmallParabola(x, y)
                && !bigSquare.isPointInBigSquare(x, y) && (x > -2))

                || (smallSquare.isPointInSmallSquare(x, y) && !horizontalParabola.isPointRightOfParabola(x, y)
                && bigSquare.isPointInBigSquare(x, y));
    }

    static boolean isColorGray (double x, double y)
    {
        return (bigSquare.isPointInBigSquare(x, y) && !bigParabola.isPointHigherBigParabola(x, y)
                && !smallSquare.isPointInSmallSquare(x, y));
    }
}
