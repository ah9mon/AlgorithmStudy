import java.util.*;

class DoublePriorityQ {
    List<Integer> q;

    public DoublePriorityQ() {
        this.q = new LinkedList();
    }

    public int peekFirst() {
        return this.q.get(0);
    }

    public int peekLast() {
        return this.q.get(q.size() - 1);
    }

    public void delMin () {
        if (!this.q.isEmpty()) this.q.remove(0);
    }

    public void delMax() {
        if (!this.q.isEmpty()) this.q.remove(q.size() - 1);
    }

    public void add(int n) {
        this.q.add(n);
        Collections.sort(this.q);
    }

    public boolean isEmpty() {
        return this.q.isEmpty();
    }

    public int size() {
        return this.q.size();
    }
}

public class ProgrammersPriorityQueue3 {



    public int[] solution(String[] operations) {
        DoublePriorityQ q = new DoublePriorityQ();
        int n = operations.length;
        for (int i = 0; i < n; i++) {
            StringTokenizer operation = new StringTokenizer(operations[i]);
            String oper = operation.nextToken();
            int num = Integer.parseInt(operation.nextToken());

            if (oper.equals("I")) {
                q.add(num);
            } else {
                if (num == 1) {
                    q.delMax();
                } else {
                    q.delMin();
                }
            }
        }

        if (q.isEmpty()) {
            return new int[]{0,0};
        } else {
            if (q.size() > 1) {
                int min = q.peekFirst();
                int max = q.peekLast();
                return new int[]{max, min};
            } else {
                int min = q.peekFirst();
                return new int[]{min, min};
            }
        }
    }
}
