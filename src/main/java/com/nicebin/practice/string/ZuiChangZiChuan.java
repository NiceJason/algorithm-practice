package com.nicebin.practice.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
 * 查找字符不重复的最长子串长度
 *
 * @Author DiaoJianBin
 * @Date 2021/12/8 10:29
 */
public class ZuiChangZiChuan {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

    /**
     * 这是我第一反应的做法，对是对了，但是时间复杂度太高了
     * 原因是没有用到已检测出不重复子串这个信息，需要用滑动窗口的思想去做
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int max = 0;

        char[] words =s.toCharArray();
        Set<Character> wordSet =  new HashSet<>();
        for(int i =0;i<words.length;i++){
            int nowLengh = 0;
            wordSet.clear();
            for(int j = i ; j<words.length;j++){
                char word = words[j];
                if(wordSet.contains(word)){
                    break;
                }else{
                    wordSet.add(word);
                    nowLengh++;
                    if(nowLengh>max){
                        max = nowLengh;
                    }
                }
            }
        }
        return max;
    }

    /**
     * 这是评论里改进官方示例里点赞最高的版本，避免了左侧的空转
     * 但我觉得还是能再改进一下，如果当前坐标和字符串之间的长度已经小于最大子串的长度，那可以推出判断了
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        //最长子串长度
        int max = 0;
        //滑动窗口左边
        int left = 0;
        //滑动窗口右边
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        //以窗口往右滑动为基础
        for(; right<s.length();right++){
            //如果有子串已经足够长了，那就没必要继续了
            if(s.length() - left < max){
                break;
            }
            char c = s.charAt(right);
            if(map.containsKey(c)){
                //如果该字符已经包含了，那么left应该直接跳转到该字符的后一个位置
                //这里注意，需要和原来的left比较，取最大值
                //毕竟重复元素的位置可能出现在left的左边，但左边的窗口是不能倒回去的
                //因为左边窗口的移动到目前位置说明这个节点之前有重复的元素了
                left = Math.max(map.get(c)+1,left);
            }
            max = Math.max(right - left +1,max);
            //由于key相同,value会被覆盖，所以map里存的内容一定是字符最右边的距离
            map.put(c,right);
        }
        return max;
    }
}
