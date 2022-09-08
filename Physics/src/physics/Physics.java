/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package physics;

import java.util.*;
/**
 *
 * @author travi
 */
import java.util.*;
import static physics.Colubmic.caluclateChargeTwoDimension;

public class Physics
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        Scanner input = new Scanner(System.in);
//        System.out.println("how many charges in electric field");
//        int electricFieldSize = input.nextInt();
//        System.out.println("Enter Charges in the x axis");
//        System.out.printf("%f in the x", Colubmic.electricFieldTwoDimensions(input, electricFieldSize));
//        System.out.println("Enter Charges in the y axis");
//        System.out.printf("%f in the y", Colubmic.electricFieldTwoDimensions(input, electricFieldSize));
double charge1= caluclateChargeTwoDimension(8*Math.pow(10, -9),8.8*Math.pow(10, -9), .03,0.15);
System.out.println(charge1);
double calculation2 =(caluclateChargeTwoDimension(8*Math.pow(10, -9),17.6*Math.pow(10, -9), .03,.03));
System.out.println(calculation2);
double sum = charge1+calculation2;
System.out.println(sum);
System.out.println(caluclateChargeTwoDimension(8*Math.pow(10, -9),8.8*Math.pow(10, -9), .03,0.2598));
double other = caluclateChargeTwoDimension(8*Math.pow(10, -9),8.8*Math.pow(10, -9), .03,0.2598);
System.out.println(Math.pow(Math.pow(other, 2)+Math.pow(sum, 2), .5));
    }

}

class Colubmic
{

    static final double k = 9.88 * Math.pow(10, 9);

    public static double caluclateChargeOneDimension(double charge1, double charge2, double distance1)
    {
        double charge = 0;
        charge = (charge1 * charge2 * k) / Math.pow(distance1, 2);
        return charge;
    }

    public static double caluclateChargeTwoDimension(double charge1, double charge2, double distance, double vectorDistance)
    {
        double charge = 0;
        charge = ((charge1 * charge2 * k) / Math.pow(distance, 2) * (vectorDistance / distance));
        return charge;
    }

    public static double electricFieldTwoDimensions(Scanner input, int fieldSize)
    {
        double electricField = 0;
        System.out.println("enter sourceCarge in nm");
        double sourceCharge = input.nextDouble() * Math.pow(10, -9);
        for (int i = 0; i < fieldSize; i++)
        {
            System.out.printf("enter target charge %d\n", i + 1);
            double targetCharge = input.nextDouble()* Math.pow(10, -9);

            System.out.printf("Enter distance in cm\n");
            double distance = input.nextDouble() * Math.pow(10, -2);
            System.out.printf("Enter vector distance in cm\n");

            double vectorDistance = input.nextDouble() * Math.pow(10, -2);
            electricField += caluclateChargeTwoDimension(sourceCharge, targetCharge, distance,vectorDistance);

        }
        return electricField;
    }

}
