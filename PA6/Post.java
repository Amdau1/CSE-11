/*
 * Name: Amdadul Haque
 * Email: ahaque.ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, book.
 * This file creates a mini redit where you are able create posts and make comments.
 * It comes with class and few methods that users can youse to upvote or downvote posts and create posts.
 */
import java.util.ArrayList;
/**
 * This class has instance variable, gettter and setters method that can be used to create posts, up and down vote posts etc.
 * Instance variables: title, content, replyTo, author, upvoteCount, downvoteCount
 */
public class Post {
       private static final String TO_STRING_POST_FORMAT = "[%d|%d]\t%s\n\t%s";
       private static final String TO_STRING_COMMENT_FORMAT = "[%d|%d]\t%s";
/** Instance variables */
       private String title;
       private String content;
       private Post replyTo;
       private User author;
       private int upvoteCount;
       private int downvoteCount;
/**
 * * This constructor creates a post.
 */
       public Post(String title, String content, User author){
           this.title = title;
           this.content = content;
           this.author = author;
           upvoteCount = 1;
           downvoteCount = 0;
        }
// This constructior is a comment to the original post.
       public Post(String content, Post replyTo, User author){
           this.content = content;
           this.replyTo = replyTo;
           this.author = author;
           upvoteCount = 1;
           downvoteCount = 0;
        }
// Getter methods
//@return the title
       public String getTitle(){
           return this.title;
        }
// @return the comment
       public Post getReplyTo(){
           return this.replyTo;
        }
// @return the author of the post.
       public User getAuthor(){
           return author;
        }
// @return the upvote count of the post.
       public int getUpvoteCount(){
           return this.upvoteCount;
        }
// @return the downvote count of the post.
       public int getDownvoteCount(){
           return this.downvoteCount;
        }
// setter methods.
// This method updates the upvote count of a post.
       public void updateUpvoteCount(boolean isIncrement){
           if(isIncrement == true){
               upvoteCount += 1;
            }
           else{
               upvoteCount -= 1;
            }
        }
// This method updates the upvvote count of a post.
       public void updateDownvoteCount(boolean isIncrement){
           if (isIncrement == true){
               downvoteCount += 1;
            }
           else{
               downvoteCount -= 1;
            }
        }
// This method is returnign the replies and the main post.
       public ArrayList<Post> getThread(){
           ArrayList<Post> posts = new ArrayList<Post>();
                if( replyTo == null){
                    posts.add(this);
                    return posts;
                }
                else {
                    posts = replyTo.getThread();
                    posts.add(this);
                    return posts;
                }
        }
// this method us formatting the output.
       public String toString(){
            if( replyTo == null){
                return String.format(TO_STRING_POST_FORMAT, upvoteCount,      downvoteCount, title, content);
            }
            else{
                return String.format(TO_STRING_COMMENT_FORMAT, upvoteCount,     downvoteCount, content);
            }

        }
}
