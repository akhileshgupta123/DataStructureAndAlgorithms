import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
public class TCPSocket extends Thread {
    private final String host;
    private final int port;

    private Socket clientSocket;
    private DataOutputStream dataOut;
    private int failedConnectionAttempts = 0;

    private volatile boolean isOpen = false;
    private volatile boolean finished = false;
    private volatile boolean reinit = false;

    public TCPSocket(String host, int port) {
        this.host = host;
        this.port = port;

        String threadName =
                String.format("TcpSocketThread-[%s:%s]-%s", host, port, Instant.now().toEpochMilli());
        setName(threadName);
    }

    public int getFailedConnectionAttempts() {
        return failedConnectionAttempts;
    }

    public void setFailedConnectionAttempts(int failedConnectionAttempts) {
        this.failedConnectionAttempts = failedConnectionAttempts;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public boolean getReinit() {
        return this.reinit;
    }

    public void setInitialized() {
        this.reinit = false;
    }

    public void close() {
        this.finished = true;
    }

    @Override
    public void run() {
        try {
            while (!this.finished) {
                if (!this.isOpen) {
                    openConnection();
                }

                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException ex) {
            log.error("Thread error:", ex);
        } finally {
            closeSocket();
        }
    }

    private void openConnection() {
        log.debug(String.format("Attempting connection to [%s:%s]", host, port));

        try {
            if (clientSocket == null || clientSocket.isClosed()) {
                log.info(String.format("Create a new socket on [%s:%s]", host, port));

                clientSocket = new Socket(host, port);
                dataOut = new DataOutputStream(clientSocket.getOutputStream());
                isOpen = true;
                failedConnectionAttempts = 0;

                log.debug(String.format("Connection to [%s:%s] established", host, port));
            }
        } catch (IOException ex) {
            log.error(String.format("Error opening connection to [%s:%s]", host, port), ex);
            failedConnectionAttempts++;
        }
    }

    private void closeSocket() {
        if (clientSocket != null) {
            try {
                log.debug(String.format("Closing socket [%s:%s]", host, port));

                clientSocket.close();
                isOpen = false;
            } catch (IOException e) {
                log.error(String.format("Error closing socket [%s:%s]", host, port), e);
            }
        }
    }

    public synchronized boolean writeString(String str) {
        log.debug(String.format("Send message to [%s:%s], message -> %s", host, port, str));

        try {
            this.dataOut.writeBytes(str);
            this.dataOut.flush();

            log.debug(String.format("Message has been sent successfully to [%s:%s]", host, port));

            return true;
        } catch (IOException e) {
            log.error(String.format("Error send message to [%s:%s]", host, port), e);

            this.isOpen = false;
            this.reinit = true;

            closeSocket();
        }
        return false;
    }
}
}
