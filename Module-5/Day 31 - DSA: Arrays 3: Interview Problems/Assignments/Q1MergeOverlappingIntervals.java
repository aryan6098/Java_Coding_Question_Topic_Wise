/*
 * Q1. Merge Overlapping Intervals
Problem Description
Given a collection of intervals, merge all overlapping intervals.



Problem Constraints
1 <= Total number of intervals <= 100000.

Input Format
First argument is a list of intervals.


Output Format
Return the sorted list of intervals after merging all the overlapping intervals.


Example Input
Input 1:
[1,3],[2,6],[8,10],[15,18]

Example Output
Output 1:
[1,6],[8,10],[15,18]

Example Explanation
Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
 */

import java.util.ArrayList;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Q1MergeOverlappingIntervals {

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        int st = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        intervals.sort((a,b)-> Integer.compare(a.start, b.start));
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= end ) {
                st = Math.min( st, intervals.get(i).start);
                end = Math.max(end, intervals.get(i).end);
            }else {
                list.add(new Interval(st, end));
                st = intervals.get(i).start;
                end = intervals.get(i).end;
            }

        }
        list.add(new Interval(st, end));
        return list;
    }
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 2));
        intervals.add(new Interval(1,5));
        intervals.add(new Interval(5,6));
        intervals.add(new Interval(6,8));
        intervals.add(new Interval(7,10));
        intervals.add(new Interval(8,9));
        intervals.add(new Interval(12,14));
        ArrayList<Interval> result = merge(intervals);
      
        for(Interval interval : result) {
            System.out.println("(" + interval.start + "," + interval.end + ")");
        }

    }
}
