package learning.lang

object ch8 {
    
	class BK(protected var bls : Double){
	    def dp(amount : Double){
	        bls += amount
	    }
	    def wd(amount : Double){
	        bls -= amount
	    }
	    
	    def balance = bls
	}
	
    //如果是子类可见的成员变量在子类中重新声明，需要用override描述符。如果不加var，用val或者都不用，则会提示错误，原因未知。
	class BK2(a : Double) extends BK(a){
	    
	    
	    override def dp(amount : Double){
	        bls -= 1
	        super.dp(amount)
	    }
	    
	    override def wd(amount : Double){
	        bls -= 1
	        super.wd(amount)
	    }
	}
	
	class BK3(a : Double) extends BK2(a){
	    protected var count = 0
	    def earn()={
	        bls += bls * 0.1
	        count = 0
	    }
	    
	    //无法调用父类的父类的访问
	    override def dp(amount : Double): Unit = {
	    	count += 1
	    	if (count < 4) {
	    		//super[BK].dp(amount)
	    	} else {
	    		super.dp(amount)
	    	    
	    	}
	    	
	    }
	    
	    override def wd(amount : Double): Unit = {
	    	count += 1
	        if (count < 4){
	            //super
	        } else {
	        	super.wd(amount)	            
	        }
	    }
	    
	}
	
	abstract trait BT{
	    def log:Unit
	}
	
	trait BT1 extends BT{
	    def log()={println("ok")}
	}
	
	trait BT2 extends BT{
	    override def log()={println("ok")}
	}
	
	def exer1(): Unit = {
	    var bk : BK = new BK2(200) with BT1 with BT2
	    bk.dp(100)
	    println(bk.balance)
	    bk.wd(30)
	    println(bk.balance)
	}
	
	def exer2(): Unit = {
	  
	}
	
	def exer4(): String = {
		abstract class Item {
		    val price: Double
		    val desc: String
		}
		
		class SimpleItem(val price: Double, val desc: String) extends Item{}
		
		//用val重写的访问最终生存的还是
		class Bundle(items: Item*) extends Item {
		    protected val itemList = List(items:_*)
		    val price = items.map(x => x.price).sum
		    val desc =items.map(x => x.desc).reduce((x,y)=> x + ";" + y)
		}
		
		new Bundle(new SimpleItem(99,"books"), new SimpleItem(103, "tools")).price.toString()
	}
	
	
	//主构造器也可以定义private和protected
	class Point /*private*/(val x: Int, val y: Int){}
	class LabeledPoint(val name: String, x: Int, y: Int) extends Point(x, y){}
	
	abstract class Shape {
	    def centerPoint: Point
	}
	
	class Rect(x:Point, y:Point) extends Shape{
	    def centerPoint = new Point((x.x + y.x) / 2, (x.y + y.y) / 2)
	}
	
	class Circle(x:Point, y:Int) extends Shape{
	    def centerPoint = x
	}
	
	def exer6={
	    println(new Circle(new Point(100,99), 80).asInstanceOf[Shape].centerPoint)
	}
	
	
	class A{
	    //如果a没有参数列表，则调用的时候不能有()，如果a有一个空的参数列表，则调用的时候可以选择a或者a()
	    //编译的时候有限制，但是编译后是同一个函数
	    def a={
	        println("ok")
	    }
	}
	
	def main(args: Array[String]): Unit = {
		println(exer6)
	}
}