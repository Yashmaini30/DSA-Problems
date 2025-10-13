class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if (s.length() != goal.length()) return false;

        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) return true;
            }
            return false;
        }
        
        List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffs.add(i);
            }
        }

        if (diffs.size() != 2) return false;

        int i = diffs.get(0), j = diffs.get(1);
        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
    }
}
