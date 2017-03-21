package learning

import java.io.Console

object ch6 {
    
    def exer2()={
    	class UnitConv{    	    
    	}
    	
    	object AConvB extends UnitConv {
    	    def aconvb(){}
    	}
    }
    
    class point(private var v:Int) extends java.awt.Point {
            
        }
    
    def exer4()={
        
        class point(private var v:Int) extends java.awt.Point {
            
        }
        
        class empty(){}
        
        //同名object 和 class除了名字没什么关联，可以extends不同的类，除了访问各自的私有特性(但是必须在同一个文件作用域中)
        object point extends empty {
            def apply(x:Int, y:Int) {
                new point(99).v =100
            }
        }
        
        point(100,99)
        
    }
    
    def exer6(){
        //对象有作用域的限制
        object CardEnum extends Enumeration {
            val a,b,c = Value
            val e = Value("e")
        }
        
        //type CardEnum = CardEnum.Value
        
        var x = CardEnum.e
        x    
    }
    
    def main(args: Array[String]): Unit = {
        println(exer6().getClass())
    }
}