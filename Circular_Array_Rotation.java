/*
  
PROBLEM STATEMENT

John Watson knows of an operation called a right circular rotation on an array of integers. One
rotation operation moves the last array element to the first position and shifts all remaining
elements right one. To test Sherlock's abilities, Watson provides Sherlock with an array of
integers. Sherlock is to perform the rotation operation a number of times then determine the value
of the element at a given position.

For each array, perform a number of right circular rotations and return the value of the element at
a given index.

For example, array a = [3, 4, 5], number of rotations, k = 2 and indices to check, m = [1, 2].

First we perform the two rotations: 
[3,4,5] → [5,3,4] → [4,5,3]
Now return the values from the zero-based indices 1 and 2 as indicated in the m array.
a[1] = 5
a[2] = 3

Function Description

Complete the circularArrayRotation function in the editor below. It should return an array of
integers representing the values at the specified indices.

circularArrayRotation has the following parameter(s):
  
• a: an array of integers to rotate
• k: an integer, the rotation count
• queries: an array of integers, the indices to report

Input Format

The first line contains 3 space-separated integers, n, k, and q, the number of elements in the
integer array, the rotation count and the number of queries.
The second line contains n space-separated integers, where each integer i describes array element
 a[i] (where 0 <= i < n).
Each of the q subsequent lines contains a single integer denoting m, the index of the element to
return from a.

Constraints

  1 <= n <= 10^5
  1 <= a[i] <= 10^5
  1 <= k <= 10^5
  1 <= q <= 500
  0 <= m < n
  
Output Format

For each query, print the value of the element at index m of the rotated array on a new line.

Sample Input 0
3 2 3
1 2 3
0
1
2

Sample Output 0
2
3
1

*/
  
//SOLUTION
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Circular_Array_Rotation{
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int n = a.length;
        int[] arr = new int[queries.length];
        k%=n;
        for(int i=0;i<arr.length;i++){
            int x = (queries[i]-k+n)%n;
            arr[i] = a[x];}
        return arr;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nkq = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nkq[0]);
        int k = Integer.parseInt(nkq[1]);
        int q = Integer.parseInt(nkq[2]);
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i = 0; i < n; i++){
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        int[] queries = new int[q];
        for(int i = 0; i < q; i++){
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }
        int[] result = circularArrayRotation(a, k, queries);
        for(int i = 0; i < result.length; i++){
            bufferedWriter.write(String.valueOf(result[i]));
            if(i != result.length - 1){
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}