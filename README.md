# where_it

`where_it`是一个查看服务器各个建筑&机器坐标的`Fabric`服务端`MOD`它是用来解决生电服来新人不知道服务器到底有什么，都在那的问题。

下载MOD点[这里](https://github.com/zhenaiwork/where_it/tags)

[作者相关](https://space.bilibili.com/516691966?spm_id_from=333.1007.0.0)

## 使用相关

`where_it`是一个服务端`MOD`，对于客户端搭配  [Oh My MineCraft Client](https://github.com/plusls/oh-my-minecraft-client)  食用效果最佳。

服务端需要服主把`where_it.jar`放到`mods`文件夹里，之后在`config`文件夹里创建`config.yml`文件 (第一行要随便写点什么) ，需要注意的是 在这之后需要更新`fabricloader>=0.14.10`。

目前`where_it`只支持以下版本 (除`1.18.2`其他的都没有测试) ，需要其他的版本请自行编译。

`1.18.2`, `1.17.1` ,`1.16.5`, `1.15.2`, `1.14.4`

## 交互方式

`where_it`是通过命令的方式进行交互，其中所有玩家都可以使用的有`/where`，`op`玩家在此之上还有`/make`,`/remove`。

## 指令的具体介绍

`/where`查看该指令的`help`信息

`/where it name`产看于`name`相关的 机器&建筑 坐标（中文需要用引号包裹）

`/where it_all`查看服务器所有 建筑&机器 坐标

权限要求：无



`/make`查看该指令的`help`信息

`/make "name" dimension X Z`在最后添加坐标`X Z`（dimension为维度，`00`主世界，`01`末地，`-1`下界）

如果为主世界坐标它会自动添加对应的下界坐标

权限要求：`op`



`/remove`查看该指令的`help`信息

`/remove last`删除最后一个 机器/建筑 坐标

权限要求：`op`
