import java.util.*;

public class ProgrammersSort2 {
    public String solution(int[] numbers) {
        List<String> lst = new LinkedList();
        for (int num : numbers) {
            lst.add(String.valueOf(num));
        }

        Collections.sort(lst, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String n1 = s1 + s2;
                String n2 = s2 + s1;
                return n2.compareTo(n1);
            }
        });
        return (lst.get(0).equals("0")) ? "0" : String.join("",lst);
    }
}