package ait.arrays.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DateSortTest {
    Comparator<String> comparator;

    @BeforeEach
    void setUp() {
        comparator = (s1, s2) -> {
            int a = Integer.parseInt(s1.substring(s1.length() - 4));
            int b = Integer.parseInt(s2.substring(s2.length() - 4));
            int c = Integer.parseInt((s1.substring(s1.length() - 7, s1.length() - 5)));
            int d = Integer.parseInt((s2.substring(s2.length() - 7, s2.length() - 5)));
            int f = Integer.parseInt((s1.substring(s1.length() - 10, s1.length() - 8)));
            int e = Integer.parseInt((s2.substring(s2.length() - 10, s2.length() - 8)));

            if (a < b) {
                return -1;
            }
            if (a == b && c < d) {
                return -1;
            }
            if (a == b && c == d && f < e) {
                return -1;
            }


            return 0;


        };
    }

    @Test
    void testDateSort() {
        String[] dates = {
                "07-05-1990",
                "28-01-2010",
                "11-08-1990",
                "15-01-2010",
                "16-06-1970"
        };
        String[] expected = {
                "16-06-1970",
                "07-05-1990",
                "11-08-1990",
                "15-01-2010",
                "28-01-2010"
        };
//        for (int i = 0; i < dates.length; i++) {
//            dates[i] = dates[i].replace("-", "");
//
//            System.out.println(dates[i].substring(dates[i].length()-4));
//        }

//        System.out.println(Arrays.toString(dates));

        Arrays.sort(dates, comparator);
         System.out.println(Arrays.toString(dates));
         assertArrayEquals(expected, dates);
    }
}
