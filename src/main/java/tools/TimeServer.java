package tools;

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
public final class TimeServer {

    public long now() {
        return System.currentTimeMillis();
    }

    public void start() {
        System.out.println(String.format("[%s] TimeServer started !", Thread.currentThread().getName()));
    }

    public void stop() {
        System.out.println(String.format("[%s] TimeServer stopped !", Thread.currentThread().getName()));
    }
}
