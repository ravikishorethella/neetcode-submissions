class Twitter {

    // global counter
    private static int timestamp = 0;

    // A tweet structure acting as a node in the linked list
    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    // userId -> set of followee
    private Map<Integer, Set<Integer>> followerMap;

    // userId -> head of their tweet linked list
    private Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // Ensure the user exists in our map
        if(!followerMap.containsKey(userId)) {
            followerMap.put(userId, new HashSet<>());
        }

        // creating new tweet
        Tweet newTweet = new Tweet(tweetId, timestamp++);

        // push to the front of the linkedlist
        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        // Set up our Leaderboard (Max-Heap) sorted by the tweet's timestamp
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        // Gather everyone the user follows
        Set<Integer> followedPeople = followerMap.get(userId);
        if (followedPeople == null) {
            followedPeople = new HashSet<>();
        }

        // Step 1: Put the user's own newest tweet into the heap
        Tweet userSelfTweet = tweetMap.get(userId);
        if (userSelfTweet != null) {
            maxHeap.offer(userSelfTweet);
        }

        // Step 2: Put the newest tweet of every person they follow into the heap
        for (int followeeId : followedPeople) {
            Tweet followeeTweet = tweetMap.get(followeeId);
            if (followeeTweet != null) {
                maxHeap.offer(followeeTweet);
            }
        }

        // Step 3: Pull up to 10 of the most recent tweets total
        while (!maxHeap.isEmpty() && result.size() < 10) {
            Tweet newestTweet = maxHeap.poll();
            result.add(newestTweet.id);
            
            // Advance the pointer: if this author has an older tweet, put it on the leaderboard
            if (newestTweet.next != null) {
                maxHeap.offer(newestTweet.next);
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        // Prevent a user from following themselves
        if (followerId == followeeId) return;
        
        if (!followerMap.containsKey(followerId)) {
            followerMap.put(followerId, new HashSet<>());
        }
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // Cannot unfollow yourself or someone you don't follow
        if (!followerMap.containsKey(followerId) || followerId == followeeId) return;
        
        followerMap.get(followerId).remove(followeeId);
    }
}
