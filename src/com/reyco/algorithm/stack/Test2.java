package com.reyco.lgorithm.stack;

/**
 * 42
 * 定义：数组中累加和与最小值的乘积，假设叫做指标A。
 * 给定一个数组，请返回子数组中指标最大的值。
 * 思路：单调栈: 左边比它小的、右边比它小的，中间就是要的数。
 *  讨论以i作为最小值，求i的指标，此过程出现最大的指标就是解。
 * 	5，3，2，1，6，7，8，4
 *  	以0位置的5作为最小值:最大的和:5      最小值5， 乘积：5*5=25
 *  	以1位置的3作为最小值:最大的和:8      最小值3， 乘积：8*3=24
 *  	以2位置的2作为最小值:最大的和:10   最小值2， 乘积：10*2=20
 *  	以3位置的1作为最小值:最大的和:36   最小值1， 乘积：36*1=36
 *  	以4位置的6作为最小值:最大的和:21   最小值6， 乘积：21*6=126
 *  	以5位置的7作为最小值:最大的和:15   最小值7， 乘积：15*7=105
 *  	以6位置的8作为最小值:最大的和:8   最小值8， 乘积：8*8=64
 *  	以7位置的4作为最小值:最大的和:25   最小值4， 乘积：25*4=100
 *      所以最大指标126
 * @author reyco
 *
 */
public class Test2 {
	
}
