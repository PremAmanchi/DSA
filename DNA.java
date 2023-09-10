// time complexity :O(n)
// space complextiy : O(n)
// problem link : https://leetcode.com/problems/repeated-dna-sequences/description/
import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int n = s.length();
        // base case 
        if(n < 10) 
            return result;
        // else
        for(int i = 0; i<n-9; i++)
            map.put(s.substring(i,i+10),map.getOrDefault(s.substring(i,i+10), 0)+1);
        for(String word : map.keySet())
            if(map.get(word)>1)
                result.add(word);
        return result;
    }
}