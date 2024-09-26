import java.util.Random;

public class Task {
    public long id;
    public long idCliente;

    public Task(long id, long idCliente) {
        this.id = id;
        this.idCliente = idCliente;
    }

    public void execute() {
        try {
            // generating a number between 1000 and 15000
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
