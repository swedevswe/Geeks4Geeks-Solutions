//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*; 
class MinimumDistance{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    int minDist(int a[], int n, int x, int y) {
        int lastX = -1; int lastY = -1;
        
        int min_dist = n;
        
        for(int i = 0; i<n; i++){
            if(a[i]==x){
                if(lastY != -1){
                    min_dist=Math.min(min_dist, i - lastY);
                    
                }
                lastX = i;
            }else if(a[i]==y){
                if(lastX != -1){
                    min_dist=Math.min(min_dist, i - lastX);
                }
                lastY = i;
            }
        }
        if(min_dist>=n){
            return -1;
        }
        return min_dist;
    }
}