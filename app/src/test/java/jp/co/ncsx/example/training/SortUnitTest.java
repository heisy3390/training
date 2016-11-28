package jp.co.ncsx.example.training;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * ソートを行う処理を作成する問題の解答例です。
 */
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

    /**
     * 「問題4：Mapをkeyの昇順でソートする」の解答例
     *
     * @throws Exception
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Test
    public void sortMapAscendingOrder() throws Exception {
        Map<String, String> actual = new TreeMap<>();
        actual.put("5", "CCC");
        actual.put("2", "cccc");
        actual.put("10", "b3457");
        actual.put("34", "0000000");
        actual.put("0", "()()");
        actual.put("-9", "AAAA");
        actual.put("100", "BBBB");

        assertEquals("[AAAA, ()(), b3457, BBBB, cccc, 0000000, CCC]", actual.values().toString());
    }

    /**
     * 「問題5：Mapをkeyの降順でソートする」の解答例
     *
     * @throws Exception
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Test
    public void sortMapDescendingOrder() throws Exception {
        Map<String, String> actual = new Hashtable<>();
        actual.put("5", "CCC");
        actual.put("2", "cccc");
        actual.put("10", "b3457");
        actual.put("34", "0000000");
        actual.put("0", "()()");
        actual.put("-9", "AAAA");
        actual.put("100", "BBBB");

        assertEquals("[CCC, cccc, BBBB, 0000000, b3457, ()(), AAAA]", actual.values().toString());
    }

    /**
     * 「問題6：Mapを特定のルールでソートする」の解答例
     *
     * @throws Exception
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Test
    public void sortMapSpecialOrder() throws Exception {
        Map<String, String> input = new LinkedHashMap<>();
        input.put("5", "CCC");
        input.put("2", "cccc");
        input.put("10", "b3457");
        input.put("34", "0000000");
        input.put("0", "()()()()");
        input.put("-9", "AAAAAA");
        input.put("100", "BBBBBBBBBBBB");

        List<Map.Entry> list = new ArrayList<Map.Entry>(input.entrySet());
        Collections.sort(list, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry t0, Map.Entry t1) {
                return ((String) t0.getValue()).length() - ((String) t1.getValue()).length();
            }
        });
        Map<String, String> actual = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : list) {
            actual.put(entry.getKey(), entry.getValue());
        }

        assertEquals("[CCC, cccc, b3457, AAAAAA, 0000000, ()()()(), BBBBBBBBBBBB]", actual.values().toString());
    }

}