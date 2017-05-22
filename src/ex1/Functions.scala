package ex1

object Functions {

 def main(args: Array[String]) ={
    println("Hello Scala!")
    println(length(List(1,2,3,4,5)))
    var x = 1
    var xPlus = x + 1
    println(ifelse(true,xPlus,x))
    println(exists(List(1,2,3,4),greaterThan3))
    println(forall(List(),greaterThan3))
    println(filter(List(4,4,4,3),greaterThan3))
    println(balance(List('(',')')))
    println(toUpperCase(List('a','A','b','C')))
    println(pascal(1,5))
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
    if(data.isEmpty) false
    else if(length(data) == 1 && f(data.head)) true
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
   
  def map(chars: List[Char], f: (Char) => Any)={
    def helper(chars: List[Char], f: (Char) => Any, mapped: List[Any]): List[Any] = {
      if (chars.isEmpty) mapped;
      else {
        helper(chars.tail, f, mapped :+ f(chars.head));
      }
    }
    helper(chars, f, List());
  }
  
   def toUpperCase(chars: List[Char]): List[Char] = {
    def upperCase(chars: List[Char],uppercased: List[Char]): List[Char] ={
      if(chars.isEmpty) uppercased
      else
        if(chars.head.isUpper)
          upperCase(chars.tail,uppercased :+ chars.head)
          else
            upperCase(chars.tail,uppercased :+ chars.head.toUpper)
    }
    upperCase(chars,List())
   }

  // Връща числото от триъгълника на Паскал отговарящо на съответния ред/колона
  def pascal(c: Int, r: Int): Int = {
    def helper(c: Int, r: Int): Int = {   
      if(c == 0 || c == r) 1;
      else helper(c-1, r-1) + helper(c,r-1);
    }
    if(c>r || (c<0 || r<0)){
      return -1;
    }
   
    helper(c, r);
  }
}
