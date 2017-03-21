package ex1

object Functions {

  // Връща големината на масив (без да ползва data.length!!!)
  def length(data: List[Int]) = ??? 

  // Ако cond е true връща onTrue
  def ifelse(cond: Boolean, onTrue: Int, onFalse: Int) = ???

  // Проверява дали скобите в даден масив от символи са балансирани.
  // Коректно: (a)asda(b)(v) | (((a))) | ()(()асдасд)
  // Грешно: )() | ((д) | ((das) (d)( 
  def balance(chars: List[Char]): Boolean = ???

  def map(chars: List[Char], f: Any) =  ???

  def toUpperCase(chars: List[Char]) = {
    def upperCase(char: Char) = ???
  
    ???
  }

  // Проверява дали съществува елемент отговарящ на f
  def exists(data: List[Int], f: Any) = ???

  // Връща масив съдържащ само елементите отговарящи на f
  def filter(data: List[Int], f: Any) = ???

  // Проверява дали всички елементи отговарят на f
  def forall(data: List[Int], f: Any) = ???

  // Връща числото от триъгълника на Паскал отговарящо на съответния ред/колона
  def pascal(c: Int, r: Int): Int = ???
}
