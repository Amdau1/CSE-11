/*
 * Name: Amdadul Haque
 * Email: ahaque.ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, book.
 * This file is to test the other two files which  are Post.java and User.java.
 * It comes with only one class which is Tester.
 */
// This class is used to test several line of the other two files. This is to make sure the peogram is giving the output we want.
public class Tester {
        public static void main(String[] args) {
            User u1 = new User("Amdadul");
            User u2 = new User ("Haque");
            Post p1 = new Post("Title", "Content", u1);
            Post c2 = new Post ("Almost done", p1, u2);
            Post c1 = new Post("Comment", p1, u1);
            Post c3 = new Post ("Coding is fun", p1, u2);
            System.out.println(u1);
            System.out.println(p1);
            System.out.println(c1);
            u1.addPost(p1);
            u1.addPost(c1);
            p1.getThread();
            u1.updateKarma();
            u2.downvote(c2);
            u1.upvote(c3);
            u2.getPosts();
            System.out.println(u1.getTopPost());
            System.out.println(u1.getTopComment());
        }
}
