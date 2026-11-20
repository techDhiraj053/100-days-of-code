import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int high = 0;high<s.length();high++){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int k =high-low+1;
            while(map.size()<k){
                char lowChar = s.charAt(low);
                map.put(lowChar,map.get(lowChar)-1);
                if(map.get(lowChar)==0){
                    map.remove(lowChar);
                }
                
                low++;
                k=high-low+1;
            }
            result = Math.max(result, high-low+1);

        }
        return result;
    }
}