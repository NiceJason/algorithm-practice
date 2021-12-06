package com.nicebin.practice.search.er_fen_cha_zhao.bad_version;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/first-bad-version/submissions/
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5)-> true
 * 调用 isBadVersion(4)-> true
 * 所以，4 是第一个错误的版本。
 *
 *
 * @Author DiaoJianBin
 * @Date 2021/12/6 11:35
 */
public class BadVersion {

    public int badVersion = 1;

    @Test
    public void test(){
        System.out.println(firstBadVersion1(3));
    }

    public boolean isBadVersion(int version){
        if(version>=badVersion){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 这是我自己想出来的方法
     * 我的想法还是比较线性的，目标就是找到坏版本和好版本交替的位置
     * firstBadVersion2是官方的思路
     * @param n
     * @return
     */
    public int firstBadVersion1(int n) {

        int low = 1;
        int high = n;
        while(low<=high){
            int mid = (high - low)/2 + low;
            if(isBadVersion(mid)){
                //如果这个坏版本刚好是最开始的版本，或者它上个版本刚好是好版本，那么就是找到了
                if(mid == low || !isBadVersion(mid-1)){
                    return mid;
                }

                //这里找到的坏版本是中间版本，那么要往low区间找
                high = mid - 1;
            }else {
                //因为坏版本之后都是坏版本，所以mid如果是好版本，那么low到mid都是好版本
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 可以看到官方写的更加简洁
     * 它的逻辑是，一直找坏版本，找到最后找不到了，那上一个找到坏版本就是最新开始的坏版本
     * @param n
     * @return
     */
    public int firstBadVersion2(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }
}
