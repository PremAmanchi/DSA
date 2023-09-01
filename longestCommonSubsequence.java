// Problem : https://leetcode.com/problems/longest-common-subsequence/
// tc : O(n*m)
// sc : O(n*m)


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int[] mem : memo)
            Arrays.fill(mem, -1);
        return dp(0,0, text1, text2, memo);
    }

    private int dp(int ind1, int ind2, String text1, String text2, int[][] memo){
        // base cases
        if(ind1 == text1.length() || ind2 == text2.length())
            return 0;
        if(memo[ind1][ind2] != -1)
            return memo[ind1][ind2];

        // logic
        if(text1.charAt(ind1) == text2.charAt(ind2))
            memo[ind1][ind2] = 1 + dp(ind1+1, ind2+1, text1, text2, memo);
        else 
            memo[ind1][ind2] = Math.max(dp(ind1+1, ind2, text1, text2, memo), 
                                        dp(ind1, ind2+1, text1, text2, memo));
        return memo[ind1][ind2]; 
    }
}   