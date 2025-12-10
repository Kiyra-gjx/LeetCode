package hot100;

import java.util.PriorityQueue;

public class t295MedianFinder {
}

class MedianFinder {
    PriorityQueue<Integer> leftQueue;
    PriorityQueue<Integer> rightQueue;

    public MedianFinder() {
        leftQueue = new PriorityQueue<>((x, y) -> y - x);
        rightQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (rightQueue.isEmpty() || num > rightQueue.peek()) {
            rightQueue.offer(num);
        } else {
            leftQueue.offer(num);
        }

        if (rightQueue.size() > leftQueue.size() + 1) {
            leftQueue.offer(rightQueue.poll());
        } else if (leftQueue.size() > rightQueue.size()) {
            rightQueue.offer(leftQueue.poll());
        }
    }

    public double findMedian() {
        if (leftQueue.size() == rightQueue.size()) {
            return (leftQueue.peek() + rightQueue.peek()) / 2.0;
        } else {
            return (double) rightQueue.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
