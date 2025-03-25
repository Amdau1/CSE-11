/*
 * Name: Amdadul Haque
 * Email: ahaque.ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, book.
 * This file makes a user for Post.java class, which creates a reddit. This file can also be used to update a specific users karma. The user is able to upvote and down vote a post or comment.
 * It comes with class and few methods that users can youse to create a username, upvote posts from that user name and etc.
 */
import java.util.ArrayList;
/**
 * This class has instance variable, gettter and setters method that can be used to cal users karma and update the amount of upvote or downvote that post has.
 */
public class User {
    private static final String TO_STRING_USER_FORMAT = "u/%s Karma: %d";
// Instance variable.
    private int karma;
    private String username;
    private ArrayList<Post> posts;
    private ArrayList<Post> upvoted;
    private ArrayList<Post> downvoted;
// This method creates a user and initializes the instance variable for this user.
    public User(String username){
        this.username = username;
        karma = 0;
        posts = new ArrayList<Post>();
        upvoted = new ArrayList<Post>();;
        downvoted = new ArrayList<Post>();
    }
// This method adds a post to the users that created the post.
    public void addPost(Post post){
        if (post.equals(null)){
        }
        else {
            this.posts.add(post);
            post.getAuthor().updateKarma();
        }
    }
    // This method useses updateUpvoteCount and updateDownvoteCount from the otehr class to update the authos karma.
    public void updateKarma(){
         int counter = 0;
            for(int i = 0; i < posts.size(); i++){
                Post gettingPost = posts.get(i);
                counter += gettingPost.getUpvoteCount() - gettingPost.getDownvoteCount();
            }
         karma = counter;
    }
// Getter method.
    public int getKarma(){
        return karma;
    }
// This method upvotes a post and updates users karma accordingly.
    public void upvote(Post post){
        if(post ==null){
            return;
        }
        else if (upvoted.contains(post)){
            return;
        }
        else {
            post.updateUpvoteCount(true);
            if (downvoted.contains(post)){
                downvoted.remove(post);
                post.updateDownvoteCount(false);
            }
            upvoted.add(post);
            post.getAuthor().updateKarma();
        }
    }
    // This method downvotes a post and updates users karma accordingly.
    public void downvote(Post post){
        if(post == null){
            return;
        }
        else if (downvoted.contains(post)){
            return;
        }
        else {
            post.updateDownvoteCount(true);
            if (upvoted.contains(post)){
                upvoted.remove(post);
                post.updateUpvoteCount(false);
        }
        downvoted.add(post);
        post.getAuthor().updateKarma();
        }
    }
    //This method returns the top post by looking thorough all the other posts.
    public Post getTopPost(){
        int karmaAmount1 = 0;
        int highestKarma1 = Integer.MIN_VALUE;
        int indexofPost1 = 0;
        boolean isPost = false;
        for( int i = 0; i < posts.size(); i++){
            if(posts.get(i).getTitle() != null){
                isPost = true;
                Post karmaof = posts.get(i);
                if( karmaof == null){

                }
                else {
                    karmaAmount1 = karmaof.getUpvoteCount() - karmaof.getDownvoteCount();
                    if(karmaAmount1 > highestKarma1){
                        highestKarma1 = karmaAmount1;
                        indexofPost1 = i;
                    }
                }
            }
        }
        if( isPost == true){
        return posts.get(indexofPost1);
        }
        else{
            return null;
        }
    }
    //This method returns the top comment by looking thorough all the other comment.
    public Post getTopComment(){
        int karmaAmount2 = 0;
        int highestKarma2 = Integer.MIN_VALUE;
        int indexofPost = 0;
        boolean iscomment = false;
        for( int i = 0; i < posts.size(); i++){
            if(posts.get(i).getTitle() == null){
                iscomment = true;
            Post karmaPost = posts.get(i);
                karmaAmount2 = karmaPost.getUpvoteCount() - karmaPost.getDownvoteCount();
            if(karmaAmount2 > highestKarma2){
                highestKarma2 = karmaAmount2;
                indexofPost = i;
            }
        }
    }
    if( iscomment == true){
        return posts.get(indexofPost);
        }
        else{
            return null;
        }
    }
    public ArrayList<Post> getPosts(){
        return this.posts;
    }
    public String toString(){
        return String.format(TO_STRING_USER_FORMAT, username, karma);
    }
}
