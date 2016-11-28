package jp.co.ncsx.example.training;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("Since15")
public class ExampleUnitTest {

    /**
     * 「問題：数値の配列を昇順でソートする」の解答例
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
     * 「問題：数値の配列を降順でソートする」の解答例
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

}