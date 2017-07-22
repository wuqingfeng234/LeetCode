package com.git.wuqf.graph;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {0, 2},{2,1}};

        boolean status=canFinish(2, prerequisites);
        System.out.println(status);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g=new Graph(prerequisites);
        List<Integer> deleteVertex=g.deleteStartVertex();
        while(deleteVertex.size()>0){
            deleteVertex=g.deleteStartVertex();
        }
        if(g.getEdges().size()>0){
            return false;
        }
        return true;
    }


}
