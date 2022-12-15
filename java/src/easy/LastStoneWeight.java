package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue(Comparator.reverseOrder());
        for (int stone : stones) {
            maxheap.add(stone);
        }
        int num1;
        int num2;
        while(maxheap.size() > 0){
            if(maxheap.size() == 1){
                return maxheap.poll();
            }
            num1 = maxheap.poll();
            num2 = maxheap.poll();
            if(num1 != num2){
                maxheap.add(num1-num2);
            }
        }
        return 0;
    }
}
