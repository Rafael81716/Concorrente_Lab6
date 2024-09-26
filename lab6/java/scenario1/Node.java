import java.util.concurrent.*;

public class Node implements Runnable {
    private LinkedBlockingDeque<Task> tasks;
    private ConcurrentHashMap<Long, LinkedBlockingDeque<Task>> map;
    public Node(LinkedBlockingDeque<Task> tasks, ConcurrentHashMap<Long, LinkedBlockingDeque<Task>> map){
      this.tasks = tasks;
      this.map = map;
    }

    public void run() {
      while(true){
        try{
          Task task = tasks.take();
          task.execute();
          if(map.get(task.idCliente) == null){
            LinkedBlockingDeque<Task> lista = new LinkedBlockingDeque<>();
            lista.put(task);
            map.put(task.idCliente, lista);
          }else{
            LinkedBlockingDeque<Task> lista = map.get(task.idCliente);
            lista.put(task);
            map.put(task.idCliente, lista);
          }
        }
        catch(Exception e){
            System.out.println(e);
        }
      } 
    }
}
