import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int bottom = triangle.length;
        int[][] dp = new int[bottom][];
        dp[0] = new int[]{triangle[0][0]};
        for(int i = 1 ; i<bottom ; i++){
            dp[i] = new int[triangle[i].length];
            for(int j = 0 ; j<triangle[i].length ; j++){
                int left = j==0? 0 : dp[i-1][j-1];
                int right = j==triangle[i].length-1 ? 0 : dp[i-1][j];
                dp[i][j] = Math.max(left, right)+triangle[i][j];
            }
        }
        for(int j = 0 ; j<triangle[bottom-1].length ; j++){
            answer = Math.max(dp[bottom-1][j], answer);
        }
        return answer;
    }
}