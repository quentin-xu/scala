package learning

import scala.io.Source
import scala.io.BufferedSource

object ch9 {
	def exer1(): Unit = {
	    def vert(its: Iterator[String]):Unit={
	        if(its.hasNext){
	            var l = its.next
	            vert(its)
	            println(l)
	        }
	    }
		vert(Source.fromFile("src/learning/common.scala").getLines)
	}
	
	def exer2(): Unit = {
	    println(Source.fromFile("src/learning/common.scala").mkString.length())
		println(Source.fromFile("src/learning/common.scala").mkString.replaceAll("    ", "\t").length())
	}
	
	def exer3()={
	    //split是把regex作为切割符
	    println("""\d+(\.\d+){0,1}""".r.findAllIn(Source.fromFile("src/learning/common.scala").mkString).toList)
	}
	
	def main(args: Array[String]): Unit = {
		import sys.process._
		"ls -al" !
	}
}