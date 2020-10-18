package ru.vsu.cs.roschupkin_ya_a;

import java.util.Locale;
import java.util.Scanner;

public class Main {

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
        if (isColorWhite(x, y)) return SimpleColor.WHITE;
        return SimpleColor.BLUE;
    }

    public static boolean isColorWhite (double x, double y)
    {
        return y >= (0.5 * (x + 3) * (x + 3) - 3) && (y <= (x + 3) * (x + 3))
                && ((x >= -2) && (x <= 6) && (y >= -5) && (y <= 4))
                || (x >= 2) && (x <= 7) && (y >= 2) && (y <= 7) && x >= (0.125 * (y + 1) * (y + 1) + 3);
    }

    public static boolean isColorGray (double x, double y)
    {
        return true;
    }

    public static boolean isColorOrange (double x, double y)
    {
        return true;
    }

    public static boolean isColorYellow (double x, double y)
    {
        return true;
    }

    public static boolean isColorGreen (double x, double y)
    {
        return true;
    }

    public static boolean isColorBlue (double x, double y)
    {
        return true;
    }
}
