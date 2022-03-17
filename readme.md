# 力扣刷题总结：
##1.数组部分：
###1.数组的遍历：
+ 三个数的最大乘积(628)：
记得**Arrays.sort()**这个函数的使用，该算法采用快速排序，时间复杂度O(nlogn).默认升序。
###2.统计数组中的元素:
+ 645:错误的集合：Java哈希表 HashMap.getOrDefault(Object key, V defaultValue) Java8新特性，如果哈希表中有这个Key则获取这个值，如果没有则初始化Key的值为defaultValue.
 c语言有一个贼强的数据结构开源库，uthash库,[开源地址点击这里](https://github.com/troydhanson/uthash)。
 + 41:缺失的第一个正数(请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。),这种类型的题有一种很巧妙的解决方法，就是将数组本身作为一种哈希表，以此题为例，其思路就是首先将数组中<0的数全部置为大于N
 的一个常数，然后遍历该数组，将 n>x>0的数对应序号的数组取反，另一种类型的此题解法是在对应数组的数字上加上数组长度，取出时
 取余，不过此法只适用于数组中的数字范围是0-nums.length。
 + 189:**旋转数组**:对于将数组向后或向前移动多少位的问题可以巧妙的将其看作对数组进行转置操作所得。
 + 498:**遍历数组**:对数组进行遍历时，需要仔细分步的考虑情况，特殊情况下可以使用一个额外的标志数组来
 表示某元素是否被访问过。
 + 48:**旋转图像**:对于数组旋转问题，当题目要求空间复杂度为O(1)时，有两种解决方式，一种是一个元素一个元素的进行移动，
 另一种方式是对将数组的旋转动作分解为转置操作，列如旋转操作可分解为先将其通过水平轴翻转，
 再根据主对角线翻转。
 + 303:**区域和检索**:计算数据的区域和的时候，可采用前缀和的方式。对于二维区域和问题，可分解为
 一维区域和问题进行解决，也可采用二维区域和的方式。
 
 ##2.字符串部分：
 ###字符串的反转：
 + 151:**翻转字符串里的单词**:对于字符串的分割问题，可以采用自己编写函数的方式，也可以采用自带的api，**要注意在字符串中，空白的字符好像有许多个**，
 自己编写函数的时候要注意。调用api时，**Arrays.asList(s.split("\\s+"))**表示将字符串按空白字符分割为数组。
 + 451:**字符串里的字符按照出现的频率降序排列：**此题用到了Collections.sort这个工具类，是用来对List类型进行排序的，
 以及java的Lambda 表达式，其示例为：(a, b) -> (int)map.get(b) - (int)map.get(a)；
 + 467:**环绕字符串中唯一的子字符串**:此题需要注意的地方在于**以某字符结尾的连续子串的长度，就等于以该字符结尾的相等子串的个数**
 ### 数字与字符串间转换
 + 8:**罗马数字转整数**：对于字符串的处理，可以采用状态机的概念，将对字符串的处理分为几个状态来进行处理比较方便。
### 子序列
 + 524:一种匹配子序列的代码，感觉写得比较简洁,双指针：
~~~java
while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
~~~
### 高精度运算
+ 67 ：**二进制求和**：这题看题解get到一个点，Java中java.math.BigInteger就是用来表示任意大小的整数。BigInteger内部用一个int[]数组来模拟一个非常大的整数：
```java
public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
        }
```
+ **高精度运算**:306,逻辑比较麻烦，可以看作一道综合题。

### 字符串变换：
+ 68：**文本左右对齐**：有点麻烦，后面有时间可以再做一下

### 字符串匹配:
+ 28:**实现 strStr()**：此题采用Knuth-Morris-Pratt 算法较为适宜，偷懒直接调用API，有空实现一下。KMP 算法是一个快速查找匹配串的算法，它的作用其实就是本题问题：如何快速在「原字符串」中找到「匹配字符串」。
+ 686:**重复叠加字符串匹配**:此题也是KMP,tnnd还是得好好学一下

### 中心拓展法:
+ 647:回文子串:中心拓展法可以用来求取回文子串，没想到一遍过，哈哈哈

## 3.数与位
### 数字的位操作：
+ 564：**寻找最近的回文数**：情况有点复杂，可以锻炼下思维能力，cv了，有空可以再重新写写。
+ 233:**给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数**:hard题，自己写循环超时，官解偏数学推导一点。
+ 400：**第N位数字**:此题暴力求解超时了，这题更像一道找规律的题，有点麻烦，难想到，有时间可以再推导一下
+ 29:**两数相除：**此题通过二分查找和二进制乘法来解决，值得一看，今日看不动了，有空仔细看看
+ 
