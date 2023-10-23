import java.util.*;

class Phone implements Comparable<Phone>{
    String num;

    public Phone (String num) {
        this.num = num;
    }

    public int compareTo (Phone phone) {
        if (this.num.length() != phone.num.length()) return this.num.length() - phone.num.length();
        return 1;
    }
}

public class ProgrammersHash3 {
    public boolean solution(String[] phone_book) {
//         Arrays.sort(phone_book, new Comparator<String>(){

//             public int compare(String n1, String n2) {
//                 if (n1.length() != n2.length()) {
//                     return n1.length() - n2.length();
//                 }
//                 return n1.compareTo(n2);
//             }
//         });
//         Arrays.sort(phone_book);



//         for (int i = 0; i < phone_book.length - 1; i++) {
//             if (phone_book[i + 1].startsWith(phone_book[i])) return false;
//         }
//         return true;

        Map<String, Integer> map = new HashMap();
        for (int idx = 0; idx < phone_book.length; idx++) {
            map.put(phone_book[idx], idx);
        }



        for (int idx = 0; idx < phone_book.length; idx++) {
            for (int i = 1; i < phone_book[idx].length(); i++) {
                if (map.get(phone_book[idx].substring(0, i)) != null) return false;
            }
        }
        return true;
    }


}
