package ru.vsu.cs.roschupkin_ya_a;


import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static final HorizontalParabola HP1 = new HorizontalParabola(3, -1, 0.125);
    public static final BigSquare BS1= new BigSquare (-2, -5, 6, 4);
    public static final SmallSquare SS1 = new SmallSquare(2, 2, 7, 7);
    public static final  BigParabola BP1 = new BigParabola(-3, -3 , 0.5);
    public static final SmallParabola SP1 = new SmallParabola(-3, 0, 1);

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        for (int i = 0; i < 11; i++)
        {
            printColorForPoint(examplesX(i), examplesY(i));
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Input X: ");
        double x = sc.nextDouble();
        if ((x < -10) || (x > 10))
        {
            System.out.println("-10 < x < 10");
            System.exit(1);
        }

        System.out.print("Input Y: ");
        double y = sc.nextDouble();
        if ((y < -10) || (y > 10))
        {
            System.out.println("-10 < y < 10");
            System.exit(1);
        }

        printColorForPoint(x, y);
    }

    static double examplesX(int i)
    {
        double [] xExamples = {0, 8, 3, 4, 6, -1, -3, -1.5 ,0, -3, -9};
        return xExamples[i];
    }

    static double examplesY(int i)
    {
        double [] yExamples = {0, 1, 3, 6, 3, 1, -1, 3.5 ,5, 2, -9};
        return yExamples[i];
    }

    public static void printColorForPoint (double x, double y)
    {
        System.out.printf("(%.3f ; %.3f) -> %s \n", x, y, getColor(x, y));
    }

    public static SimpleColor getColor (double x, double y)
    {
        if (SP1.isPointHigherSmallParabola(x, y) && !BS1.isPointInBigSquare(x, y))
            return SimpleColor.ORANGE;

        if (SP1.isPointHigherSmallParabola(x, y) && BS1.isPointInBigSquare(x, y))
            return SimpleColor.GREEN;

        if (BP1.isPointHigherBigParabola(x, y) && BS1.isPointInBigSquare(x, y)
            && !SP1.isPointHigherSmallParabola(x, y))
            return SimpleColor.WHITE;

        if (BP1.isPointHigherBigParabola(x, y) && !SP1.isPointHigherSmallParabola(x, y)
            && !BS1.isPointInBigSquare(x, y) && (x <= -2))
            return SimpleColor.BLUE;

        if (BP1.isPointHigherBigParabola(x, y) && !SP1.isPointHigherSmallParabola(x, y)
            && !BS1.isPointInBigSquare(x, y) && (x > -2))
            return SimpleColor.YELLOW;

        if (BS1.isPointInBigSquare(x, y) && !BP1.isPointHigherBigParabola(x, y)
            && !SS1.isPointInSmallSquare(x, y))
            return SimpleColor.GRAY;

        if (SS1.isPointInSmallSquare(x, y) && !HP1.isPointRightOfParabola(x, y)
            && !BS1.isPointInBigSquare(x, y))
            return SimpleColor.BLUE;

        if (SS1.isPointInSmallSquare(x, y) && !HP1.isPointRightOfParabola(x, y)
                && BS1.isPointInBigSquare(x, y))
            return SimpleColor.YELLOW;

        if (SS1.isPointInSmallSquare(x, y) && HP1.isPointRightOfParabola(x, y))
            return SimpleColor.WHITE;

        if (HP1.isPointRightOfParabola(x, y) && !BS1.isPointInBigSquare(x, y)
            && !SS1.isPointInSmallSquare(x, y))
            return SimpleColor.ORANGE;

        return SimpleColor.GREEN;
    }
}
