import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        Queue<Integer> queue = new LinkedList<Integer>();
        int k = 3;
        List<Integer> maxNums = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            int max = findMax(queue);
            queue.poll();
            queue.offer(arr[i]);
            maxNums.add(max);
        }
        int max = findMax(queue);
        maxNums.add(max);
        maxNums.forEach((e) -> {
            System.out.println(e);
        });
    }

    public static int findMax(Queue<Integer> queue) {
        int max = Integer.MIN_VALUE;
        for (Integer i : queue) {
            if (i > max)
                max = i;
        }
        return max;
    }
}
