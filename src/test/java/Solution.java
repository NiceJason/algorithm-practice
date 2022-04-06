import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] nums;
    int[] old;

    public Solution(int[] nums) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        this.nums = nums;
        this.old = ints;
    }

    public int[] reset() {
        return old;
    }

    //洗牌算法，将两个位置的变量调换
    public int[] shuffle() {
        Random random = new Random();
        //每个位置随机拿一个数
        for(int i = 0 ;i<nums.length;i++){
            int targetIndex = random.nextInt(nums.length);
            //交换两个位置的数
            int temp = nums[i];
            nums[i] = nums[targetIndex];
            nums[targetIndex] = temp;
        }
        return nums;
    }
}

