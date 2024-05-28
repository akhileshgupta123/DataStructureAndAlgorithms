public interface RateLimiter {
    boolean throttle(Code code);
    boolean acquire() throws Exception;

    interface Code {
        void invoke();
    }
}
