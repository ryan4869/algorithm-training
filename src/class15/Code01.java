package class15;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author:
 * @Date: 2022/07/14/10:46
 * @Description: 机器人达到指定位置方法数 P192
 * 暴力递归优化成动态规划套路 -- 尝试过程无后效性
 */
public class Code01 {

    public static void main(String[] args) {
        int N = 5;
        int end = 2;
        int index = 3;
        int cur = 3;
        int[][] mid = new int[index+1][N+1];
        for (int i = 0; i <= index; i++) {
            for (int j = 0; j <= N; j++) {
                mid[i][j] = -1;
            }
        }
        System.out.println(Code01.walk2(5,2,3,3,mid));
        System.out.println(Code01.walk3(2,3,3,mid));
    }

    public static int walk(int N,int end,int index, int cur){
        if (index == 0){
            return cur == end?1:0;
        }
        if (cur == 1){
            return walk(N,end,index-1,cur+1);
        }
        if (cur == N){
            return walk(N,end,index-1,cur-1);
        }
        return walk(N,end,index-1,cur-1) + walk(N,end,index-1,cur+1);
    }


    public static int walk2(int N,int end,int index, int cur, int[][] mid){
        if (mid[index][cur] != -1){
            return mid[index][cur];
        }
        if (index == 0){
            mid[index][cur] = cur == end?1:0;
            return cur;
        }

        if (cur == 1){
            return walk(N,end,index-1,cur+1);
        }
        if (cur == N){
            return walk(N,end,index-1,cur-1);
        }
        return walk(N,end,index-1,cur-1) + walk(N,end,index-1,cur+1);
    }

    public static int walk3(int end,int index,int cur, int[][] mid){
        // 第一步 basecase
        for (int j = 0; j < mid[0].length; j++) {
            if (j == end){
                mid[0][j] = 1;
            }else {
                mid[0][j] = 0;
            }
        }
        for (int i = 1; i < mid.length; i++) {
            for (int j = 1; j < mid[0].length; j++) {
                if (j == 1){
                    mid[i][j] = mid[i-1][j+1];
                }else if (j == mid[0].length-1){
                    mid[i][j] = mid[i-1][j-1];
                }else {
                    mid[i][j] = mid[i-1][j-1] + mid[i-1][j+1];
                }
            }
        }
        return mid[index][cur];
    }



}
