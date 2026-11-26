class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0;
        int result = 0;
        int[] f = new int[256];
        for(int high = 0;high<n;high++){
            f[s.charAt(high)]++;
            int length = high-low+1;
            int maxCount = find(f);
            int diff = length-maxCount;
            while(diff > k){
                f[s.charAt(low)]--;
                low++;

                maxCount = find(f);
                length = high-low+1;
                diff = length-maxCount;
            }
            result = Math.max(result,high-low+1);
        }
        return result;

    }
    private int find(int[] f){
        int max=0;
        for(int i = 0;i<256;i++){
            max = Math.max(max,f[i]);
        }
        return max;
    }
}