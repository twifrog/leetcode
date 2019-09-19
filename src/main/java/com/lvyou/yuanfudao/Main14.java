package com.lvyou.yuanfudao;

import java.util.Arrays;

/**
 * @author LeoLv
 * @date 2019/9/18 17:47
 */
public class Main14 {


    public static int[][] mark = new int[8][8];
    public static void main(String[] args) {
        findQueen(0);

    }

    public static void print(){
        for (int i = 0; i < mark.length; i++) {
            System.out.println(Arrays.toString(mark[i]));
        }
        System.out.println("________________________________________________");
    }
    public static void findQueen(int row) {
        if (row > 7) {
            print();
            return;
        }
        for (int col = 0; col < 8; col++) {
            if (check(row,col)) {
                mark[row][col] = 1;
                findQueen(row+1);
                mark[row][col] = 0;
            }
        }
    }

    public static boolean check(int k, int j) {
        for(int i = 0; i < 8; i++){//检查行列冲突
            if(mark[i][j] == 1){
                return false;
            }
        }
        for(int i = k - 1, m = j - 1; i >= 0 && m >= 0; i--, m--){//检查左对角线
            if(mark[i][m] == 1){
                return false;
            }
        }
        for(int i = k - 1,m = j + 1; i >= 0 && m<=7; i--, m++){//检查右对角线
            if(mark[i][m] == 1){
                return false;
            }
        }
        return true;

    }
}
