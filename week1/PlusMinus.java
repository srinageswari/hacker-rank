package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
// Print the decimal value of each fraction on a new line with  places after the decimal.
//
// Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
//
// Example
//
// There are  elements, two positive, two negative and one zero. Their ratios are ,  and . Results are printed as:
//
//        0.400000
//        0.400000
//        0.200000

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double positiveCount = 0;
        double negativeCount = 0;
        double zeroCount = 0;
        for(int i : arr)
        {
            if(i>0)
            {
                positiveCount++;
            }
            else if(i<0)
            {
                negativeCount++;
            }
            else
            {
                zeroCount++;
            }
        }
        positiveCount = positiveCount/arr.size();
        negativeCount = negativeCount/arr.size();
        zeroCount = zeroCount/arr.size();
        System.out.println(String.format("%.6f",positiveCount));
        System.out.println(String.format("%.6f",negativeCount));
        System.out.println(String.format("%.6f",zeroCount));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        plusMinus(arr);

        bufferedReader.close();
    }

    //6
    //-4 3 -9 0 4 1

}
