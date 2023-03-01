package simple

import mybatis.scala.support.session.SqlSessionManager
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.h2.tools.RunScript
import simple.mapper.PersonMapper

import java.io.FileReader

object App:

  private val sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder
  private val config = Resources.getResourceAsStream("mybatis-config.xml")
  private val sqlSessionFactory = sqlSessionFactoryBuilder.build(config)
  private val sqlSessionManager = new SqlSessionManager(sqlSessionFactory)

  def main(args: Array[String]): Unit =
    sqlSessionManager.managed().use { ss =>
      RunScript.execute(ss.getConnection, new FileReader("./simple/src/main/resources/schema.sql"))
      RunScript.execute(ss.getConnection, new FileReader("./simple/src/main/resources/data.sql"))
    }

    sqlSessionManager.readOnly().use { ss =>
      val mapper = ss.getMapper(classOf[PersonMapper])
      println("selectAll: " + mapper.selectAll())
      println("selectAllName: " + mapper.selectAllName())
      println("selectOne(0): " + mapper.selectOne(0))
      println("selectOne(1): " + mapper.selectOne(1))
      println("selectOne(2): " + mapper.selectOne(2))
      println("selectOne(3): " + mapper.selectOne(3))
      println("selectOne(4): " + mapper.selectOne(4))
    }
