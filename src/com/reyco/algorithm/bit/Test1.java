package com.reyco.algorithm.bit;

/**
 * 加减乘除
 * 
 * @author reyco
 *
 */
public class Test1 {

	public static void main(String[] args) {
		int add = add(8, 9);
		int devide = devide(1, 0);
		System.out.println(add);
	}

	/**
	 * 加法 先异或，再与运算后左移一位,拿到异或结果和与运算结果继续异或、与运算，直到位运算等于0时结束
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b) {
		int sum = 0;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}
	/**
	 * 减法--就是加上它的相反数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int subtract(int a, int b){
		return add(a, negtive(b));
	}
	private static int negtive(int n){
		return add(~n,1);
	}
	/**
     * 乘法---小学乘法
     * @param a
     * @param b
     * @return
     */
    private static int multiply(int a,int b){
        int res = 0;
        while (b != 0){
            if((b & 1) == 1){
            	res = add(res, a);
            }
            a <<= 1;
            b >>= 1;
        }
        return res;
    }
    /**
     * 除法操作
     * @param a
     * @param b
     * @return
     */
    private static int devide(int a,int b){
        if(b == 0){
            throw new ArithmeticException("/ by zero");
        }
        int x = a < 0 ? -a : a;
        int y = b < 0 ? -b : b;
        int end = 0;
        for (int i = 31; i >= 0 ; i = subtract(i,1)) {
            if(y <= (x >> i)){
                end = add(end, (1 << i));
                x = subtract(x, y << i);
            }
        }
        return end;
    }
}
