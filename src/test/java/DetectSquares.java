import java.util.*;

/**
 * @Author DiaoJianBin
 * @Date 2022/1/26 9:01
 */
public class DetectSquares {
    //以x为key，记录该水平方向的所有y
    HashMap<Integer, Set<Integer>> xMap = new HashMap<>();
    //以y为key，记录该竖直方向的所有x
    HashMap<Integer, Set<Integer>> yMap = new HashMap<>();
    //记录该点存在的数量，因为题目中多个相同坐标的点是被视为不同的
    int[][] map = new int[1001][1001];

    public DetectSquares() {

    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        Set<Integer> set1 = xMap.get(x);
        if (set1 == null) {
            set1 = new HashSet<>();
            xMap.put(x, set1);
        }
        set1.add(y);

        Set<Integer> set2 = yMap.get(y);
        if (set2 == null) {
            set2 = new HashSet<>();
            yMap.put(y, set2);
        }
        set2.add(x);

        ++map[x][y];
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int count = 0;

        //与该点的水平方向一致
        Set<Integer> ySet = xMap.get(x);
        //与该点的竖直方向一致
        Set<Integer> xSet = yMap.get(y);

        //所有点两两组合试一下
        if (ySet == null || xSet == null) {
            //如果竖直或者水平没第二个点，那肯定凑不成正方形
            return 0;
        }
        for (Integer otherY :
                ySet) {
            for (Integer otherX :
                    xSet) {
                //长度相同且不包含自身
                if (Math.abs(otherX - x) == Math.abs(otherY - y) && (otherX!=x && otherY!=y)) {
                    //其余3个点的数量相乘
                    count = count + map[otherX][y] * map[x][otherY] * map[otherX][otherY];
                }
            }
        }
        return count;
    }
}