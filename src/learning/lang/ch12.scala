package learning.lang

object ch12 {
    
    def exer2(): Unit = {
    	var l = List(99,11,33,88,10)
    	println(l.reduceLeft((x, y) => x max y ))
    }
    
    def exer4(n: Int): Unit = {
        println((1 to n).foldLeft(1)((x, y) => x * y))
    }
    
    def exer5(op: (Int) => Int, seq: Seq[Int]) = {
        seq.map(op).max
    }
    
    def exer6(op: (Int) => Int, seq: Seq[Int]) = {
        seq.maxBy(op)
    }
    
    def exer7() = {
        def toPair(op: (Int, Int) => Int) = {
            (p: Tuple2[Int, Int]) => {op(p._1, p._2)}
        }
        
        //_出现第几次表示第几个参数吗？
        println(toPair(_ * _)(5->2))
    }
    
    def exer8() = {
        var a = Array("asb","qwera")
        var b = Array("ASB","QWER")
        
        //"".equalsIgnoreCase(anotherString)
        
        println(a.corresponds(b)(_.length == _.length))
    }
    
    class A(val value:Int) {
        def isSame[B<:String](that: B, p: (A, String)=> Boolean) = {
            p(this, that)
        }
    }
    
    def exer9() = {
        var a = new A(11)
        //不做柯里化没有办法推断出B,因为要结合第二个参数同时推断出B的类型
        println(a.isSame("asdf1111111", _.value == _.length()))
    }
    
    def exer10() = {
    	//换名调用在匿名函数里面无法使用，应该是没办法判断是立即执行还是延迟求值
//        def until(cond: => Boolean): (() => Unit) => Unit = {
//            (body:() => Unit) => {
//                if(!cond){
//                	body()
//                	until(cond)(body)
//                }
//            }
//        }
        
        //用scala的carrying方法会方便很多，要不然写个carrying方法很费脑子，还没办法使用换名调用
        //换名调用起到了一个延迟求值得效果
        def until(cond: => Boolean)(body: => Unit){
            if(!cond){
                body
                until(cond) (body)
            }
        }
        
        var a = 10
        
        until(a == 0){
            a -= 1
            println(a)
        }
    }
    
    
    def main(args: Array[String]): Unit = {
        exer10()
    }
}