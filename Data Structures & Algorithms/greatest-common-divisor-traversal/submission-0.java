class Solution {

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        // Only one index, so it is already connected to itself
        if (n == 1) {
            return true;
        }

        // If any value is 1, gcd(1, anything) is always 1.
        // So this index cannot connect to any other index.
        for (int num : nums) {
            if (num == 1) {
                return false;
            }
        }

        DSU dsu = new DSU(n);

        // prime factor -> index that first contained this factor
        Map<Integer, Integer> factorOwner = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int num = nums[i];

            // Find unique prime factors of nums[i]
            for (int factor = 2; factor * factor <= num; factor++) {

                if (num % factor == 0) {

                    // If this factor was seen before,
                    // connect current index with its owner
                    if (factorOwner.containsKey(factor)) {
                        dsu.union(i, factorOwner.get(factor));
                    } else {
                        factorOwner.put(factor, i);
                    }

                    // Remove all occurrences of this factor
                    while (num % factor == 0) {
                        num /= factor;
                    }
                }
            }

            // If num > 1, the remaining num itself is prime
            if (num > 1) {

                if (factorOwner.containsKey(num)) {
                    dsu.union(i, factorOwner.get(num));
                } else {
                    factorOwner.put(num, i);
                }
            }
        }

        // Check whether every index belongs to the same component
        int root = dsu.find(0);

        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) {
                return false;
            }
        }

        return true;
    }


    static class DSU {

        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }

            // Union by rank
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }
}