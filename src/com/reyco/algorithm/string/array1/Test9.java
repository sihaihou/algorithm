package com.reyco.algorithm.string.array1;

/**
 * 63
 * 给定一个字符串str,如果可以在str的任意位置添加字符，请返回在添加字符最少的情况下，让str整体都是回文字符串的一个结果。
 * 例： 1，str="aba"， str本身就是回文字符串，所以不用加，返回0.
 *    2，str="ab",可以在a的前面加一个b:"bab", 或者在b后面加一个a:"aba"， 则整体就是回文字符串了。返回1
 *    
 * 答：范围上的尝试模型：左下半区无效
 *     范围上尝试模型，dp[i...j]表示str[i...j]范围上最少添加几个字符，使整个字符串串是回文子串。
 *     求的点就是dp[0][str.length-1]
 *     
 *    1）先搞定(i+1，j),在搞定i位置的字符：dp[i+1][j]+1	a123c21-->a123c321-->a123c321a
 *    2）先搞定(i,j-1),在搞定j位置的字符：dp[i][j-1]+1	123c21a-->123c321a-->a123c321a
 *    3）如果i位置等于j位置的字符，只需要搞定(i+1,j-1): dp[i+1][j-1]  a123c21a-->a123c321a
 * @author reyco
 *
 */
public class Test9 {

}
