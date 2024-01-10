import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> result = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap();
        
        // today를 year, month, day로 나누기
        String[] today_date = today.split("\\.");
        int today_year = Integer.parseInt(today_date[0]);
        int today_month = Integer.parseInt(today_date[1]);
        int today_day = Integer.parseInt(today_date[2]);
        
        // key : 약관 종류, value : 유효기간
        for(int i = 0; i < terms.length; i++){
            String a = terms[i].split(" ")[0];
            int expire_date = Integer.parseInt(terms[i].split(" ")[1]);
            map.put(a, expire_date);
        }
        
        // 만료되는 날짜 찾기
        for(int i = 0; i < privacies.length; i++){
            String[] target_date = privacies[i].split(" ")[0].split("\\.");
            String target_a = privacies[i].split(" ")[1];
            
            int target_year = Integer.parseInt(target_date[0]);
            int target_month = Integer.parseInt(target_date[1]);
            int target_day = Integer.parseInt(target_date[2]);
            
            target_month += map.get(target_a);
            target_day -= 1;
            
            // 만약 day를 줄였는데 0이 된다면 28로 바꾼뒤 month를 -1
            if (target_day == 0){
                target_day = 28;
                target_month -= 1;
            }
            
            if (target_month == 0){
                target_month = 12;
                target_year -= 1;
            }
            
            // 만약 month가 12를 넘었으면 12의 나머지를 month로
            if (target_month > 12){
            target_year += target_month / 12;
            target_month %= 12;
            
            if (target_month == 0){
                target_month = 12;
                target_year -= 1;
            }
            }
            
            // 파기해야 하는 개인정보 확인
            if (target_year < today_year){
                result.add(i + 1);
            } else if( target_year == today_year && target_month < today_month ){
                result.add(i + 1);
            } else if( target_year == today_year && target_month == today_month && target_day < today_day){
                result.add(i + 1);
            }
        }
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
            return answer;
    }
}