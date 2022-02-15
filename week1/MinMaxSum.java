package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
// Then print the respective minimum and maximum values as a single line of two space-separated long integers.
//
// Example
// The minimum sum is  and the maximum sum is . The function prints
// 16 24

public class MinMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int start = 0;
        int end = arr.size()-1;
        long min = 0;
        long max = 0;
        long sum = 0;
        while(start<4)
        {
            sum = sum + arr.get(start);
            start++;
        }
        min = max = Math.max(min, sum);
        while(end!=arr.size()-1-4)
        {
            sum = sum + arr.get(end);
            start--;
            sum = sum - arr.get(start);
            end--;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        System.out.println(min+" "+max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }
}

//769082435 210437958 673982045 375809214 380564127
