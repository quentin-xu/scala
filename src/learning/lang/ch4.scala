package learning.lang

import scala.collection.SortedMap
 

object ch4 {
    
    def exer1()={
        var m = Map(1->100.0,2->200.0,3->300.0);
        m.map((i) => (i._1, i._2*0.9))
    }
    
    def exer2()={
        import java.io.File;
        import java.util.Scanner;
        
        val in = new Scanner(new File("src/learning/ch3.scala"))
        var m = scala.collection.mutable.Map[String, Int]()
        //java iterator对象转成一个有TraversableLike特质的对象比较好
        while(in.hasNext()){
            var w = in.next()
            var v = m.getOrElse(w, 0) + 1
            m(w) = v
            
        }
        
        println(m)
    }
    
    def exer6()={
        println(scala.collection.immutable.ListMap("THURSDAY"->java.util.Calendar.THURSDAY,"MONDAY"->java.util.Calendar.MONDAY))
    }
    
    //这个maxby传人的函数不够直接，需要返回一个可以比较的对象，然后根据返回值排序。为什么不传人一个返回true和false的函数，根据返回值直接排序，类似c++的sort
    //max可以传人实现了ordering的对象来实现排序。总的来说没有c++的sort方便
    //模版参数不支持typedef也很蛋疼(模板参数支持type重新定义)
    def exer7()={
        import scala.collection.JavaConversions.propertiesAsScalaMap
        
        object Comp extends Ordering[Tuple2[String,String]]{
            def compare(a:Tuple2[String,String], b:Tuple2[String,String]) = a._1.length compare b._1.length
        }
        
        val l = java.lang.System.getProperties.max(new Ordering[Tuple2[String,String]]{
            def compare(a:Tuple2[String,String], b:Tuple2[String,String]) = a._1.length compare b._1.length
        })._1.length
/*        val l = java.lang.System.getProperties.maxBy((p)=>{
            println(p)
            p._1.length

        })._1.length
        */
        for((k,v)<-java.lang.System.getProperties){
            printf("%-"+l+"s| %s\n", k, v)
        }
        
        println(l)
    }
    
    
    def exer8(v:Array[Int])={
        (v.max, v.min)
    }
    
    def exer9(a:Array[Int], v:Int)={
        (a.count((i:Int)=> i < v), a.count((i:Int)=> i == v), a.count((i:Int)=> i > v))
    }
    
    def exer10()={
        "Hello".zip("Worl")
    }
    
    def main(args: Array[String]): Unit = {
    	println(exer10())
    }
}