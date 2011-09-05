/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
final class Server {
    void start() {
        System.out.println(String.format("[%s] Server started !", Thread.currentThread().getName()));
    }

    void stop() {
        System.out.println(String.format("[%s] Server stopped !", Thread.currentThread().getName()));
    }
}
