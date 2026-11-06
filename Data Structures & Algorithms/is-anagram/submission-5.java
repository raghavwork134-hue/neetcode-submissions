class Solution {
    public boolean isAnagram(String s, String t) {

        // if(s.length() != t.length()){
        //     return false;
        // }

        // int count[] = new int[26];

        // for(int i = 0;i<s.length();i++){
        //     count[s.charAt(i) - 'a']++;
        //     count[t.charAt(i) - 'a']--;
        // }

        // for(int i = 0;i<count.length;i++){
        //     if(count[i] != 0){
        //         return false;
        //     }
        // }
        // return true;


        if(s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];

        for(int i = 0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i = 0;i<count.length;i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
                        // 2nd approach (sorting)
        // if (s.length() != t.length()) {
        //     return false;
        // }

        // char[] sSort = s.toCharArray();
        // char[] tSort = t.toCharArray();
        // Arrays.sort(sSort);
        // Arrays.sort(tSort);
        // return Arrays.equals(sSort, tSort);

    }
}
