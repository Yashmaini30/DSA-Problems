class Solution {
    public String generateTag(String caption) {
        String[] words = caption.split(" ");
        StringBuilder sb = new StringBuilder("#");
        boolean firstWord = true;
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            if (firstWord) {
                sb.append(word.toLowerCase());
                firstWord = false;
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
            }
        }

        StringBuilder res = new StringBuilder("#");
        for (int i = 1; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLetter(c)) {
                res.append(c);
            }
        }
        
        return res.length() > 100 ? res.substring(0, 100) : res.toString();
    }
