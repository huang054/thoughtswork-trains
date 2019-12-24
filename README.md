​                                                          

# Trains

## 需求简介

   >
   >
   >The local commuter railroad services a number of towns in Kiwiland.  Because of monetary concerns, all of the tracks are 'one-way.'  That is, a route from Kaitaia to Invercargill does not imply the existence of a route from Invercargill to Kaitaia.  In fact, even if both of these routes do happen to exist, they are distinct and are not necessarily the same distance!
   >
   > 
   >
   >The purpose of this problem is to help the railroad provide its customers with information about the routes.  In particular, you will compute the distance along a certain route, the number of different routes between two towns, and the shortest route between two towns.
   >
   > 
   >
   >***Input***:  A directed graph where a node represents a town and an edge represents a route between two towns.  The weighting of the edge represents the distance between the two towns.  A given route will never appear more than once, and for a given route, the starting and ending town will not be the same town.
   >
   > 
   >
   >***Output***: For test input 1 through 5, if no such route exists, output 'NO SUCH ROUTE'.  Otherwise, follow the route as given; do not make any extra stops!  For example, the first problem means to start at city A, then travel directly to city B (a distance of 5), then directly to city C (a distance of 4).
   >
   >1. The distance of the route A-B-C.
   >2. The distance of the route A-D.
   >3. The distance of the route A-D-C.
   >4. The distance of the route A-E-B-C-D.
   >5. The distance of the route A-E-D.
   >6. The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
   >7. The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
   >8. The length of the shortest route (in terms of distance to travel) from A to C.
   >9. The length of the shortest route (in terms of distance to travel) from B to B.
   >10. The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.
   >
   > 
   >
   >***Test Input:***
   >
   >For the test input, the towns are named using the first few letters of the alphabet from A to D.  A route between two towns (A to B) with a distance of 5 is represented as AB5.
   >
   >Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
   >
   >Expected Output:
   >
   >Output #1: 9
   >
   >Output #2: 5
   >
   >Output #3: 13
   >
   >Output #4: 22
   >
   >Output #5: NO SUCH ROUTE
   >
   >Output #6: 2
   >
   >Output #7: 3
   >
   >Output #8: 9
   >
   >Output #9: 9
   >
   >Output #10: 7

## 项目简介

​     model 数据模型

​     distance 业务接口及其实现

​     process 业务执行

## 项目设计

###      定义数据模型

####             Point

​                    点的数据模型比如`A`

####             Route

​                    点与点的路线`pointLeft`与`pointRight`及其距离`length`

###      定义DistanceInterface接口为业务逻辑定义

####             pointProcess

​                     方法为文本转换成数组类型 比如 `A-B` 处理成`Point[]`

####             compute

​                     方法为具体业务处理,不同的实现类根据业务需求重写`compute`方法实现自己的业务

###       AbstractProcess抽象类

​               此抽象类对各个实现类的公共部分进行抽取

###       具体实现类

####              FixedDistance                 

​                      固定距离实现类 比如 `A-B-C`

####              LimitStopsDistance        

​                      限制步数实现类 比如 `A-C` 为`A`点到`C`点，`imitNumber` 为限制步数数值

####              FixedStopsDistance      

​                      固定步数实现类 比如 `C-C`  为`C`点到`C`点，`fixedNumber`为固定步数数值

####              MinLengthDistance       

​                      最短距离实现类 比如`A-C` 为`A`点到`C`点 ，计算出最短距离

####              NumberDistance           

​                      路径条数实现类 比如 `A-D` 为`A`点到`D`点，`limitLength` 为最大距离数值

###       执行类

####             DistanceProcess执行类

​                    `compute`执行方法，有参构造器传进实现类

## 文件数据读取

###  FileUtil

​      `readFileContent(String fileName)`读取需要数据集合

​      `readFileContent(String fileName, InAndOutRead inAndOutRead)`读取输入的测试数据

​      `resources`Mark directory as `Resources Root`

###       测试类RouteTest

####             fixedDistanceTest

​                    固定步数测试方法

####             LimitStopsDistanceTest         

​                    限制步数测试方法

####             FixedStopsDistanceTest          

​                    固定步数测试方法

####             MinLengthDistanceTest          

​                    最短距离测试方法

####             NumberDistance                       

​                    路径条数测试方法

#### outPut

​                   从文件读取测试数据并且经过业务处理输出对应的输出数据