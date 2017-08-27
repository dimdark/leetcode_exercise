package leetCode_355;

import java.util.*;

/**
 * @author dimdark
 * @date 2017-08-27
 * @time 6:04 PM
 */
public class Twitter {

    // inner class
    class Tweet implements Comparable<Tweet> {
        Integer tweetId;
        Long createTime;
        public Tweet(Integer tweetId, Long createTime) {
           this.tweetId = tweetId;
           this.createTime = createTime;
        }
        public int compareTo(Tweet o) {
            if(o == null) throw new NullPointerException("o is null");
            if(this.createTime > o.createTime) return -1;
            else if(this.createTime < o.createTime) return 1;
            else return 0;
        }
    }

    private Map<Integer, LinkedList<Tweet>> userToTweets;
    private Map<Integer, LinkedList<Integer>> userToFollowees;
    private static final int NEWS_CNT = 10;
    private static long ALL_TWEET_CNT = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        userToTweets = new HashMap<Integer, LinkedList<Tweet>>();
        userToFollowees = new HashMap<Integer, LinkedList<Integer>>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, ++ALL_TWEET_CNT);
        if(userToTweets.containsKey(userId)) {
            userToTweets.get(userId).addLast(tweet);
        }else { // first post tweet
            follow(userId, userId); // follow myself
            LinkedList<Tweet> tweets = new LinkedList<Tweet>();
            tweets.add(tweet);
            userToTweets.put(userId, tweets);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> recentTweets = new LinkedList<Integer>();
        LinkedList<Integer> followees = userToFollowees.get(userId);
        if(followees == null) return recentTweets;
        Integer[] followeeIds = followees.toArray(new Integer[0]);
        List<Tweet> tweets = new ArrayList<Tweet>();
        for(int followeeId : followeeIds) {
            if(userToTweets.containsKey(followeeId)) {
                tweets.addAll(userToTweets.get(followeeId));
            }
        }
        Collections.sort(tweets);
        for(int i = 0; i < NEWS_CNT; ++i) {
            if(i >= tweets.size()) break;
            recentTweets.add(tweets.get(i).tweetId);
        }
        return recentTweets;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        LinkedList<Integer> followees = userToFollowees.get(followerId);
        if(followees != null) {
            if(!followees.contains(followeeId)){
                followees.add(followeeId);
            }
        }else {
            followees = new LinkedList<Integer>();
            followees.add(followeeId);
            userToFollowees.put(followerId, followees);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        LinkedList<Integer> followees = userToFollowees.get(followerId);
        if(followees == null || !followees.contains(followeeId)) return;
        followees.remove(Integer.valueOf(followeeId));
    }

}


