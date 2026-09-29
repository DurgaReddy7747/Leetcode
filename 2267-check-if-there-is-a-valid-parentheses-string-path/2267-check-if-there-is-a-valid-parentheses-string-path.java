class Solution {
    static Boolean[][][] dp;
    private static boolean fun(char[][] grid , int i , int j , int balance , int m , int n){
        if(i >= m || j >= n || i < 0 || j < 0) return false;
        char c = grid[i][j];
        if(c == '(') balance++;
        else balance--;
        if(i == m - 1 && j == n - 1){
            return balance == 0;
        }
        if(balance < 0) return false;
        int rem = (m - 1 - i) + (n - 1 - j);
        if(balance > rem) return false;
        if(dp[i][j][balance] != null) return dp[i][j][balance];
        boolean flag = fun(grid , i + 1 , j , balance , m , n) ||
                       fun(grid , i , j + 1 , balance , m , n);
        return dp[i][j][balance] = flag;
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int balance = 0;
        dp = new Boolean[m][n][m + n];
        return fun(grid , 0 , 0 , balance , m , n);
    }
}