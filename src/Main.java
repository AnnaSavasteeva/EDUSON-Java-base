import threads.ThreadsViaThread;

public class Main {

    public static void main(String[] args) {

        Thread myThreadViaThread = new ThreadsViaThread();
        myThreadViaThread.start();
    }
}