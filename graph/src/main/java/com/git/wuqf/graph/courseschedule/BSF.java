package com.git.wuqf.graph.courseschedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSF {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequeisites = {{0, 1}, {1, 0}, {2, 0}};
        boolean status=canFinish(numCourses,prerequeisites);
        System.out.println(status);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList[] graph = new ArrayList[numCourses];
        int[] outDegree = new int[numCourses];
        Queue queue = new LinkedList();


        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int startVertex=prerequisites[i][1];
            outDegree[startVertex]++;

            int endVertex=prerequisites[i][0];
            graph[endVertex].add(startVertex);
        }

        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                //将出度为0的顶点坐标装入queue
                queue.add(i);
                count++;
            }
        }
        while (queue.size() != 0) {

            int course = (int) queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                //第i个出度对应的顶点
                int pointer = (int) graph[course].get(i);
                outDegree[pointer]--;
                if (outDegree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }

        if (count == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}
