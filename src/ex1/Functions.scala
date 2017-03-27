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
    println(filter(List(4,4,4,3),greaterThan3))
    println(balance(List('(',')')))
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
    
  def filter(data: List[Int] ,f:  (Int => Boolean)):List[Int] = {
     def helper(data: List[Int],output: List[Int] ,f: (Int => Boolean)):List[Int] ={
         if(data.isEmpty) output
            else
                if(f(data.head)) helper(data.tail,output :+ data.head,f)
                else helper(data.tail,output,f)
          }
     helper(data,List(),f)   
  }
  // Проверява дали скобите в даден масив от символи са балансирани.
  // Коректно: (a)asda(b)(v) | (((a))) | ()(()асдасд)
  // Грешно: )() | ((д) | ((das) (d)( 
   def balance(chars: List[Char]): Boolean = {
    def balanced(chars: List[Char], open: Int): Boolean = {
        if (chars.isEmpty) open == 0
            else
                if (chars.head == '(') balanced(chars.tail,open+1)        
                else
                    if (chars.head == ')') open>0 && balanced(chars.tail,open-1)
                    else balanced(chars.tail,open)
    }      
    balanced(chars,0)
 }
  def map(chars: List[Char], f: Any) =  ???

  def toUpperCase(chars: List[Char]) = {
    def upperCase(char: Char) = ???
  
    ???
  }

  // Връща числото от триъгълника на Паскал отговарящо на съответния ред/колона
  def pascal(c: Int, r: Int): Int = ???
}
