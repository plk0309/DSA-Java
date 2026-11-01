import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>map=new HashMap<>();
        for(int i =0;i<strs.length;i++){
            String str=strs[i];
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());

            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}