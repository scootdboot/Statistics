import java.util.Arrays;
import java.util.Scanner;

public class Statistics
{
    public static void main(String[] args)
    {
        // TODO take all the inputs
        double[] values = {99, 50, 42, 23, 23, 21, 14, 13, 12, 7};
        System.out.println(median(values));
    }

    public static double average(double[] values)
    {
        double sum = 0;
        for (double num : values)
        {
            sum += num;
        }
        return sum / values.length;
    }

    public static double median(double[] values)
    {
        values = sort(values);

        double median;
        if (values.length % 2 == 1)
            median = values[values.length / 2]; // truncates to the exact midpoint (lucky for me)
        else
        {
            // i initially wrote all this in one line but i hated how complex it was so enjoy
            int indexOne = values.length / 2 - 1;
            int indexTwo = values.length / 2;
            median = (values[indexOne] + values[indexTwo]) / 2;
        }

        return median;
    }

    public static double[] mode(double[] values)
    {
        int[] freqList = new int[values.length];
        double currentNumCheck;
        

        return new double[0];
    }

    public static double[] most(double[] values)
    {
        return new double[1];
    }

    // returns a sorted copy of values
    // does not modify values
    public static double[] sort(double[] values)
    {
        double[] temp = values.clone();
        Arrays.sort(temp);
        return temp;
    }
}