import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.io.*;
import java.math.BigInteger;
import java.util.Random;

public class MyBigIntegers {

    static ThreadMXBean bean = ManagementFactory.getThreadMXBean();
    // defining variables
    static int numberOfTrials = 25; //50 for plus 25 for times/timesfaster
    static int MAXINPUTSIZE = (int)Math.pow(2,18);
    static int MININPUTSIZE = 1; // starting at 1

    static String ResultsFolderPath = "/home/ryan/Results/"; // pathname to results folder
    static FileWriter resultsFile;
    static PrintWriter resultsWriter;

    private String value;

    public static void main(String args[])
    {

      // tests
        String string1 = "5008904578";
        String string2 = "1512345678";
        String string3 = "11111111111111111111111111119999999";
        String string4 = "11111111111110000000000000004111111";
        String string5 = "9999999999999999999999999999999999999";
        String string6 = "1";
        String string7 = "44444444444444444444444411111111111111111111111";
        String string8 = "11111111111111111111111111111111111111";
        String string9 = "22222222222222222222222222222222222222";
        String string10 = "333333333333333333333333333333333333333333333333";
        String string11 = "44444444444444444444444444444444444444444444444";
        String string12 = "5555555555555555555555555555555555555555555555";

        MyBigIntegers a = new MyBigIntegers(string1);
        MyBigIntegers b = new MyBigIntegers(string2);

        System.out.println("MyBigInteger Tests");

        a.testTimesBig(string1, string2);
        a.testKaraBig(string1, string2);
        a.testTimesBig(string2, string3);
        a.testKaraBig(string2, string3);
        a.testTimesBig(string5, string6);
        a.testKaraBig(string5, string6);
        a.testTimesBig(string5, string7);
        a.testKaraBig(string5, string7);
        a.testTimesBig(string12, string10);
        a.testKaraBig(string12, string10);
        a.testTimesBig(string7, string12);
        a.testKaraBig(string7, string12);
        a.testTimesBig(string12, string7);
        a.testKaraBig(string12, string7);
        a.testTimesBig(string1, string7);
        a.testKaraBig(string1, string7);
        a.testTimesBig(string2, string8);
        a.testKaraBig(string2, string8);
        a.testTimesBig(string3, string9);
        a.testKaraBig(string3, string9);

        a.testPlusBig(string1, string10);
        a.testPlusBig(string2, string10);
        a.testPlusBig(string3, string10);
        a.testPlusBig(string4, string10);
        a.testPlusBig(string5, string10);
        a.testPlusBig(string6, string10);
        a.testPlusBig(string7, string10);
        a.testPlusBig(string8, string10);
        a.testPlusBig(string9, string10);
        a.testPlusBig(string11, string10);

        System.out.println("Addition tests");
        a.testPlus(74533333, 1823333333);
        a.testPlus(150, 20);
        a.testPlus(111111, 12089);

        System.out.println("Multiplication tests");
        a.testTimes(75533333, 1823333);
        a.testTimes(150, 20);
        a.testTimes(111111, 12089);

        a.testRandomDigits(10);

/*
        System.out.println("Running first full experiment ...");
        runFullExperiment("Plus-Exp1-ThrowAway.txt");
        System.out.println("Running second full experiment ...");
        runFullExperiment("Plus-Exp2.txt");
        System.out.println("Running third full experiment ...");
        runFullExperiment("Plus-Exp3.txt");

        System.out.println("Running first full experiment ...");
        runFullExperiment("Times-Exp1-ThrowAway.txt");
        System.out.println("Running second full experiment ...");
        runFullExperiment("Times-Exp2.txt");
        System.out.println("Running third full experiment ...");
        runFullExperiment("Times-Exp3.txt");

        System.out.println("Running first full experiment ...");
        runFullExperiment("TimesFaster-Exp1-ThrowAway.txt");
        System.out.println("Running second full experiment ...");
        runFullExperiment("TimesFaster-Exp2.txt");
        System.out.println("Running third full experiment ...");
        runFullExperiment("TimesFaster-Exp3.txt");
*/
    }

   /* static void runFullExperiment(String resultsFileName)
    {
        // making sure that we have results files available or can create new

        try {
            resultsFile = new FileWriter(ResultsFolderPath + resultsFileName);
            resultsWriter = new PrintWriter(resultsFile);
        } catch (Exception e) {
            System.out.println("*****!!!!!  Had a problem opening the results file " + ResultsFolderPath + resultsFileName);
            return;
        }

        ThreadCPUStopWatch TrialStopwatch = new ThreadCPUStopWatch(); // for timing an individual trial

        resultsWriter.println("#InputSize    AverageTime"); // # marks a comment in gnuplot data
        resultsWriter.flush();

        // for each size of input we want to test: in this case starting small and doubling the size each time

        for (int inputSize = MININPUTSIZE; inputSize <= MAXINPUTSIZE; inputSize *= 2) {
            System.out.println("Running test for input size " + inputSize + " ... ");
            /* repeat for desired number of trials (for a specific size of input)... */
            // will hold total amount of time
            // will reset after each batch of trials
   /*         long batchElapsedTime = 0;

            /* force garbage collection before each batch of trials run so it is not included in the time */
   /*         System.gc();

            // run the trials
            for (int trial = 0; trial < numberOfTrials; trial++) {
                //System.out.println("    Generating test data...");
                // create out test values
                String test1 = randomDigits(inputSize);
                String test2 = randomDigits(inputSize);

                // instances for to test
               // MyBigIntegers toTest1 = new MyBigIntegers(test1);
               // MyBigIntegers toTest2 = new MyBigIntegers(test2);

                // for the TimesFaster Method :(
                BigInteger toTest1 = new BigInteger(test1);
                BigInteger toTest2 = new BigInteger(test2);


                //System.out.print("    Running trial batch...");
                /* force garbage collection before each trial run so it is not included in the time */
  /*              System.gc();
                //actual beginning of trial
                TrialStopwatch.start(); // *** uncomment this line if timing trials individually
                /* run the function we're testing on the trial input */
                /* **********************************************UNCOMMENT ONE******************************************/
                //toTest1.Plus(toTest2);
                //toTest1.Times(toTest2);
   /*             TimesFaster(toTest1, toTest2);
                /* *****************************************************************************************************/

  /*              batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();
            }

            batchElapsedTime = TrialStopwatch.elapsedTime();

            double averageTimePerTrialInBatch = (double) batchElapsedTime / (double)numberOfTrials; // calculate the average time per trial in this batch
            /* print data for this size of input */
 /*           resultsWriter.printf("%12d  %15.2f \n",inputSize, averageTimePerTrialInBatch); // might as well make the columns look nice
            resultsWriter.flush();
            System.out.println(" ....done.");

        }
    }*/
    // returns a string of random digits
    public static String randomDigits(int inputSize)
    {
        StringBuilder returnDigits = new StringBuilder();
        Random ran = new Random();

        for (int j = 0; j < inputSize; j++) {
             returnDigits.append((ran.nextInt(10)));
        }
        return returnDigits.toString();
    };



    // constructor that sets Value to 0
    public MyBigIntegers()
    {
        this.value = "0";
    }

    // constructor that sets Value to a passed in string of a decimal integer
    public MyBigIntegers(String stringOfDecimalInt)
    {
        this.value = stringOfDecimalInt;
    }

    // returns the String Value
    public String ToString()
    {
        return this.value;
    }

    // returns a new MyBigIntegers with value of this.value + x.value
    public MyBigIntegers Plus(MyBigIntegers x) {

        MyBigIntegers a = new MyBigIntegers();
        String n = "";
        int carry = 0;
        // k will be the length of the instance that is calling the method
        int k = this.value.length()-1;
        // h will be the length of the value of the arg x
        int h = x.value.length()-1;

        // in case an operand is 0. could be used in multiplication later
        //if ( k == 0 /*&& Character.getNumericValue(this.value.charAt(k)) == 0*/)
          //  return x;
        if ( h == 0 && Character.getNumericValue(x.value.charAt(h)) == 0)
            return this;
        // sum at index i
        int sum = 0;
        // base for our number system
        int base = 10;
        // these variables are necessary because I decrement h and k
        int hTotal = h;
        int beginMin = Math.min(h,k);
        int maxNumOfDigits = Math.max(h,k);

        for (int i = 0; i <= maxNumOfDigits; i++) {
            if (i <= beginMin)
                sum = (Character.getNumericValue(this.value.charAt(k))) + (Character.getNumericValue(x.value.charAt(h))) + carry;
            else if (i <= hTotal)
                sum = (Character.getNumericValue(x.value.charAt(h))) + carry;
            else
                sum = (Character.getNumericValue(this.value.charAt(k))) + carry;
            if (sum >= base) {
                carry = 1;
                sum = sum - base;
                n += String.valueOf(sum);
            } else {
                carry = 0;
                n += String.valueOf(sum);
            }
            // these clauses prevent indices from going out of bounds
            if ( h > 0)
                --h;
            if ( k > 0)
                --k;
        }
        // if a new digit is added at the end
        if ( carry == 1)
        {
            n += '1';
        }
        // reverses the digits to the correct way
        a.value = new StringBuilder(new String(n)).reverse().toString();
        return a;
    }

    // returns a negative value of the the arg
    public MyBigIntegers Negate(MyBigIntegers x)
    {
        MyBigIntegers newNeg = new MyBigIntegers();
        StringBuilder negativeVal = new StringBuilder();
        negativeVal.append('-');

        for (int i = 0; i < x.value.length(); i++)
            negativeVal.append(x.value.charAt(i));

        newNeg.value = negativeVal.toString();

        return newNeg;
    }

    // returns a new MyBigIntegers with value of this.value * x.value
    public MyBigIntegers Times(MyBigIntegers x)
    {
        // will hold the final result
        MyBigIntegers answer = new MyBigIntegers();
        // will be the added to answer each iteration
        MyBigIntegers valToAdd = new MyBigIntegers();

        // lengths of the strings
        int k = this.value.length() - 1;
        int h = x.value.length() - 1;

        // using these as indices instead of decrementing the original values
        int upperI = k;
        int innerI = h;

        // will keep track of 0s for multiplication after the first term
        int count = 0;

        // product is temp product value
        int product = 0;
        // value to carry to next mult
        int carry = 0;
        // for determining carry and the digit that is kept
        int base = 10;

        // loop through the digits of the bottom value
        for ( int i = 0; i <= h; i++)
        {
            // reset upperI for each new inner iteration
            upperI = k;
            // this is going to hold our answer in but reversed
            String stringVal = "";
            // adding 0s based off the number of digits we have multiplied from the bottom operand
            for ( int a = 1; a <= count; a++)
                stringVal += String.valueOf(0);
            // carry is reset to 0 for each iteration of the inner loop
            carry = 0;
            for ( int j = 0; j <= k; j++)
            {
                // the actual multiplication
                product = Character.getNumericValue(this.value.charAt(upperI)) * Character.getNumericValue(x.value.charAt((innerI))) + carry;
                // for the next iteration
                carry = product / base;
                stringVal += String.valueOf(product % base);
                // dec upperI for the next value to multiply by
                upperI--;
            }
            // increase count for another 0
            ++count;
            // adds an extra digit to the beginning (or end in this case) of the value if carry > 0
            if (carry > 0)
                stringVal += String.valueOf(carry);

            // reversing the string putting it in the valToAdd instance
            valToAdd.value = new StringBuilder(new String(stringVal)).reverse().toString();

            answer = answer.Plus(valToAdd);
            // dec for the next round of multiplication
            innerI--;

        }

        return answer;
    }

    // source : https://introcs.cs.princeton.edu/java/99crypto/Karatsuba.java.html
    public static BigInteger TimesFaster(BigInteger first, BigInteger second)
    {
       int N = Math.max (first.bitLength(), second.bitLength());
       // if the BigInts are not super large just use normal multiplication
       if ( N <= 2000)
           return first.multiply(second);

       N = (N / 2) + (N % 2);

       BigInteger b = first.shiftRight(N);
       BigInteger a = first.subtract(b.shiftLeft(N));
       BigInteger d = second.shiftRight(N);
       BigInteger c = second.subtract(d.shiftLeft(N));

       BigInteger ac = TimesFaster(a, c);
       BigInteger bd = TimesFaster(b, d);
       BigInteger abcd = TimesFaster(a.add(b), c.add(d));

       return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }

    // tests the MyBigIntegers Plus function to normal long integer addition
    public void testPlus(long first, long second)
    {
        long sum = first + second;
        System.out.println("Long:      " + first + " + "  + second  + " = " + sum);

        MyBigIntegers add1 = new MyBigIntegers();
        MyBigIntegers add2 = new MyBigIntegers();

        add1.value = String.valueOf(first);
        add2.value = String.valueOf(second);

        System.out.println("MyBigInts: " + add1.ToString() + " + " + add2.ToString() + " = " + add1.Plus(add2).ToString());

        if ( add1.Plus(add2).ToString().compareTo(String.valueOf(first+second)) == 0)
            System.out.println("The values are equivalent.");
        else
            System.out.println("The values are unequal.");

    }

    // tests the times and timesfast functions of the MyBigIntegerClass
    public void testTimes(long first, long second)
    {
        long product = first * second;
        System.out.println("Long:      " + first + " * "  + second  + " = " + product);

        MyBigIntegers opp1 = new MyBigIntegers();
        MyBigIntegers opp2 = new MyBigIntegers();

        BigInteger bigOpp1 = new BigInteger(String.valueOf(first));
        BigInteger bigOpp2 = new BigInteger(String.valueOf(second));

        opp1.value = String.valueOf(first);
        opp2.value = String.valueOf(second);

        System.out.println("MyBigInts: " + opp1.ToString() + " * " + opp2.ToString() + " = " + opp1.Times(opp2).ToString());

        System.out.println("Karatsuba: " + bigOpp1.toString() + " * " + bigOpp2.toString() + " = " + TimesFaster(bigOpp1, bigOpp2).toString());

        if ( opp1.Times(opp2).ToString().compareTo(String.valueOf(first*second)) == 0)
            System.out.println("The values are equivalent.");
        else
            System.out.println("The values are unequal.");

    }

    // tests addition on larger numbers
    public void testPlusBig(String opp1, String opp2)
    {
        MyBigIntegers a = new MyBigIntegers(opp1);
        MyBigIntegers b = new MyBigIntegers(opp2);

        System.out.println( a.ToString() + " + " + b.ToString() + " = " + a.Plus(b).ToString());
    }

    public void testTimesBig(String opp1, String opp2)
    {
        MyBigIntegers a = new MyBigIntegers(opp1);
        MyBigIntegers b = new MyBigIntegers(opp2);

        System.out.println("Times:");
        System.out.println( a.ToString() + " * " + b.ToString() + " = " + a.Times(b).ToString());
    }

    public void testKaraBig(String opp1, String opp2)
    {
        BigInteger a = new BigInteger(opp1);
        BigInteger b = new BigInteger(opp2);

        System.out.println("Karatsuba:");
        System.out.println( a.toString() + " * " + b.toString() + " = " + a.multiply(b).toString());
    }

    public void testRandomDigits(int inputSize)
    {
        System.out.println("Testing randomDigit creation:");
        for (int i = 1; i <= inputSize; i++)
        {
            System.out.println(i + " size" + ": " + randomDigits(i));
        }

    }
}
