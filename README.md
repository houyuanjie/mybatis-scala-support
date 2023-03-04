# Mybatis Scala Support

为 Mybatis 提供 Scala 3 支持

> Scala 2.12 / 2.13 用户请使用官方维护的 [mybatis-scala](https://github.com/mybatis/scala)

简体中文 | [English](./README_EN.md)

## core

[core](./core) 项目借鉴了官方的 [mybatis-scala](https://github.com/mybatis/scala) 项目, 改用纯 Java 语言实现:

- 兼容 Scala 2.13 集合 API (scala.collection.mutable.{Seq, Set, Map})
- Option 类型处理器
- SqlSessionManager 工具类

> 使用 Java 实现可以避免 Scala 版本之间的二进制不兼容问题, 使得 core 项目可以在 Scala 2.13 / 3.x 版本通用

## config (WIP)

[config](./config) 项目借助 Scala
3 [Context Functions](https://docs.scala-lang.org/scala3/reference/contextual/context-functions.html)
实现一套用来构建 Mybatis 全局配置对象 Configuration 的 DSL

## 声明

本项目的源代码并非独立创作, 其中大量地借鉴了已有的 [mybatis-scala](https://github.com/mybatis/scala) 项目

向 Mybatis 团队致敬!
