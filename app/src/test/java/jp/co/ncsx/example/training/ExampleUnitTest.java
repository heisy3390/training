package jp.co.ncsx.example.training;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    @Test
    public void sortNumbers() throws Exception {
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

}