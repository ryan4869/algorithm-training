package class09;

import java.util.ArrayList;
import java.util.List;

public class hanoi {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        Solution solution = new Solution();
        solution.hanota(A,B,C);
        System.out.println(C.toString());
        process(3,"左","右","中");
        // 左   中   右
        // 23        1
        // 3    2    1
        // 3    12
        //      12   3
        // 1    2    3
        // 1         23
        //           123
    }

    public static void process(int i, String from, String to,String other){
        if (i == 1){
            System.out.println("第"+i+"从"+from+"到"+to);
            return;
        }
        // 0~i-1 放到other
        process(i-1,from,other,to);
        // i 放到to
        System.out.println("第"+i+"从"+from+"到"+to);
        // 0~i-1 放到to
        process(i-1,other,to,from);
    }
}

class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        this.process2(A.size()-1, A, C, B);
    }
    public void process2(int i, List<Integer> A, List<Integer> B, List<Integer> C){
        if (i == 0){
            System.out.println(A.get(0)+"从"+A+"到"+B);
            Integer remove = A.remove(0);
            B.add(0,remove);
            return;
        }
        // 0~i-1 放到other
        process2(i-1,A,C,B);
        // i 放到to
        System.out.println(A.get(0)+"从"+A+"到"+B);
        Integer remove = A.remove(0);
        B.add(0,remove);
        // 0~i-1 放到to
        process2(i-1,C,B,A);
    }
}