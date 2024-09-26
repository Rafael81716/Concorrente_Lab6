import java.util.concurrent.*;

public class DisplayTasks implements Runnable{

    private ConcurrentHashMap<Long, LinkedBlockingDeque<Task>> map;
    public DisplayTasks(ConcurrentHashMap<Long, LinkedBlockingDeque<Task>> map){
        this.map = map;
    }
    public void run(){
        for (long id : map.keySet()) {
            System.out.print("Cliente " + id + " ");
            LinkedBlockingDeque<Task> lista = map.get(id);
            for (int i=0; i < map.get(id).size(); i++){
                try{
                    System.out.println("concluiu tarefa " + lista.take().id + "\n");
                }catch(Exception e){

                }
            }
        }
    }
}
