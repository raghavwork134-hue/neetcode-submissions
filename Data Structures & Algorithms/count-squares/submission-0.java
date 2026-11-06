class CountSquares {

    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> yMap = points.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int count = 0;

        // Try every possible diagonal point
        for (int px : points.keySet()) {

            int dx = px - x;

            // Diagonal point cannot have same x
            if (dx == 0) {
                continue;
            }

            Map<Integer, Integer> yMap = points.get(px);

            for (int py : yMap.keySet()) {

                int dy = py - y;

                // Diagonal must have equal horizontal
                // and vertical distance
                if (Math.abs(dx) != Math.abs(dy)) {
                    continue;
                }

                // Other two corners
                int count1 = points
                        .getOrDefault(px, new HashMap<>())
                        .getOrDefault(y, 0);

                int count2 = points
                        .getOrDefault(x, new HashMap<>())
                        .getOrDefault(py, 0);

                count += yMap.get(py) * count1 * count2;
            }
        }

        return count;
    }
}