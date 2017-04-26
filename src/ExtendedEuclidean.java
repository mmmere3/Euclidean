import javax.swing.JOptionPane;

// -------------------------------------------------------------------------
/**
 * This takes two integers as arguments and uses the extended Euclidean
 * algorithm to find the greatest common denominator of the two integers,
 * while printing out the steps along the way.
 *
 * @author meredithmcglynn1
 * @version Feb 11, 2013
 */
public class ExtendedEuclidean
{

    // ----------------------------------------------------------
    /**
     * This prompts the user to enter two integers and then prints out a
     * statement giving the gcd and the linear combination of the two integers
     * into the gcd
     *
     * @param args
     *          The two integers entered
     */
    public static void main(String[] args)
    {
        String in1;
        String in2;
        int a;
        int b;
// This allows for the user to input the first number of a set to find
// the gcd
        in1 = JOptionPane.showInputDialog("Input first integer");
        a = Integer.parseInt(in1);
// This just confirms what number was put in
        System.out.println("You have entered " + a);
// This allows the input of the second number
        in2 = JOptionPane.showInputDialog("Input second integer");
        b = Integer.parseInt(in2);
        System.out.println("You have entered " + b);
// This creates an array that stores the values for the gcd(a, b) in the
// first spot, the value for a in the second, and the value for b in the
// third
        int euc[] = gcd(a, b);
// This prints out the gcd of the two numbers
        System.out
            .println("The gcd is " + euc[0] + " = (" + a + ", " + b + ")");

    }


    // ----------------------------------------------------------
    /**
     * This is what uses a recursive method to find the GCD by using the
     * extended Euclidean algorithm, backtracing the ways
     *
     * @param a
     *          The first integer entered
     * @param b
     *          The second integer entered
     * @return
     *          This returns the gcd of the two integers.
     */
    public static int[] gcd(int a, int b)
    {
// This makes it so that the gcd of any number and 0 is 1.
        if (b == 0)
        {
            return new int[] {a, 1, 0};
        }
// This takes the given integers and finds the gcd of b and a mod b
        int[] euc = gcd(b, a % b);
// This stores the values in an array
        int x = euc[0];
        int y = euc[2];
// This takes the value in the second part of the array and subtracts
// from it the first integer divided by the (second integer multiplied by the
// value that is multiplied by the first integer) as described on p. 109 of the
// book
        int z = euc[1] - (a/b * euc[2]);
//This prints out the gcd as a linear combination of the two numbers
        System.out.println("The gcd " + x + " is equal to " + y + "(" + a
            + ") + " + z + "(" + b + ")");
        return new int[] {x, y, z};

    }

}
