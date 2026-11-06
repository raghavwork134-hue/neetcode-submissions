class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            int gain = gas[i] - cost[i];

            total += gain;
            tank += gain;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;


        // int totalGas = 0;
        // int totalCost = 0;

        // int tank = 0;
        // int start = 0;

        // for (int i = 0; i < gas.length; i++) {

        //     totalGas += gas[i];
        //     totalCost += cost[i];

        //     // Net gas at current station
        //     tank += gas[i] - cost[i];

        //     // Current starting point cannot work
        //     if (tank < 0) {
        //         start = i + 1;
        //         tank = 0;
        //     }
        // }

        // // Not enough total gas
        // if (totalGas < totalCost) {
        //     return -1;
        // }

        // return start;
    }
}