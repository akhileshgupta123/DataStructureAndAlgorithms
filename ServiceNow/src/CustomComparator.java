import java.util.Comparator;
import java.util.function.ToDoubleFunction;

public class CustomComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2){
        return o2.compareTo(o1);
    }

    @Override
    public Comparator<Integer> reversed() {
        return null;
    }

    @Override
    public Comparator<Integer> thenComparingDouble(ToDoubleFunction<? super Integer> keyExtractor) {
        return null;
    }
}
