package ex1

object Functions {

 def main(args: Array[String]) ={
    println("Hello Scala!")
    println(length(List(1,2,3,4,5)))
    var x = 1
    var xPlus = x + 1
    println(ifelse(true,xPlus,x))
    println(exists(List(1,2,3,4),greaterThan3))
    println(forall(List(4,4,4,4),greaterThan3))
    println(filter(List(4,3,3,3),List(),greaterThan3))
  }
  def length(data: List[Int], lengthCount: Int = 0): Int =
    if(data.isEmpty) lengthCount
    else length(data.tail, lengthCount+1)
  
  def ifelse(cond: Boolean, onTrue: => Int, onFalse: => Int)=
    if(cond)
      onTrue
    else onFalse
    
  def exists(data: List[Int], f: (Int => Boolean)): Boolean =
    if(data.isEmpty) false
    else
        if(f(data.head)) true
        else exists(data.tail,f)
  
  def greaterThan3(x: Int): Boolean = x>3
  
  def forall(data: List[Int], f: (Int => Boolean)): Boolean =
    if(length(data) == 1 && f(data.head)) true
    else
        if(f(data.head)) forall(data.tail,f)
        else false
    
  def filter(data: List[Int],output: List[Int] ,f: (Int => Boolean)):List[Int] =
    if(data.isEmpty) output
    else
      if(f(data.head)) output :+ data.head
      else
      filter(data.tail,output,f)
    
  // Проверява дали скобите в даден масив от символи са балансирани.
  // Коректно: (a)asda(b)(v) | (((a))) | ()(()асдасд)
  // Грешно: )() | ((д) | ((das) (d)( 
  def balance(chars: List[Char]): Boolean = ???

  def map(chars: List[Char], f: Any) =  ???

  def toUpperCase(chars: List[Char]) = {
    def upperCase(char: Char) = ???
  
    ???
  }

  // Връща числото от триъгълника на Паскал отговарящо на съответния ред/колона
  def pascal(c: Int, r: Int): Int = ???
}
