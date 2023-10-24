package ait.arrays.test;

import ait.soldier.model.Soldier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {
    Integer[] arrNum;
    String[] arrStr;
    Soldier[] soldiers;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{9, 7, 4, 7, 2, 5, 1, 0};
        arrStr = new String[]{"one", "two", "three", "four", "five"};

        soldiers = new Soldier[]{
                new Soldier("John", 182, 82.3, 91),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Robindranate", 162, 55.1, 91),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Ann", 162, 55, 88),
        };
    }

    @Test
    void testArraysSort() {
        Arrays.sort(arrNum);
        System.out.println(Arrays.toString(arrNum));
        Arrays.sort(arrStr);
        System.out.println(Arrays.toString(arrStr));
    }

    @Test
    void testArraysSortComparator() {
        Arrays.sort(arrNum, (n1, n2) -> n2 - n1);
        System.out.println(Arrays.toString(arrNum));
        Arrays.sort(arrStr, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(arrStr));
    }

    @Test
    void testSortSoldiersNaturalOrder() {
        Arrays.sort(soldiers);
        printArray(soldiers);
    }

    @Test
    void testSoldiersByName() {
        Arrays.sort(soldiers, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        printArray(soldiers);
    }

    @Test
    void testSoldiersByProfile() {
        Arrays.sort(soldiers, (s1, s2) -> {
            int res = s2.getProfile() - s1.getProfile();
            res = res != 0 ? res : s1.getHeight() - s2.getHeight();
            return res != 0 ? res : s1.getName().compareTo(s2.getName());

        });
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByWeht() {
        Arrays.sort(soldiers, (s1, s2) -> {
            double res = s1.getWeight() - s2.getWeight();
            if (res < 0) {
                return -1;
            }
            if (res > 0) {
                return 1;
            }
            return 0;
        });
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByWeht2() {
        Arrays.sort(soldiers, (s1, s2) -> Double.compare(s1.getWeight(), s2.getHeight()));// метод из wrapper class!!!
        printArray(soldiers);
    }

    @Test
    void testOd1() {
        Integer[] origin = {2, 4, 5, 6, 3, 5, 8, 4};
        Comparator<Integer> comparator = (n1, n2)->{
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;

            }if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;

            }
            return 0;
        }
        ;
        Arrays.sort(origin, comparator);
        System.out.println(Arrays.toString(origin));
    }


    @Test
    void testOd2() {
        Integer[] origin = {2, 4, 5, 6, 3, 5, 8, 4,9,3,6,5,7};
        Comparator<Integer> comparator = (n1, n2)->{
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;

            }
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;

            }
            if (n1 % 2 == 0 && n2 % 2 == 0) {
                return n1-n2;

            }
            if (n1 % 2 != 0 && n2 % 2 != 0) {
                return n2-n1;

            }
            return 0;


//            if (n1 % 2 == 0 && n2 % 2 == 0) {
//                return n1 - n2;
//            } else if (n1 % 2 != 0 && n2 % 2 != 0) {
//                return n2 - n1;
//            } else {
//                if (n1 % 2 == 0) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }



        };
        Arrays.sort(origin, comparator);
        System.out.println(Arrays.toString(origin));
    }



    private void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("====================================================");
    }
}
