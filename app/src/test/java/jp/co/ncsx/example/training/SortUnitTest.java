package jp.co.ncsx.example.training;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("Since15")
public class SortUnitTest {

    /**
     * 「問題1：数値の配列を昇順でソートする」の解答例
     *
     * @throws Exception
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Test
    public void sortNumbersAscendingOrder() throws Exception {
        Integer[] input = {4, 5, 7, 2, 3, 1, 9};

        List<Integer> temp = Arrays.asList(input);
        temp.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                return t0 - t1;
            }
        });

        assertEquals(new Integer(1), temp.get(0));
        assertEquals(new Integer(9), temp.get(temp.size() - 1));
    }

    /**
     * 「問題2：数値の配列を降順でソートする」の解答例
     *
     * @throws Exception
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Test
    public void sortNumbersDescendingOrder() throws Exception {
        Integer[] input = {4, 5, 7, 2, 3, 1, 9};

        List<Integer> temp = Arrays.asList(input);
        temp.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                return t1 - t0;
            }
        });

        assertEquals(new Integer(9), temp.get(0));
        assertEquals(new Integer(1), temp.get(temp.size() - 1));
    }

    /**
     * 「問題3：AnyObjectの配列をAnyObject.keyの（辞書的な）昇順でソートする」の解答例
     *
     * @throws Exception
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Test
    public void sortClassOrder() throws Exception {
        AnyObject[] input = {new AnyObject("C", "CCC"),
                new AnyObject("c", "cccc"),
                new AnyObject("b", "b3457"),
                new AnyObject("00", "0000000"),
                new AnyObject("¥¥", "()()"),
                new AnyObject("A", "AAAA"),
                new AnyObject("b", "BBBB")};

        List<AnyObject> temp = Arrays.asList(input);
        temp.sort(new Comparator<AnyObject>() {
            @Override
            public int compare(AnyObject t0, AnyObject t1) {
                return t1.compareTo(t0);
            }
        });

        assertEquals("¥¥", temp.get(0).key);
        assertEquals("00", temp.get(temp.size() - 1).key);
    }

    private class AnyObject implements Comparable<AnyObject> {
        public String key;
        public String value;

        public AnyObject(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(AnyObject o) {
            return this.key.compareTo(o.key);
        }
    }

}