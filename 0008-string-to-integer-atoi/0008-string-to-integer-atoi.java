class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0) return 0;
        int sign =1;
        int i = 0;
        char c = s.charAt(0);
        if(c=='-'){
            sign = -1;
            i++;

        }else if (c=='+'){
            i++;
        }else if(c=='+'){
            i++;
        }
        long sum = 0;
        while(i<s.length()){
            char currChar = s.charAt(i);
            if(currChar < '0' || currChar > '9')break;
            int a = currChar - '0';
            sum = sum* 10 + a;
            if(sign == 1 && sum> Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && -sum < Integer.MIN_VALUE) return Integer.      MIN_VALUE;
            i++;
        }
        return (int) (sign * sum);
    }
}