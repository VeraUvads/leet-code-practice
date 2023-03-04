package design;

import java.util.LinkedList;

public class DesignARateLimitingSystem {
    class RateLimiter {
        private int requests;
        private int seconds;
        private LinkedList<Integer> allowedRequests;

        public RateLimiter(int maxRequest, int seconds) {
            this.requests = maxRequest;
            this.seconds = seconds;
            this.allowedRequests = new LinkedList<>();
        }

        public boolean shouldAllow(int timestamp) {
            if (seconds == 0 || requests == 0) return false;

            while (!allowedRequests.isEmpty() && timestamp - seconds >= allowedRequests.getFirst()) {
                allowedRequests.pollFirst();
            }
            if (allowedRequests.size() < requests) {
                allowedRequests.add(timestamp);
                return true;
            }
            return false;
        }
    }
}
