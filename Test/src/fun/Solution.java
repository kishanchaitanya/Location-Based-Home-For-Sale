package fun;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        java.io.BufferedReader sc = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        
        String firstRow = sc.readLine().trim();
        String secRow = sc.readLine().trim();
        
        java.util.StringTokenizer fst = new java.util.StringTokenizer(firstRow);
        java.util.StringTokenizer sst = new java.util.StringTokenizer(secRow);
        
        int tcnt=(fst.hasMoreTokens())? Integer.parseInt(fst.nextToken()) : 0;
        int diff=(fst.hasMoreTokens())?Integer.parseInt(fst.nextToken()) : 0;
        int a[]= new int[tcnt];
        int arrLen = 0;
        while (sst.hasMoreTokens() && tcnt <= arrLen ){ 
            a[arrLen]=Integer.parseInt(sst.nextToken());
            arrLen++;
        }

        int counter=0;

        for (int i=0; i<tcnt-1;i++){
            for(int j=i+1; j<tcnt-1;j++)
                    if(a[i]-a[j]==diff){
                    counter ++;
                }
            }
        System.out.println(counter);
        
    }
}
