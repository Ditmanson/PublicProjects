
/**
 * @author Travis Ditmanson
 * @email travisditmanson@gmail.com
 */
//package orbitalvelocity;

import java.util.*;

/**
 *
 * @author travis ditmanson description used to calculate orbital velocity for
 * general physics 1
 */
public class OrbitalVelocity
{

    /**
     * used to calculate orbital velocity for general physics 1
     */
    public static void main(String[] args)
    {
        final double BIG_G = 6.674 * Math.pow(10, -11);
        final double EARTH_MASS = 5.98 * Math.pow(10, 24);
        Scanner input = new Scanner(System.in);
        System.out.println("enter oribital distance, use sea level for orgin");
        try
        {
            double radius = input.nextDouble() * 1000 + 6380000;
            double velocity = Math.pow((BIG_G * EARTH_MASS / radius), .5);
            System.out.println("orbital velocity is: " + velocity + " meters/second");
            System.out.printf("orbital velocity is: %.2f km/sec\n", velocity / 1000);
            System.out.printf("orbital velocity is: %.0f km/hour\n", (velocity * 60 * 60) / 1000);
        } catch (Exception e)
        {
            System.out.println("Failed to enter valid number. Rerun program");
        }

    }

}
