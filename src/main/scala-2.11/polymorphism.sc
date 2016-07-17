trait List[+T] {
  def isEmpty:Boolean
  def head: T
  def tail: List[T]
}
class Cons[T](val head:T, val tail:List[T]) extends List[T]{
  def isEmpty=false
  //val head in the constructor provides the definition needed to
  //implement the trait
}
class Nil[T] extends List[T] {
  def isEmpty = true

  def head = throw new NoSuchElementException("Nil.head")

  def tail = throw new NoSuchElementException("Nil.tail")

}

def nth[T](n:Int, xs:List[T]):T={
  if (xs.isEmpty) throw new IndexOutOfBoundsException
  if(n==0) xs.head
  else nth(n-1,xs.tail)
}

def singleton[T](elem:T)=new Cons[T](elem,new Nil[T])
val i=singleton(1.0)
val s=singleton[String]("TEST")

val l=new Cons(1,i)

val list=new Cons(1,new Cons(2,new Cons(3,new Nil)))

nth(2,list)
nth(5,list)
