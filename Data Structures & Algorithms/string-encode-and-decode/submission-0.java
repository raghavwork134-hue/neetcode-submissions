class Solution {

    public String encode(List<String> strs) {
         StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            // Find delimiter #
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            // Extract length
            int length = Integer.parseInt(str.substring(i, j));

            // Move to string start
            j++;

            // Extract actual string
            String word = str.substring(j, j + length);

            result.add(word);

            // Move pointer ahead
            i = j + length;
        }

        return result;
    
    }
}
