package learning


object ch11 {
	def + (lh:Int, rh:Int)={
	    lh.+(rh)
	}
	
	def ->(lh:Int, rh:Int)={
	    lh + rh
	}
	
	
	class op(var value: Int = 0) {
	    def + (that: op = null) = {
	        if (op == null) this
	        else new op(this.value + that.value)
	    }
	    def -> (that: op) = {
	        this.value = that.value
	        this
	    }
	    
	    override def toString() = {
	        this.value.toString()
	    }
	}
	
	class Table() {
	    import scala.collection.mutable.{MutableList=>List}
	    private var elements = List[List[String]]()
	    
	    elements += List()
	    
	    def | (ele: String) = {
	        elements.last += ele
	        this
	    }
	    
	    def || (ele: String) = {
	        elements += List()
	        elements.last += ele
	        this
	    }
	    
	    override def toString() = {
	        "<table>" + elements.map("<tr>" + _.map("<td>" + _ + "</td>").reduce((x, y) => x + y) + "</tr>").reduce((x, y) => x + y) + "</table>"
	    }
	}
	
	class BS {
	    private var value = 0L
	    def update(i: Int, b: Boolean) = {
	        if(b) value = value | (1L << i)
	    }
	    
	    override def toString() = {
	        var bs = new StringBuilder
	        63.to(0, -1).foreach((i) => if((value & (1L << i)) > 0) bs.append("1") else bs.append("0"))
	        bs.toString()
	    }
	}
	 
	object BS {
	    
	}
	
	class RF {
	    var path = "a"
	    var name = "b"
	    var postfix = "c"
	}
	
	object RF {
	    //优先使用unapply，其次才是unapplySeq
	    def unapply(in: String) = {
	        var eles = in.split("\\s+")
	        println(List(eles : _*))
	        Some((eles.lift(0).getOrElse(""), eles.lift(1).getOrElse(""), eles.lift(2).getOrElse("")))
	    }
	    
	    def unapplySeq(in: String) = {
	        println("unapplySeq")
	        Some(in.split("\\s+"))
	    }
	}
	
	
	//scala是否会把默认参数不对的方法转换成tuple
	def main(args: Array[String]): Unit = {
		var RF(p,n,f) = "a      		 b c"
		println(p->n,f)
	}
}