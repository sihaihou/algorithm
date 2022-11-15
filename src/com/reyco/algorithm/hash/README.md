# 哈希表
### 设计布隆过滤器：
### &nbsp;&nbsp;&nbsp;&nbsp;  	n=样本量    p=失误率   m=hash函数个数   ln：以亿为底的对数
	
### &nbsp;&nbsp;&nbsp;&nbsp;  		  m = - ((n*p*ln)/(ln2)^2)
	
### &nbsp;&nbsp;&nbsp;&nbsp;  		  k = (m/n)*ln2
	
### &nbsp;&nbsp;&nbsp;&nbsp;  		  p真 = (1-e^(-（n*k真）/m真))^2 

	
### 一致性hash----虚拟节点来做负载均衡
&emsp;
&emsp;

44
#### 1，[数组中二进制位设置1和查询某一个的状态](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/hash/Test1.java)
#### 2，[大数据量：hash分流](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/hash/Test2.java)
#### 3，[有一个包含100一个URL的大文件，假设每个URL占用64B，请找出所有重复的URL.](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/hash/Test3.java)
