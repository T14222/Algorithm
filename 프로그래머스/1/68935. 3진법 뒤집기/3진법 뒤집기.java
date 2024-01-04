class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String ternary = Integer.toString(n, 3);
        String reverse = new StringBuilder(ternary).reverse().toString();
        
        answer = Integer.parseInt(reverse, 3);
        
        return answer;
    }
}