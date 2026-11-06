class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        int id = 0;

        // Step 1: Assign an ID to every unique email
        for (List<String> account : accounts) {

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }

                emailToName.put(email, name);
            }
        }

        // Step 2: Create DSU
        DSU dsu = new DSU(id);

        // Step 3: Union all emails in the same account
        for (List<String> account : accounts) {

            int firstEmailId =
                    emailToId.get(account.get(1));

            for (int i = 2; i < account.size(); i++) {

                int currentEmailId =
                        emailToId.get(account.get(i));

                dsu.union(firstEmailId, currentEmailId);
            }
        }

        // Step 4: Group emails according to their root
        Map<Integer, List<String>> groups = new HashMap<>();

        for (String email : emailToId.keySet()) {

            int emailId = emailToId.get(email);
            int root = dsu.find(emailId);

            groups
                .computeIfAbsent(root, k -> new ArrayList<>())
                .add(email);
        }

        // Step 5: Create final answer
        List<List<String>> result = new ArrayList<>();

        for (List<String> emails : groups.values()) {

            Collections.sort(emails);

            List<String> mergedAccount = new ArrayList<>();

            // All emails in this group have the same name
            String name = emailToName.get(emails.get(0));

            mergedAccount.add(name);
            mergedAccount.addAll(emails);

            result.add(mergedAccount);
        }

        return result;
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


        int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }


        void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            // Already in the same group
            if (rootX == rootY) {
                return;
            }

            // Union by rank
            if (rank[rootX] < rank[rootY]) {

                parent[rootX] = rootY;

            } else if (rank[rootX] > rank[rootY]) {

                parent[rootY] = rootX;

            } else {

                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}