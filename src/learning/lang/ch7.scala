package learning.lang

object ch7 {
  def exer7()={
      import java.util.{HashMap => JHM}
      import scala.collection.mutable.{HashMap => SHM}
      import scala.collection.JavaConversions
      
      
      var jhm = new JHM[Int,Int]
      jhm.put(100, 88)
      var shm:SHM[Int,Int] = SHM()
      shm ++= JavaConversions.mapAsScalaMap(jhm)
      
  }
  
  
  def exer()={
      
  }
  
  def main(args: Array[String]): Unit = {
	  println(exer7)
  }
}