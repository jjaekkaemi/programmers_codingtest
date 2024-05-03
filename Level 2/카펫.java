class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown+yellow;
        for(int b = 1 ; b<=total/2 ; b++){ // b = 세로, a = 가로
            if(total%b != 0) continue;
            int a = total/b;
            if(a<3 || b<3) continue;
            if((a-2)*(b-2)!=yellow) continue;
            answer = new int[]{a,b};
            break;
        }
        return answer;
    }
}