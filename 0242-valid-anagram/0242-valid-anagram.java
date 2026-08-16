class Solution {
    public boolean isAnagram(String s, String t) {
        
        // if(s.length() != t.length()) return false;

        // char[] s1 = s.toCharArray();
        // char[] t1 = t.toCharArray();

        // Arrays.sort(s1);
        // Arrays.sort(t1);

        // int i = 0;

        // while(i < s1.length){
        //     if(s1[i] != t1[i]) return false;

        //     i++;
        // }

        // return true;

        int count[] = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        for(char ch : t.toCharArray()){
            count[ch - 'a']--;
            if(count[ch - 'a'] < 0) return false;
        }

        return true;
    }
}