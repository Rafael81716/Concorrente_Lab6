import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Node implements Runnable {
    private BlockingQueue<Task> tasks;
    public Node(BlockingQueue<Task> tasks){
      this.tasks = tasks;
    }

    @Override
    public void run() {
      while(true){

      } 
    }
}
