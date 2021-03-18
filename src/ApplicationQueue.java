
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ApplicationQueue {

    public static final int MAX = 100;

    private static BlockingQueue<Application> apps = new ArrayBlockingQueue<>(MAX);

    public void addApplication(Application app) {
        try {
            apps.put(app);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Application removeApplication() {
        try {
            Application app = apps.take();
            return app;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
