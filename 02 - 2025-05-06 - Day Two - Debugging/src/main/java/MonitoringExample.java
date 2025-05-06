import java.util.ArrayList;
import java.util.List;

public class MonitoringExample {
    public static void main(String[] args) throws InterruptedException {
        Thread cpuThread = new Thread(() -> {
            while (true) {
                double result = Math.random() * Math.random();
                for(int counter = 0; counter < 1000000; counter++) {
                    result = Math.sin(result);
                }
            }
        });
        cpuThread.start();

        List<Object> memoryList = new ArrayList<Object>();
        Thread memoryThread = new Thread(() -> {
            while (true) {
                memoryList.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(10);
                } catch(InterruptedException e) { e.printStackTrace(); }
            }
        });
        memoryThread.start();

        Thread.sleep(Long.MAX_VALUE);
    }
}
