package learning


object ch13 {
    //如果不加=号，表示函数的返回值是Unit
	def exer1(str: String)={
		import scala.collection.immutable.{TreeMap => Map}
		import scala.collection.mutable.Set

	    var m = new Map[Char, Set[Int]]()
	    
	    (0 until str.length()).foreach{
	        (i: Int) =>
	        if(m.contains(str.charAt(i))) m(str.charAt(i)) += i
	        else m = m + (str.charAt(i) -> Set())
	                    
	            //.add(i)
	    }
	    
	    println(m)
	    m
	}
	
	def exer3(){
	    println(List(0,1,3,4,0,0,0,2).filter { _ != 0 })
	}
	
	def exer5(){
	    //List(0).mkString(start, sep, end)
	    print(List(0,1,3,4,0,0,0,2).map(_.toString).reduceLeft(_+_))
	}
	
	//如果是一到几个参数的函数，可以用_*_这种格式传人，不用加()=>，但是如果没有参数，就不能这么定义，只能用换名调用
	def op(p: =>Int)={
	    p
	}
	
	def exer9(){
	    import scala.collection.mutable.{HashMap=>Map}
	    var m = Map('c'->10)
	    m('d') = m.getOrElse('d', 0) + 1
	}
	
	def main(args: Array[String]): Unit = {
	    //内部类无法返回给外部
		exer9
	}
}