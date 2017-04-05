sealed trait Shape
case class Triangle(a: Int, b: Int, c: Int, h: Int) extends Shape // h represent the height against the longest side of the triangle
case class Rectangle(a: Int, b: Int) extends Shape
case class Trapezoid(a: Int, b: Int, h: Int) extends Shape
case class Cube() extends Shape

class Architect {

   def max(xs: List[Int]): Option[Int] = {
      def iter(xs: List[Int],currentMax:Int): Option[Int] = {
        if(xs.isEmpty) Some(currentMax) 
        else {
          iter(xs.tail,if (xs.head > currentMax) xs.head else currentMax);
        }
      }
      if(xs.isEmpty) None
      else iter(xs.tail, xs.head);
    
  }

  def triangleType(t: Triangle): String =  {
    if(!isTriangle(t)) return "not";
    
    if (t.a != t.b && t.b != t.c && t.a!=t.c){
      val aSquare = t.a*t.a;
      val bSquare = t.b*t.b;
      val cSquare = t.c*t.c;
  
      if((aSquare + bSquare == cSquare)
          || (aSquare + cSquare == bSquare) 
          || (bSquare + cSquare == aSquare)) "rectangular" else "random";
               
    }else if(t.a == t.b && t.b == t.c) "equilateral";
     else "isosceles";
  }

  def area(s: Shape): Double = s match{
    case t:Triangle => triangleType(t) match{
      case "rectangular" => max(List(t.a,t.b,t.c)).get match{
        case t.a => (t.b * t.c) / 2;
        case t.b => (t.a * t.c) / 2;
        case t.c => (t.a * t.b) / 2;
      }
      case "not" => -2;
      case _ => (max(List(t.a,t.b,t.c)).get * t.h) .toDouble / 2;
    }
    case Rectangle(a,b) => a*b;
    case Trapezoid(a,b,h) => (a + b).toDouble * h / 2;
    case Cube() =>  -1;
  }
 
  def findRectangulars(shapes: List[Shape]): Int = {
    def iter(shapes: List[Shape], n: Int): Int = {
      if(shapes.isEmpty) n;
      else iter(shapes.tail,shapes.head match{
        case t:Triangle => if(triangleType(t).equals("rectangular")) n+1 else n;
        case s:Shape => n; 
      });       
    }
    iter(shapes, 0);
  }

  def isTriangle(t:Triangle)={
    if(t.a + t.b > t.c && t.b + t.c > t.a && t.a + t.c > t.b) true else false;
  }
}

object hwTwo {
     def main(args: Array[String]) = {
     var architect = new Architect
     var triang = Triangle(3,4,5,4)
     var rect = Rectangle(4,5)
     println(architect.isTriangle(Triangle(10,500,20,4)))
     println(architect.triangleType(Triangle(5,5,6,7)))
     println(architect.triangleType(triang))
     println(architect.findRectangulars(List(triang,rect)))
     println(architect.area(rect))
  }
}