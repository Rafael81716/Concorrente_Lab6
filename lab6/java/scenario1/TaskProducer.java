import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskProducer implements Runnable {
    private LinkedBlockingDeque<Task> tasks;
    private AtomicInteger taskId;
    private int idClient;
    public TaskProducer(LinkedBlockingDeque<Task> tasks, AtomicInteger taskId, int idClient){
        this.tasks = tasks;
        this.taskId = taskId;
        this.idClient = idClient;
    }
    @Override
    public void run(){
        while (true) {
            int i = taskId.incrementAndGet();
            Task task = new Task(i, idClient);
            try{
                tasks.put(task);
                Thread.sleep(5000);
            }catch(Exception e){
                System.err.println(e);
            } 
        }
    }
}