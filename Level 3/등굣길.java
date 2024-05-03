import java.util.*;
class Solution {
    int[][] MOVES = {{1,0},{0,1}};
    int MOD = 1000000007 ;
    public int solution(int m, int n, int[][] puddles) {
        int[][] loads = new int[m+1][n+1];
        for(int i = 0 ; i<puddles.length ; i++){
            loads[puddles[i][0]][puddles[i][1]] = -1;
        }
        loads[1][1] = 1;
        for(int i = 1 ; i<m+1 ; i++){
            for(int j = 1 ; j<n+1 ; j++){
                if(loads[i][j]==-1) continue;
                if(loads[i][j-1]!=-1) loads[i][j] += loads[i][j-1]%MOD;
                if(loads[i-1][j]!=-1) loads[i][j] += loads[i-1][j]%MOD;
            }
        }
        return loads[m][n]%MOD;
    }
}