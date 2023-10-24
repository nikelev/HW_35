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
            int a= Integer.parseInt(s1.substring(s1.length()-4)) ;
            int b= Integer.parseInt(s2.substring(s2.length()-4)) ;

            if (a>b){
                return -1;
             }
            if (a<b){
                return -1;
            }

              a= Integer.parseInt((s1.substring(s1.length()-7, s1.length()-5))) ;
            b= Integer.parseInt((s1.substring(s1.length()-7, s1.length()-5))) ;
              if (a>b){
                  return 1;
              }
              if (a<b){
                  return -1;
              }
            a= Integer.parseInt((s1.substring(s1.length()-10, s1.length()-8))) ;
            b= Integer.parseInt((s1.substring(s1.length()-10, s1.length()-8))) ;

            if (a>b){
                return 1;
            }
            if (a<b){
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
//        assertArrayEquals(expected, dates);
    }
}
