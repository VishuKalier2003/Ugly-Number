/* An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5... Given an integer n, return the nth ugly number...
 * Eg 1: n = 10     number = 12
 * Eg 2: n = 1      number = 1
  */
import java.util.*;
public class Ugly
{
    public int NthUglyNumber(int n)
    {
        TreeSet<Long> st = new TreeSet<>();   // TreeSet maintains the unique values only, A Queue may have repeated values, but a TreeSet contains only unique values...
        st.add((long)1);
        int cnt = 0;
        long ans = 1;
        for(;cnt != n;){      // Incrementing the counter...
            long ugly = st.pollFirst();    // Calling the first added value, unique to TreeSet...
            ans = ugly;
            ++cnt;
            st.add(2 * ugly);    // Adding the 2 multiple...
            st.add(3 * ugly);    // Adding the 3 multiple...
            st.add(5 * ugly);    // Adding the 5 multiple...
        }
        return (int)ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the value of n : ");
        x = sc.nextInt();
        Ugly ugly = new Ugly();     // Object creation...
        System.out.println("The Nth Ugly number is : "+ugly.NthUglyNumber(x));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. We just keep the elements in the TreeSet which are a multiple of 2, 3 or 5...
 * 2. Since we want unique values and not any repeated number so we create a TreeSet...
 */