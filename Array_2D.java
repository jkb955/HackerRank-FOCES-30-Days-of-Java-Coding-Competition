/*
  
PROBLEM STATEMENT

You are given a 6*6 2D array. An hourglass in an array is a portion shaped like this:

a b c
  d
e f g
For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format

There will be exactly 6 lines, each containing 6 integers seperated by spaces. Each integer will be between -9 and 9 inclusive.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output

19

Explanation

The hourglass which has the largest sum is:

2 4 4
  2
1 2 4

*/
  
//SOLUTION
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Arrays;

public class Array_2D{
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[] sum = new int[16];
        int max = 0;
        int[][] arr = new int[6][6];
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                arr[i][j] = scanner.nextInt();}
        }
        for(int i=0;i<=3;i++){
            for(int j=0;j<=3;j++){
                sum[max] = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                max++;
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[15]);

        scanner.close();
    }
}

