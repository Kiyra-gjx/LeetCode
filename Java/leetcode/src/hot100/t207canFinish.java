package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class t207canFinish {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] adj = new List[numCourses + 1];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new ArrayList<>();
            }

            int[] in = new int[numCourses + 1];
            for (int[] array : prerequisites) {
                int fa = array[0], son = array[1];
                adj[fa].add(son);
                in[son]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0) {
                    q.offer(i);
                }
            }

            while(!q.isEmpty()) {
                int fa = q.poll();

                for (int son : adj[fa]) {
                    in[son]--;
                    if (in[son] == 0) {
                        q.offer(son);
                    }
                }
            }

            for (int i = 0; i < numCourses; i++) {
                if (in[i] != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
