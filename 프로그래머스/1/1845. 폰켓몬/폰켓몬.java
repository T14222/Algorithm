import java.util.*;

class Solution {
    int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;

        HashSet<Integer> unique = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }

        if (unique.size() > max) {
          answer = max;
        } else {
          answer = unique.size();
        }
        
        return answer;
      }
    }