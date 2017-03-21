package learning.lang

import scala.io.Source
import java.util.Scanner

object ch14 {
    def exer1() = {
        var other,matched=0
        
        import scala.sys.process._
        import java.io.File
        
        val fl = "find /Users/xuqi/Workspace/src -name *.java" !!
        
        //println(List(fl.split("\\s+"):_*))
        
        for(file <- fl.split("\\s+")){
            //val str = Source.fromFile(file).mkString
            val f = Source.fromFile(file)
            if(f.mkString.contains("case"))
            {
                for(l <- Source.fromFile(file).getLines())
                {
                    if(l.matches(".+[Ff]alls.+")) println(l)
                }
                //println(file)
            }
            
            
        }        
        
    }
    
    def exer3() = {
        Array(1,2) match {
            case Array(x, y, z @ _*) => Array(y, x) ++ z.toArray[Int]
        }
        
    }
   
    //def exer
    
    def main(args: Array[String]): Unit = {
    	println((1,2,3))
    }
}