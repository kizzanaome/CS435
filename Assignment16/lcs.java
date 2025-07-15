import java.util.Arrays;

public class lcs {
    static int  recursiveCallCount = 0;
    static int  memoizedCallCount =0;


//brute force approach
    public static int lcsBruteForce(String string1, String string2, int i, int j){
        recursiveCallCount++;
        if (i ==0 || j == 0){
            return 0;

        }

        if (string1.charAt(i-1) == string2.charAt(j-1)){
            return lcsBruteForce(string1, string2, i-1, j-1) +1;

        }else{
        return Math.max(lcsBruteForce(string1, string2, i, j-1), 
        lcsBruteForce(string1,string2, i-1, j));
        }

    }

    //memoized version
    public static int lcsMemoized(String s1, String s2, int m, int n, int[][] memo){
        memoizedCallCount++;
        if(m ==0 || n==0){
            return 0;
        }

        if(memo[m][n] != -1){
            return memo[m][n];
        }


        if(s1.charAt(m-1) == s2.charAt(n-1)){
            memo[m][n] = lcsMemoized(s1, s2, m-1, n-1, memo) +1;
        }
        else{
             memo[m][n] = Math.max(lcsMemoized(s1, s2, m, n-1, memo ), 
             lcsMemoized(s1,s2, m-1, n, memo)
             );
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        String S1 = "ABCBDAB";
        String S2 = "BDCAB";

        int m = S1.length();
        int n = S2.length();

        // --- BruteForce approach  Recursive ---
        long startRecursive = System.nanoTime();
        int lcs1 = lcsBruteForce(S1, S2, m, n);
        long endRecursive = System.nanoTime();

        // --- Memoized ---
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        long startMemo = System.nanoTime();
        int lcs2 = lcsMemoized(S1, S2, m, n, memo);
        long endMemo = System.nanoTime();

        // --- Output ---
        System.out.println("==== Brute Force Approach ====");
        System.out.println("LCS length: " + lcs1);
        System.out.println("Recursive calls: " + recursiveCallCount);
        System.out.println("Execution time (ns): " + (endRecursive - startRecursive));

        System.out.println("\n==== Memoized ====");
        System.out.println("LCS length: " + lcs2);
        System.out.println("Recursive calls: " + memoizedCallCount);
        System.out.println("Execution time (ns): " + (endMemo - startMemo));
    }

    
}