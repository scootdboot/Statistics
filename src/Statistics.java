import java.util.Arrays;
import java.util.Scanner;

public class Statistics
{
    public static void main(String[] args)
    {
        // TODO take all the inputs
        System.out.print("""
                    Welcome to Statistics!
                    This program will calculate the average, median, mode, and most of any number of (double) values!
                    
                    How many values will you be entering?\s""");

        Scanner kb = new Scanner(System.in);
        int numberOfValues = kb.nextInt();
        double[] values = new double[numberOfValues];
        System.out.println();
        for (int i = 0; i < values.length; i++)
        {
            System.out.print("> Please enter value #" + (i + 1) + ": ");
            values[i] = kb.nextDouble();
        }
        System.out.println();

        ArrayHelper.display(values);
        System.out.println("Average: " + average(values));
        System.out.println("Median: " + median(values));
        System.out.print("Mode: ");
        ArrayHelper.display(mode(values));
        System.out.print("Most: ");
        ArrayHelper.display(most(values));
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

        for (int i = 0; i < values.length; i++)
        {
            // if freqList contains a reference to a previous index here just go to the next number
            if (freqList[i] < 0)
                continue;

            double numToCheck = values[i];
            int sumOfDuplicates = 1;
            // loop through values and find out how many duplicates there are + mark them in freqList
            for (int j = i + 1; j < values.length; j++)
            {
                if (values[j] == numToCheck)
                {
                    freqList[j] = (i / -1) - 1;
                    sumOfDuplicates++;
                }
            }
            // add the frequency to freqList
            freqList[i] = sumOfDuplicates;
        }

        // find out how many elements will need to be in the array i return
        int maxFreq = ArrayHelper.max(freqList);
        int rtnLen = 0;
        for (int freq : freqList)
        {
            if (freq == maxFreq)
                rtnLen++;
        }

        // actually add all the elements to it and return it
        double[] rtn = new double[rtnLen];
        int rtnIndex = 0;
        for (int i = 0; i < freqList.length; i++)
        {
            if (freqList[i] == maxFreq)
            {
                rtn[rtnIndex] = values[i];
                rtnIndex++;
            }
        }

        return rtn;
    }

    public static double[] most(double[] values)
    {
        double average = average(values);
        int rtnLen = 0;
        for (double value : values)
        {
            if (value >= average)
                rtnLen++;
        }

        double[] rtn = new double[rtnLen];
        int rtnIndex = 0;
        for (double value : values)
        {
            if (value >= average)
            {
                rtn[rtnIndex] = value;
                rtnIndex++;
            }
        }

        return rtn;
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