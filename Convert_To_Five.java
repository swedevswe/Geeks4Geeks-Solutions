//https://www.geeksforgeeks.org/batch/Amazon-Test-Series/track/amazon-arrays/problem/replace-all-0s-with-5
//Your Task:
//Your task is to complete the function convertFive() which takes an integer N as an argument and replaces all zeros in the number N with 5. Your function should return the converted number.

//Expected Time Complexity: O(K) where K is the number of digits in N
//Expected Auxiliary Space: O(1)

//Constraints:
//1 <= n <= 10000
//{ Driver Code Starts
import java.util.Scanner;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int convertfive(int num) {
        if (num == 0)
        return 5;
        else return recReplace(num);
    }
    
    int recReplace(int num){
        if (num==0)
        return 0;
        int digit = num % 10;
        if (digit == 0)
        digit = 5;
        return recReplace(num/10) * 10 + digit;
            
        }
    }


