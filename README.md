#jshow ace template base project
===

##说明
这是一个基础工程，主要是一些基础功能的集合。基于bootstrap aceadmin 前端UI，可以作为常用的普通中后台前后端代码自动生成工程使用。前端UI采用aceadmin + bootstrap.

##主要技术栈
 springmvc + mybatis + aceadmin + jQuery
 
## molicode替换表达式
 
 如下：新建一个usercenter的项目， maven的artifact前缀为：usercenter-***
 包路径以： com.shareyi.user.center 开始；
 
 ### 替换表达式（用于文本内容替换）
 ```
com.shareyi.jshow=com.shareyi.user.center
jshow=usercenter
 ```
 
 ### 目录转换表达式（用于包路径转换）
 下面的表达式实现了包路径延长，按自己的需要做替换即可。
 ```
 com/shareyi/jshow=com/shareyi/user/center
 ```
