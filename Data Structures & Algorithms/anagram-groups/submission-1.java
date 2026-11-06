class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store: Sorted String (Key) -> List of Anagrams (Value)
        // Map<String, List<String>> map = new HashMap<>();
        
        // for (String s : strs) {
        //     // Convert string to character array and sort it
        //     char[] chars = s.toCharArray();
        //     Arrays.sort(chars);
            
        //     // The sorted character array becomes our unique key
        //     String key = new String(chars);
            
        //     // If the key is not present, initialize a new list
        //     if (!map.containsKey(key)) {
        //         map.put(key, new ArrayList<>());
        //     }
            
        //     // Add the original string to its anagram group
        //     map.get(key).add(s);
        // }
        
        // // Return all the grouped sublists
        // return new ArrayList<>(map.values());

        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
