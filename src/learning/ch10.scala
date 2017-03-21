package learning

object ch10 {
	/**
	 * @author xuqi
	 * 从反编译的代码看，特质是一个java的抽象类，同时提供方法或者成员的模版，混入特使即implement这个类
	 * 但是特质和类的区别到底是什么？
	 */
	trait RectLike {
		def translate(x:Int, y:Int): Unit
		def grow(x:Int, y:Int): Unit
	}
	
	
	import java.awt.Point
	class OP extends Point with scala.math.Ordered[Point]{
	    //不明白为什么这里没有使用＝会报错，下面的抽象类验证表面和父类的定义没有关系
	    //下面的RectLike代码验证也父类的定义没有关系
	    def compare(x: Point)={this.x - x.x}
	}
	
	class CLog {
	    val key = 3
	    def en(in: String)={
	        
	    }
	}
	
	def exer4(): Unit = {
		new CLog() {override val key = -3}.en("")
	}
	
	abstract class A {
	    def name: Unit
	}
	
	class B extends A{
	    def name()={}
	}
	
	
	def exer1(): Unit = {
		val egg:RectLike = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectLike{
			def translate(x:Int, y:Int){}
			def grow(x:Int, y:Int){}
		}
		println(egg.getClass)
		egg.translate(10, -10)
		egg.grow(10, 20)
	}
	
    class OrderedPoint extends java.awt.Point with scala.math.Ordered[Point]{
        def compare(that: Point)={
           if ((this.x < that.x) || (this.x == that.x && this.y < that.y)) -1 else 1
        }
    }
    
    class IIS extends java.io.InputStream with Iterable[Char]{
         // Members declared in java.io.InputStream
    	def read(): Int = {'a'.toInt}
  
    	// Members declared in scala.collection.IterableLike
    	def iterator: Iterator[Char] = {it}
    	
    	
    	private var it = new Iterator[Char] {
    	    def hasNext = {
    	        count -= 1
    	        count >= 0
    	    }
    	    def next() = read().toChar
    	    private var count = 10
    	}
    }
    
    def exer10 = {
        var iis = new IIS
		var sb = new StringBuilder
		iis.addString(sb, "|")
		println(sb.toString())
    }
	
	def main(args: Array[String]): Unit = {
		
	}
	
}