class Solution {
    public String predictPartyVictory(String senate) {
         int n = senate.length();

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Put indices into their respective queues
        for (int i = 0; i < n; i++) {

            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Continue until one party has no senators left
        while (!radiant.isEmpty() && !dire.isEmpty()) {

            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {

                // R gets the turn first, so R bans D
                // R survives to the next round
                radiant.offer(r + n);

            } else {

                // D gets the turn first, so D bans R
                // D survives to the next round
                dire.offer(d + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    
    }
}