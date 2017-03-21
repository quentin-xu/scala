package learning.lang

import scala.util.Random
import scala.math._
import scala.util.Sorting._
import java.util.TimeZone.getAvailableIDs
import java.awt.datatransfer._

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer

object ch3 {
    def exer1(n:Int)={List(1 to n: _*) map { x => Random.nextInt(n)}}
    
    def exer2[T](a:Array[T])={for(i <- 1 until (a.length, 2)){var tmp = a(i); a(i) = a(i-1); a(i-1) = tmp}}
    
    def exer3[T](a:Array[T])={
        //for可以使用for{}{} scala的yeild和python的不同，scala的yield更像是python的列表推导
        println(for(i <- 0 until a.length) yield{
            if(i == a.length - 1) a(i) 
            else if (i % 2 == 0) a(i + 1) 
            else a(i - 1)
        }.getClass())
    }
    
    def exer4(a:Array[Int])={a.filter(_ > 0) ++ a.filter(_ == 0) ++ a.filter(_ < 0)}
    
    def exer5[T](a:Array[T])(implicit num: Numeric[T])={num.toDouble(a.sum) / a.length}
    
    def exer9()={
    	var ids = getAvailableIDs() filter (_ startsWith("America/")) map (_ substring("America/".length()))
    	quickSort(ids)
    	ids
    }
    
    def exer10()={
        val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
        var a:Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
        a
    }
    
    def main(args: Array[String]): Unit = {
        println(exer3(Array(1,2,3)))
    }
}