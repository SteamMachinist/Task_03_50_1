package ru.vsu.cs.roschupkin_ya_a;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        Point SMALL_SQUARE_SMALLEST_POINT = new Point(2, 2);
        Point SMALL_SQUARE_BIGGEST_POINT  = new Point(7, 7);

        Point BIG_SQUARE_SMALLEST_POINT = new Point(-2, -5);
        Point BIG_SQUARE_BIGGEST_POINT  = new Point(6, 4);

        Point  SMALL_PARABOLA_APEX = new Point(-3, 0);
        double SMALL_PARABOLA_QUADRATIC_COEFFICIENT = 1;
        String SMALL_PARABOLA_TYPE = "VERTICAL";

        Point  BIG_PARABOLA_APEX = new Point(-3, -3);
        double BIG_PARABOLA_QUADRATIC_COEFFICIENT = 0.5;
        String BIG_PARABOLA_TYPE = "VERTICAL";

        Point  HORIZONTAL_PARABOLA_APEX = new Point(3, -1);
        double HORIZONTAL_PARABOLA_QUADRATIC_COEFFICIENT = 0.125;
        String HORIZONTAL_PARABOLA_TYPE = "HORIZONTAL";


        Picture picture = new Picture(
            new Square(SMALL_SQUARE_SMALLEST_POINT, SMALL_SQUARE_BIGGEST_POINT),

            new Square(BIG_SQUARE_SMALLEST_POINT, BIG_SQUARE_BIGGEST_POINT),

            new Parabola(SMALL_PARABOLA_APEX,
                    SMALL_PARABOLA_QUADRATIC_COEFFICIENT, SMALL_PARABOLA_TYPE),

            new Parabola(BIG_PARABOLA_APEX,
                    BIG_PARABOLA_QUADRATIC_COEFFICIENT, BIG_PARABOLA_TYPE),

            new Parabola(HORIZONTAL_PARABOLA_APEX,
                    HORIZONTAL_PARABOLA_QUADRATIC_COEFFICIENT, HORIZONTAL_PARABOLA_TYPE)
        );

        runTests(picture);

        Point point = new Point(readCoordinate('X'), readCoordinate('Y'));
        printColorForPoint(point, picture.getColor(point));
    }

    static void runTests(Picture picture)
    {
        for(TestPoints testPoint : TestPoints.values())
        {
            SimpleColor colorForTestPoint = picture.getColor(testPoint.point);

            printColorForPoint(testPoint.point, colorForTestPoint);

            SimpleColor rightColorForTestPoint = testPoint.rightColor;

            printIsColorRight(isColorRight(colorForTestPoint, rightColorForTestPoint),
                    rightColorForTestPoint);
        }
    }

    static void printIsColorRight(boolean isColorRight, SimpleColor rightColor)
    {
        if (isColorRight)
        {
            System.out.println(" IS RIGHT");
        }
        else
        {
            System.out.println(" IS WRONG, MUST BE " + rightColor);
        }
    }

    static boolean isColorRight(SimpleColor testColor, SimpleColor rightColor)
    {
        return (testColor == rightColor);
    }

    static void printColorForPoint (Point point, SimpleColor areaColor)
    {
        System.out.printf("(%6.3f ; %6.3f) -> %s", point.getX(), point.getY(), areaColor);
    }

    static double readCoordinate(char coordinateName)
    {
        System.out.printf("Input %c: ", coordinateName);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
}
