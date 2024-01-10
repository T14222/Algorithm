import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<String>();
        
        // 중복 단어 확인
        for(int i = 0; i < words.length; i++){
            if(list.contains(words[i])) {
                answer[0] = (i % n) + 1;  // 플레이어 번호
                answer[1] = (i / n) + 1;  // 차례
                break;
            }
            
            list.add(words[i]);
            
            // 이전 단어의 마지막 문자와 다른 경우
            if(i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        }
        
        return answer;
    }
}