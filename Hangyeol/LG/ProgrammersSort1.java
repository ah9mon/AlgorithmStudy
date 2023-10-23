import java.util.*;
public class ProgrammersSort1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] rlt = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            List<Integer> lst = new LinkedList();
            for (int idx = command[0] - 1; idx < command[1]; idx++) {
                lst.add(array[idx]);
            }

            Collections.sort(lst);
            rlt[i] = lst.get(command[2] - 1);
        }
        return rlt;
    }
}
