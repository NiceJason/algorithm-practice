package com.nicebin.practice.search.er_fen_cha_zhao;

import org.junit.Test;

/**
 * 二分查找
 * https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-by-leetcode-solution-f0xw/
 *
 * @Author DiaoJianBin
 * @Date 2021/12/6 9:31
 */
public class ErFenChaZhao {

    @Test
    public void test(){
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums,9));
    }

    public int search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        while(low<=high){
            int mid = (high - low)/2 + low;
            int num = nums[mid];
            if(target == num){
                return mid;
            } else if(target<num){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

