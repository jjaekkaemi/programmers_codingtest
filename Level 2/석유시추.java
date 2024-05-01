import java.util.*;
class Solution {
    int[][] MOVES = {{-1,0},{1,0},{0,1},{0,-1}};
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length ;
        int[] cnt = new int[m];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(land[i][j]==0) continue;
                Set<Integer> set = new HashSet<>();
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                int depth = 0;
                land[i][j]=0;
                while(!queue.isEmpty()){
                    int[] point = queue.poll();
                    int di = point[0];
                    int dj = point[1];
                    set.add(dj);

                    depth++;
                    for(int move[] : MOVES){
                        int mi = di+move[0];
                        int mj = dj+move[1];
                        if(mi>=0 && mi<n && mj>=0 && mj<m){
                            if(land[mi][mj]==1){
                                queue.add(new int[]{mi, mj});
                                land[mi][mj]=0;
                            }
                        }
                    }
                }
                for(int s : set){
                    cnt[s]+=depth;
                }
            }

        }
        for(int c : cnt){
            if(answer<c) answer = c;
        }
        return answer;
    }

}