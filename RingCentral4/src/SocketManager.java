import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
public final class SocketManager {
    private static ConcurrentHashMap<String, TCPSocket> tcpSockets = new ConcurrentHashMap<>();

    private SocketManager() {}

    /**
     * To ensure we have no more than 1 socket for each distinct host/port combination, use this
     * method
     */
    public static TCPSocket getTCPSocket(String host, int port) {
        String socketId = host + ":" + port;
        TCPSocket existSocket = tcpSockets.get(socketId);

        if (existSocket == null) {
            TCPSocket socket = new TCPSocket(host, port);
            socket.start();
            tcpSockets.put(socketId, socket);

            return socket;
        }

        return existSocket;
    }

    /**
     * Remove a socket for a given host/port combination
     */
    public static void removeTCPSocket(String host, int port) {
        String socketId = host + ":" + port;
        TCPSocket tcpSocket = tcpSockets.remove(socketId);

        if (tcpSocket != null) {
            log.debug("removeTCPSocket(" + socketId + ")");

            tcpSocket.close();
        }
    }
}
