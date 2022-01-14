import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/*
https://www.hackerrank.com/challenges/equal-stacks/problem
 */
class Result {

    /*
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int sum1 = h1.stream().mapToInt(Integer::intValue).sum();
        int sum2 = h2.stream().mapToInt(Integer::intValue).sum();
        int sum3 = h3.stream().mapToInt(Integer::intValue).sum();
        Queue<Integer> s1 = new LinkedList<>();
        Queue<Integer> s2 = new LinkedList<>();
        Queue<Integer> s3 = new LinkedList<>();

        s1.addAll(h1);
        s2.addAll(h2);
        s3.addAll(h3);
        int maxSum = 0;
        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
            if (sum1 == sum2 && sum1 == sum3) {
                maxSum = sum1;
                break;
            }
            if (sum1 < sum2 || sum3 < sum2) sum2 -= s2.poll();
            else if (sum1 < sum3 || sum2 < sum3) sum3 -= s3.poll();
            else if (sum2 < sum1 || sum3 < sum1) sum1 -= s1.poll();
        }

        return maxSum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
