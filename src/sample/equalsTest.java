package sample;

import java.util.HashSet;
import java.util.Set;

public class equalsTest {
    public static void main(String[] args) {
        Tuple tuple = new Tuple(1,2);
        Tuple tuple1 = new Tuple(1,2);
        System.out.println(tuple.equals(tuple1));

        Set tupleSet = new HashSet<Tuple>();
        tupleSet.add(tuple);
        System.out.println(tupleSet.contains(tuple));
        System.out.println(tupleSet.contains(tuple1));
        for (Object tuplex : tupleSet) {
            System.out.println(tuplex.equals(tuple1));
        }
    }
}
