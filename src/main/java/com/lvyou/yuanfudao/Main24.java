package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 20:40
 */
public class Main24 {

    public static void main(String[] args) {
        pailie("abc");
    }
    public static void pailie(String s) {

        char[] chars = s.toCharArray();
        pailie(chars,0);

    }

    public static void pailie(char[] chars, int index) {

        if (index >= chars.length){
            System.out.println(String.valueOf(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars,i,index);
            pailie(chars,index+1);
            swap(chars,i,index);
        }
    }


    private static void swap( char[] chars ,int i ,int j) {
        char temp = chars[i];

        chars[i] = chars[j];
        chars[j] = temp;
    }
}
