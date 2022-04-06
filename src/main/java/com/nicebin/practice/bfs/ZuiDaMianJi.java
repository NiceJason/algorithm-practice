package com.nicebin.practice.bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 * <p>
 * 求岛屿的最大面积
 *
 * @Author DiaoJianBin
 * @Date 2021/12/9 9:59
 */
public class ZuiDaMianJi {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    @Test
    public void test() {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        //单次探索队列
        Queue<int[]> onceQueue = new LinkedList<>();
        int maxSize = 0;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                //如果是正常的大陆，那么将进行一次探索
                int size = 0;
                onceQueue.clear();
                onceQueue.offer(new int[]{m,n});
                
                while (!onceQueue.isEmpty()) {
                    int[] location = onceQueue.poll();
                    int x = location[0];
                    int y = location[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        size++;
                        //标记已经探索过
                        grid[x][y] = 2;
                        //四处探索一下
                        for (int i = 0; i < 4; i++) {
                            onceQueue.offer(new int[]{x + dx[i], y + dy[i]});
                        }
                    }
                }
                //此次探索完的结果
                maxSize = Math.max(size, maxSize);
            }
        }

        return maxSize;
    }
}
