import java.util.*;
class Solution {
    int[][] MATH_GIVE_UP = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
    public int[] solution(int[] answers) {
        int[] giveupScore = {0,0,0};
        for(int i = 0 ; i<answers.length ; i++){
            for(int idx = 0 ; idx<MATH_GIVE_UP.length ; idx++){
                if(answers[i]==MATH_GIVE_UP[idx][i%(MATH_GIVE_UP[idx].length)]){
                    giveupScore[idx]++;
                }
            }
        }
        int max = 0 ;
        for(int g : giveupScore){
            max = Math.max(max, g);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i = 0 ; i<giveupScore.length ; i++){
            if(giveupScore[i]==max) answerList.add(i+1);
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0 ; i<answerList.size() ; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}