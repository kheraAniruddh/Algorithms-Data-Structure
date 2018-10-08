class Twitter {  
    public static int timeStamp=0;
    
    private class Tweet {
        private int tweetId;
        private int timeStamp;
        
        private Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
    
    private class TweetComparator implements Comparator<Tweet> {
        @Override
        public int compare(Tweet a, Tweet b) {
            return a.timeStamp > b.timeStamp? 1 : a.timeStamp==b.timeStamp ? 0 : -1;
        }
    }
    
    private class User {
        private int userId;
        private List<Tweet> feeds;
        private Set<Integer> follows;
        private List<Tweet> posts;
       
        private User(int userId) {
            this.userId = userId;
            this.follows = new HashSet<>();
            this.posts = new ArrayList<>();
            this.feeds = new ArrayList<>();
        }
        
    }
    
    private Map<Integer, User> users; 
    
    
    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
    }
    
    public User getUserObj(int userId) {
        User user = null; 
        if(!users.containsKey(userId)) {
             user = new User(userId);
             users.put(userId, user);
             user.follows.add(userId);
        }
        else user = users.get(userId);
        
        return user;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        this.getUserObj(userId).posts.add(new Tweet(tweetId, timeStamp));
        timeStamp++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User user = this.getUserObj(userId);
        // Merge followee's tweets in follower's feed
        List<Integer> res= new ArrayList<>();
        List<Tweet> temp= new ArrayList<>();
        for(int followee: user.follows)
            temp.addAll(getUserObj(followee).posts);
        Collections.sort(temp, new TweetComparator());
    
        int i = Math.max(0, temp.size()-10);
        int j = temp.size()-1;
        while(j>=i) {
            res.add(temp.get(j).tweetId);
            j--;
        }
        
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User user = this.getUserObj(followerId);
        user.follows.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId!=followeeId) 
            this.getUserObj(followerId).follows.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
