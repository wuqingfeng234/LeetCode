package com.git.wuqf.graph.courseschedule.matrix;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private int[][] adjacencyMatrix;
    private Set<Integer> vertex;

    public Graph(int numCourses, int[][] prerequisites) {

        initGraph(numCourses, prerequisites);
    }

    private void initGraph(int numCourses, int[][] prerequisites) {

        adjacencyMatrix = new int[numCourses][numCourses];
        for (int[] prerequist : prerequisites) {
            adjacencyMatrix[prerequist[0]][prerequist[1]] = 1;
        }
        vertex = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            vertex.add(i);
        }
    }

    public boolean deleteStartVertex(int numCourses) {

        boolean hasStartVertex=false;

        for (int i = 0; i < numCourses; i++) {
            //第i个元素的入度
            boolean isStartVertex = true;
            for (int j = 0; j < numCourses; j++) {
                if (adjacencyMatrix[j][i] != 0) {
                    isStartVertex = false;
                    break;
                }
            }

            if (isStartVertex && vertex.contains(i)) {
                vertex.remove(i);
                for (int k = 0; k < numCourses; k++) {
                    adjacencyMatrix[i][k] = 0;
                }
                hasStartVertex=true;
            }
        }
        return hasStartVertex;
    }


    public boolean canSort(int numCourses) {
        for (int i = 0; i < numCourses; i++) {
            for (int k = 0; k < numCourses; k++) {
                if (adjacencyMatrix[i][k] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
