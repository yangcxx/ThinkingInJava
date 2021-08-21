package cn.yangcx.collection17;

import cn.yangcx.util.Countries;

import java.util.*;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/21 18:34
 */
public class ReadOnly {
    static Collection<String> data =
            new ArrayList<String>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        print(c); // Reading is OK
        //! c.add("one"); // Can't change it

        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        print(lit.next()); // Reading is OK
        //! lit.add("one"); // Can't change it

        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        print(s); // Reading is OK
        //! s.add("one"); // Can't change it

        // For a SortedSet:
        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));

        Map<String, String> m = Collections.unmodifiableMap(new HashMap<>(Countries.capitals(6)));
        print(m); // Reading is OK
        //! m.put("Ralph", "Howdy!");

        // For a SortedMap:
        Map<String, String> sm = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals(6)));
    }
}
