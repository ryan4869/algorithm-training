package easy;

/**
 * Created by ryangjun on 2021/8/1.
 */
public class Code07_IntegerReverse {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));;
    }

    public static int reverse(int x){
        if (x == 0 ){
            return 0;
        }else if (x>0){
            int sum = 0;
            int i = 0;
            while (x>0){

                if (i!=0){
                    sum *=10;
                }
                sum += x%10;
                x = x/10;
                i++;
            }
            if (sum > Math.pow(2,31)-1){
                return 0;
            }else {
                return sum;
            }

        }else {
            int sum = 0;
            int i = 0;
            x = 0-x;
            while (x>0){
                if (i!=0){
                    sum *=10;
                }
                sum += x%10;
                x = x/10;
                i++;
            }
            return (0-sum);
        }
    }
}
