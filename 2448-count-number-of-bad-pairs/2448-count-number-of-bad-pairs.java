class Solution {
    public long countBadPairs(int[] arr) {
        long ans = 0;
        HashMap<Integer,Long> hp = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            int diff = arr[i]-i;
            hp.put(diff,hp.getOrDefault(diff,0L)+1);
        }
        
        for(var a : hp.values()){
            if(a>=2){
                ans = ans+(long)((a*(a-1))/2);
            }
        }
        long x = (long)n;
        return (x*(x-1))/2-ans;
    }
}