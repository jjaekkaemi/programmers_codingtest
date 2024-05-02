import java.util.*;
class Solution {
    public void generateNum(String suffix, String prefix, Set<Integer> set){
        if(prefix.length()!=0) set.add(Integer.parseInt(prefix));
        for(int i = 0 ; i<suffix.length() ; i++){
            String newPrefix = prefix+suffix.charAt(i);
            String newSuffix = suffix.substring(0,i)+suffix.substring(i+1);
            generateNum(newSuffix, newPrefix, set);

        }
    }
    public boolean isPrime(int num){
        if(num<2) return false;
        for(int n=2 ; n<=(int) Math.pow(num, 0.5) ; n++){ // n<= 범위 조심 !
            if(num%n==0) return false;
        }
        return true;
    }
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        generateNum(numbers, "", set);
        for(int s : set){
            if(isPrime(s)) answer++;
        }
        return answer;
    }

}