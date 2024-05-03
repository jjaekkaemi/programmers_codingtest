class Solution {
    private int answer = 0 ;
    private boolean[] visited ;
    public void dfs(int[][] dungeons, int k, int depth){
        answer = Math.max(answer, depth);
        if(depth==visited.length) return;

        for(int i = 0 ; i<visited.length ; i++){
            if(visited[i]==false && k>=dungeons[i][0]){
                visited[i]=true;
                dfs(dungeons, k-dungeons[i][1], depth+1);
                visited[i]=false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);

        return answer;
    }
}