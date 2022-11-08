# 图
### 图结构的表示：
#### 图：A指向D、A指向C、B指向C、B指向D、C指向A、C指向B、D指向B、D指向A
###### 1,邻接表法
		A:C、D
		B:C、D
		C:A、B
		D:A、B
###### 2,邻接矩阵法
	    A B C D
	  A 
	  B
	  C
	  D
	  
#### 图的宽度优先遍历：
	1,利用队列实现;
	2,从源节点开始依次按照宽度进队列，然后弹出；
	3，每弹出一个节点，把该节点所有没有进队列的邻接点放入队列；
	4，直到队列变空。

#### 图的深度优先遍历：
	1,利用栈实现;
	2,从源节点开始把节点按照深度放入栈，然后弹出；
	3，每弹出一个节点，把该节点下一个没进过栈的邻接点放入栈；
	4，直到栈变空。

### 图的算法：
#### 	1.拓扑排序(图必须：无环有向图)：先找到入度为0的，并把它的nexts节点的入度减掉1，继续寻找入度为0的  
		需求:如jar编译，没有依赖的才能先编译
#### 	2.最小生成树之Kruskal(K算法):从最小的边开始连，如果边的两个点不在一个集合，就要这条边，并他这两个点放入一个集合！直到所有的边都遍历完！
	           需求:如再图中连通所有的点，并且要求使用最小的代价?
#### 	3.最小生成树之Prim(P算法)：随便找一个点，如果没有连通，则解锁它所有的边，在解锁的边中选择最小边，并解锁最小边的to点的所有边，再在所有解锁的边中选择最小的边，一直这样下去,
#### 	4.dijkstra算法(单元最小路径)：求从起始点到所有点的最小距离?  
	  
	  
	  
## Graph: 基础图的类
## Test： 给你一个图转换成我们的基础图类
#### 1，[图宽度优先遍历](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/graph/Test1.java)---用队列
#### 2，[深宽度优先遍历](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/graph/Test2.java)---用栈
#### 3，[拓扑排序](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/graph/Test3.java)---无环有向图
#### 4，[Kruska算法](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/graph/Test4.java)  ---生成最小生成数 ---->从最小边开始,只要不形成环--就是最小值
#### 5，[prim算法](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/graph/Test5.java)  ---生成最小生成树---->随便找一个点，如果没有连通，则解锁它所有的边，在解锁的边中选择最小边，并解锁最小边的to点的所有边，再在所有解锁的边中选择最小的边，一直这样下去;
#### 6，[dijkstra算法](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/graph/Test6.java)---求单元最小路径
#### 7，[dijkstra优化算法](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/graph/Test7.java)----小根堆改进后的dijkstra算法
#### 8，[请返回长度为N的boolean型数组res，res[i]代表第i个加油站是不是良好出发点.](https://github.com/sihaihou/algorithm/blob/master/src/com/reyco/algorithm/graph/Test8.java)
