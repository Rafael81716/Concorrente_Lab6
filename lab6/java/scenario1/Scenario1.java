import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Scenario1 {
    public ExecutorService clientService;
    public ExecutorService nodeService;
    public LinkedBlockingDeque<Task> tasks;
    public AtomicInteger taskId;
    public ConcurrentHashMap<Long, LinkedBlockingDeque<Task>> map;
    public ScheduledExecutorService displayService;

    public Scenario1(){
        clientService = Executors.newFixedThreadPool(5);
        nodeService = Executors.newFixedThreadPool(3);
        tasks = new LinkedBlockingDeque<>();
        taskId = new AtomicInteger(0);
        map = new ConcurrentHashMap<>();
        displayService = Executors.newSingleThreadScheduledExecutor();
    }   
    public void run(){


        for(int i = 0 ; i < 3; i++){
            nodeService.execute(new Node(tasks, map));
        }
        for(int i = 0 ; i < 5; i++){
            clientService.execute(new TaskProducer(tasks, taskId, i));
        }

        displayService.scheduleAtFixedRate(new DisplayTasks(map), 0, 5, java.util.concurrent.TimeUnit.SECONDS);
    }
    public static void main(String[] args) {
        Scenario1 scenario1 = new Scenario1();
        scenario1.run();
    }

}
