class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int rank[] = new int[26];

        for(int i = 0;i<order.length();i++){
            rank[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0;i<words.length - 1;i++){

            String word1 = words[i];
            String word2 = words[i+1];

            int minLength = Math.min(word1.length(),word2.length());

            int j = 0;

            while(j<minLength){

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1 != c2){
                    
                    if(rank[c1 - 'a'] > rank[c2 - 'a']){
                        return false;
                    }
                    break;
                }
                j++;
            }

            if(j == minLength && word1.length() > word2.length()){
                return false;
            }
        }
        return true;
    }
}