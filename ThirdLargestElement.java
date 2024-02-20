//{ Driver Code Starts
    import java.util.Scanner;
    import java.util.*;
    import java.io.*;
    
    class ThirdLargestElement
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t>0)
            {
                int n =sc.nextInt();
                int arr[] = new int[n];
                for(int i=0;i<n;i++)
                    arr[i] = sc.nextInt();
                Solution g = new Solution();
                System.out.println(g.thirdLargest(arr,n));
            t--;
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        int thirdLargest(int a[], int n)
        {
            if(n<3)
            return -1;
            
            int f = a[0];
            int s = Integer.MIN_VALUE;
            int t = Integer.MIN_VALUE;
            
            for(int i = 1; i<n; i++){
                if(a[i]>f){
                    t=s;
                    s=f;
                    f=a[i];
                    
                }else if(a[i]>s){
                    t=s;
                    s=a[i];
                }else if(a[i]>t){
                    t=a[i];
                }
            }
            return t;
        }
    }
    