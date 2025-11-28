
public class Loader implements Runnable {
    private final String actionName;
    private final int steps;
    private final long delayMs;

    public Loader(String actionName, int steps, long delayMs) {
        this.actionName = actionName;
        this.steps = steps;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {
        System.out.print(actionName);
        try {
            for (int i = 0; i < steps; i++) {
                Thread.sleep(delayMs);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            // preserve interrupt status
            Thread.currentThread().interrupt();
        }
        System.out.println(); // newline after loading
    }
}
