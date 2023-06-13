package T08Generics.CustomListSorter_08;

import java.util.Collections;
import java.util.List;

public class Sorter {

    public static <T extends Comparable<T>> void sort(List<T>data) {
        Collections.sort(data);
    }
}