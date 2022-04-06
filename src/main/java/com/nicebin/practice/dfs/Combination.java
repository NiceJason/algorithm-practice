package com.nicebin.practice.dfs;

import org.junit.Test;
import java.util.Stack;

/**
 * https://blog.csdn.net/tredemere/article/details/52815965
 *
 * @Author DiaoJianBin
 * @Description 排列组合
 * @Date 2021/3/16 16:17
 */
public class Combination {

    @Test
    public void combination(){
        int index = 0;

        char[] chars = {'a','b','c'};

        System.out.println("-----不可重复完全排列------");
        arrange(chars,0,chars.length);
     }

    public static void arrange(char[] chs, int start, int len){
        if(start == len-1){
            for(int i=0; i<chs.length; ++i)
                System.out.print(chs[i]);
            System.out.println();
            return;
        }
        for(int i=start; i<len; i++){
            char temp = chs[start];
            chs[start] = chs[i];
            chs[i] = temp;
            arrange(chs, start+1, len);
            temp = chs[start];
            chs[start] = chs[i];
            chs[i] = temp;
        }
    }
}
