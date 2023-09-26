// tc : O(n)
// sc : O(1)

// problem link : https://leetcode.com/problems/remove-duplicate-letters/
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastInd = new int[26];
        for (int i = 0; i < s.length(); i++)
            lastInd[s.charAt(i) - 'a'] = i;

        // declare
        Stack<Integer> st = new Stack();
        boolean[] seen = new boolean[26];

        // logic
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (seen[curr])
                continue;
            while (!st.isEmpty() && st.peek() > curr && lastInd[st.peek()] > i)
                seen[st.pop()] = false;
            seen[curr] = true;
            st.push(curr);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();

    }
}