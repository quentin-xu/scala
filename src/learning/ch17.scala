package learning

object ch17 {
    case class Pair[T, S](private val t:T, private val s:S){
        def swap() = {
            Pair(s, t)
        }
        
        override def toString() = {
            "(" + t + "," + s + ")"
        }
    }
    
    case class Pair2[T](private var t:T, private var s:T){
        def swap() = {
            val tmp = s
            s = t
            t = tmp
            this
        }
        
        def rf[R >: T](nf: R) = {
            new Pair2[R](nf, s)
        }
        
        override def toString() = {
            "(" + t + "," + s + ")"
        }
    }
    
    def exer1() = {
    	println(Pair2(1, 2).swap())
    }
       
    
    def main(args: Array[String]): Unit = {
        var i:String = null
        //var rin = new RichInt()
    }
}