package com.dynamic.algorithm.madeEasyInJava;

import java.util.LinkedList;

/**
 * @author xinghuajian
 * @description DFS, 深度优先算法实现
 * @date 2019/10/12 09:53
 */
public class DepthFirstSearch {

    /**
     * 顶点的个数
     */
    private int v;
    /**
     * 邻接表，数组，数组的类型是LinkedList类型，
     * LinkedList里面存的Integer类型的数据
     */
    private LinkedList<Integer> adj[];

    /**
     * 全局变量或者类成员变量
     */
    boolean found = false;

    /**
     * 构造深度优先算法的无向图
     *
     * @param v
     */
    public DepthFirstSearch(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }



    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}
