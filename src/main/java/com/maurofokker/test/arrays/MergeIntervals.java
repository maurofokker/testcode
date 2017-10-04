package com.maurofokker.test.arrays;

import com.maurofokker.test.utils.Tuple;

import java.util.ArrayList;

/**
 * Created by mauro on 10/3/17.
 *
 * Given an array (list) of intervals as input where each interval has a start and end timestamps.
 * Input array is sorted by starting timestamps. You are required to merge overlapping intervals
 * and return output array (list).
 *
 * Consider below input array.
 * Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping so should be merged to one big interval (1, 8).
 * Similarly intervals (10, 12) and (11, 15) are also overlapping intervals and should be merged to (10, 15).
 *
 * Hint:
 *  Linear scan
 */
public class MergeIntervals {

    /**
     * runtime complexity O(n)
     * memory complexity O(1)
     *
     * Approach
     * 1 List of input intervals is given, and we'll keep merged intervals in output list
     * 2 For each interval in the input list
     *    if input interval is overlapping with the last interval in output list then we'll merge these two intervals and update last interval of output list with merged interval
     *    otherwise, we'll add input interval to the output list.
     * @param v1
     * @return
     */
    public ArrayList<Tuple<Integer,Integer>> mergeIntervals(ArrayList<Tuple<Integer,Integer>> v1) {

        if(v1 == null || v1.size() == 0) {
            return null;
        }

        ArrayList<Tuple<Integer,Integer>> v2 =
                new ArrayList<Tuple<Integer,Integer>>();

        v2.add(new Tuple<Integer,Integer>(v1.get(0).a, v1.get(0).b));

        for(int i = 1 ; i < v1.size(); i++) {
            int x1 = v1.get(i).a;
            int y1 = v1.get(i).b;
            int x2 = v2.get(v2.size() - 1).a;
            int y2 = v2.get(v2.size() - 1).b;

            if(y2 >= x1) {
                v2.get(v2.size()-1).b = Math.max(y1, y2);
            } else {
                v2.add(new Tuple<Integer,Integer>(x1, y1));
            }
        }

        return v2;
    }

}
