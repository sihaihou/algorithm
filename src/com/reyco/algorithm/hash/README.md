# 哈希表
### 设计布隆过滤器：
### &nbsp;&nbsp;&nbsp;&nbsp;  	n=样本量    p=失误率   m=hash函数个数   ln：以亿为底的对数
	
### &nbsp;&nbsp;&nbsp;&nbsp;  		  m = - ((n*p*ln)/(ln2)^2)
	
### &nbsp;&nbsp;&nbsp;&nbsp;  		  k = (m/n)*ln2
	
### &nbsp;&nbsp;&nbsp;&nbsp;  		  p真 = (1-e^(-（n*k真）/m真))^2 

	
### 一致性hash----虚拟节点来做负载均衡
 - 假设有三个服务器实例，每个服务器实例分配1024个虚拟节点；客户端保存三台服务器实例的虚拟节点，请求来了，对key进行hash计算，找到对应的虚拟节点保存到指定的服务器虚拟节点上，
   数据量多的时候可以保证每个虚拟节点保存的数据基本均等；
 - 当增加服务器时，也给它分配1024个虚拟节点，然后从其它服务器上获取指定数量的虚拟节点数据保存到当前服务器虚拟节点上，使其均等，代价很小;
 - 当减少服务器时，把自己的1024个虚拟节点数据均分给其它服务器的虚拟节点上，使其均等，代价很小。
&emsp;
&emsp;

44-40
#### 1，[数组中二进制位设置1和查询某一个的状态](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/hash/Test1.java)
#### 2，[大数据量：hash分流](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/hash/Test2.java)
#### 3，[有一个包含100一个URL的大文件，假设每个URL占用64B，请找出所有重复的URL.](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/hash/Test3.java)
#### 4，[硬盘上有40亿个无符号整数，现在只有100M内存，找出出现次数最多的这个数?](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/hash/Test4.java)
