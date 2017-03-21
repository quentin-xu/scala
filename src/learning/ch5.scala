package learning

import scala.beans.BeanProperty
import scala.util.Random

object ch5 {
  class Counter {
      private var value = 0
      def increment()={value += 1}
      def current() = value
  }
  
  class BankAccount {
      var value = 0
      def deposit()={}
      def withdraw()={}
      //定义的时候没有括号，使用的时候也没有
      def balance = value
      //这也不是一个lambda表达式
      def balance_=(i:Int)={value = 100}
  }
  
  //主构造函数的参数没有var或者val，如果在方法里面被用到会创建，在其他属性初始化中用到不会创建(用debug模式验证过)
  //不带var val的主构造函数参数是private[this]
  class Time(hrs:Int, min:Int) {
      val m = hrs * 60 + min
      def before(other: Time) = {hrs}
  }
  
  class Student(@BeanProperty var id:Int) {
      
	  def a()={100}

      
      def this(s:String)={
          this(s.toInt)
          a()
      }
      
      @BeanProperty
      var name = ""
  }
  
  def main(args: Array[String]): Unit = {
      var s = new Student("99")
      s.getName()
      s.setId(100)
  }
}