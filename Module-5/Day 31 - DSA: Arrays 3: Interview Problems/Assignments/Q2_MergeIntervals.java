/*
 * Q2. Merge Intervals

 Problem Description
You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.


Problem Constraints
0 <= |intervals| <= 105


Input Format
First argument is the vector of intervals

second argument is the new interval to be merged


Output Format
Return the vector of intervals after merging

Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:
 [ [1, 5], [6, 9] ]

Output 2:
 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
 */

import java.util.ArrayList;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int st, int e) {
        start = st;
        end = e;
    }
}

public class Q2_MergeIntervals {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<>();
        
       for(int i = 0; i < intervals.size(); i++) {
        if(intervals.get(i).end < newInterval.start) {
            list.add(intervals.get(i));
        }
        else if(newInterval.end < intervals.get(i).start) {
            list.add(newInterval);
            for(int  j = i; j < intervals.size(); j++) {
                list.add(intervals.get(j));
            }
            return list;
        }
        else {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
        }
       }
       list.add(newInterval);

        return list;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
         intervals.add(new Interval(1,5));
         intervals.add(new Interval(8,10));
         intervals.add(new Interval(10, 14));
         intervals.add(new Interval(16, 19));
         intervals.add(new Interval(21, 24));
         intervals.add(new Interval(27, 30));
         intervals.add(new Interval(32, 35));
         intervals.add(new Interval(38, 45));

         Interval newInterval = new Interval(12,22);
         ArrayList<Interval> result  = insert(intervals, newInterval);
         for(Interval interval : result) {
            System.out.println("(" + interval.start  + ", " + interval.end + ")");
         }
    }
}
