package com.dynamic.algorithm.madeEasyInJava;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xinghuajian
 * @description BFS, 广度优先算法实现
 * @date 2019/10/12 09:39
 * visited是用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点q被访问，那相应的visited[q]会被设置为true。
 *
 * queue是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
 * 因为广度优先搜索是逐层访问的，也就是说，我们只有把第k层的顶点都访问完成之后，才能访问第k+1层的顶点。
 * 当我们访问到第k层的顶点的时候，我们需要把第k层的顶点记录下来，稍后才能通过第k层的顶点来找第k+1层的顶点。
 * 所以，我们用这个队列来实现记录的功能。
 *
 * prev用来记录搜索路径。
 * 当我们从顶点s开始，广度优先搜索到顶点t后，prev数组中存储的就是搜索的路径。
 * 不过，这个路径是反向存储的。prev[w]存储的是，顶点w是从哪个前驱顶点遍历过来的。
 * 比如，我们通过顶点2的邻接表访问到顶点3，那prev[3]就等于2。为了正向打印出路径，我们需要递归地来打印，你可以看下print()函数的实现方式。
 */
public class BreadthFirstSearch {

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
     * 构造广度优先算法的无向图
     *
     * @param v
     */
    public BreadthFirstSearch(int v) {
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

    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
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
