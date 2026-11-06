class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        // Total cards must be divisible by groupSize
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Count frequency of each card
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        // Sort cards
        Arrays.sort(hand);

        // Process cards from smallest to largest
        for (int card : hand) {

            // This card is already used
            if (count.get(card) == 0) {
                continue;
            }

            // Start a new group
            for (int value = card; value < card + groupSize; value++) {

                // Required card is not available
                if (count.getOrDefault(value, 0) == 0) {
                    return false;
                }

                // Use this card
                count.put(value, count.get(value) - 1);
            }
        }

        return true;
    }
}