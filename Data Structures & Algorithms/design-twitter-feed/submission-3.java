class Twitter {

    class Tweet {

        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    private static int timeStamp = 0;

    // user -> people they follow
    private Map<Integer, Set<Integer>> followMap;

    // user -> latest tweet
    private Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        Tweet tweet = new Tweet(tweetId, timeStamp++);

        tweet.next = tweetMap.get(userId);

        tweetMap.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> feed = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweetMap.containsKey(userId))
            maxHeap.offer(tweetMap.get(userId));

        followMap.putIfAbsent(userId, new HashSet<>());

        for (int followee : followMap.get(userId)) {

            if (tweetMap.containsKey(followee))
                maxHeap.offer(tweetMap.get(followee));
        }

        while (!maxHeap.isEmpty() && feed.size() < 10) {

            Tweet current = maxHeap.poll();

            feed.add(current.id);

            if (current.next != null)
                maxHeap.offer(current.next);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

    if (followerId == followeeId)
        return;

    followMap.putIfAbsent(followerId, new HashSet<>());
    followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

    if (followerId == followeeId)
        return;

    if (followMap.containsKey(followerId))
        followMap.get(followerId).remove(followeeId);
    }

    
}

