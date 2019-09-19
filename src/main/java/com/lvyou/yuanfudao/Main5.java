package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 17:00
 */
public class Main5 {

    public static void main(String[] args) {

        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        int startX = 0,startY = 0,endX = nums[0].length-1,endY = nums.length-1;

        while (startX <= endX && startY <= endY) {
            //左->右
            if (startX <= endX) {
                for (int i = startX; i <= endX; i++) {
                    System.out.print(nums[startY][i]);
                }
            }
            //上->下 至少两行
            if (startY < endY) {
                for (int i = startY + 1; i < endY; i++) {
                    System.out.print(nums[i][endX]);
                }
            }
            //右->左 至少两行两列
            if (startX < endX && startY < endY) {
                for (int i = endX; i >= startX; i--) {
                    System.out.print(nums[endY][i]);
                }
            }
            //下->上 至少 三行两列

            if (startX< endX && startY < endX-1) {
                for (int i = endY-1;i > startY; i-- ){
                    System.out.print(nums[i][startX]);
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
    }

    public static int[] print(int[][] arr, int n, int m) {
        int startX = 0;
        int startY = 0;
        int endX = m-1;
        int endY = n-1;
        int index = 0;
        int[] res = new int[n*m];
        while (startX <= endX && startY <= endY) {

            // 上---->下
            if (startY <= endY) {
                for (int i = startY; i <= endY; i++) {
                    res[index++] = arr[i][startX];
                }
            }
            // 左---->右 (两列以上)
            if (startX < endX) {
                for (int i = startX+1; i <= endX; i++) {
                    res[index++] = arr[endY][i];
                }
            }
            // 下---->上(两行两列以上)
            if (startX < endX && startY < endY) {
                for (int i = endY-1; i >= startY; i--) {
                    res[index++] = arr[i][endX];
                }
            }
            // 右---->左(三列两行以上)
            if (startX < endX-1 && startY < endY) {
                for (int i = endX-1; i >= startX+1; i--) {
                    res[index++] = arr[startY][i];
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return res;
    }

}
