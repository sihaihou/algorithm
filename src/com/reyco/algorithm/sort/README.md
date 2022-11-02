#  排序算法
### 简单排序：[选择排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/SelectionSort.java)、[冒泡排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/BubbleSort.java)，[插入排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/InsertSort.java)
#### 选择排序： 找到arr[i..arr.length]范围上的最小值放在前面来。
#### 冒泡排序： 相邻的两个数i和i+1交换，交换后i向后移一位。
#### 插入排序： 保证arr[0...i]上有序。

### 高级排序：希尔排序：[shell排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/ShellSort.java)[归并排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/MergeSort.java)、[快速排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/QuickSort.java)
### 高级排序：希尔排序(插入排序优化版)、归并排序、快速排序
#### 希尔排序: 先分组,分组遍历有序；组的大小size=(size-1)/3,组的大小等于1排序后就整体有序了
#### 归并排序: 两部分有序,变量两边，谁小谁先放入
#### 快速排序: 先找到一个轴，小于轴的放左边，大于轴的放右边

桶排序: [计数排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/CountSort.java)、[基数排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/RadixSort.java)

[堆排序](https://github.com/sihaihou/algorithm/tree/master/src/com/reyco/algorithm/sort/HeapSort.java)

----------------------------------------------------------------------------------------------

#### 排序算法  &emsp;&emsp;         时间复杂度&emsp;&emsp;    空间复杂的&emsp;&emsp;  稳定
#### 选择排序：&emsp;&emsp;          O(N^2)&emsp;&emsp;&emsp;&emsp;        O(1)&emsp;&emsp;&emsp;&emsp;      无
#### 冒泡排序：&emsp;&emsp;          O(N^2)&emsp;&emsp;&emsp;&emsp;        O(1)&emsp;&emsp;&emsp;&emsp;      有
#### 插入排序：&emsp;&emsp;          O(N^2)&emsp;&emsp;&emsp;&emsp;        O(1)&emsp;&emsp;&emsp;&emsp;      有
#### 归并排序：&emsp;&emsp;          O(N*logN)&emsp;&emsp;      O(N)&emsp;&emsp;&emsp;&emsp;        有
#### 随机快排：&emsp;&emsp;          O(N*logN)&emsp;&emsp;      O(logN)&emsp;&emsp;&emsp;           无
#### 堆  排序：&emsp;&emsp;&emsp;    O(N*logN)&emsp;&emsp;     O(1)&emsp;&emsp;&emsp;&emsp;         无 
#### ----------------------------------
#### 计数排序：&emsp;&emsp;          O(N)&emsp;&emsp;&emsp;&emsp;           O(N+k)&emsp;&emsp;&emsp;&emsp;    有 
#### 基数排序：&emsp;&emsp;          O(N)&emsp;&emsp;&emsp;&emsp;           O(N)&emsp;&emsp;&emsp;&emsp;&emsp;      有 
