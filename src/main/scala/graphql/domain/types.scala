package graphql.domain.types

opaque type Age = Int

object Age {
  def apply(age: Int): Option[Age] =
    if age >= 0 then Some(age) else None
  
  def unsafe(age: Int): Age = age
  extension (a: Age)
    def value: Int = a
}

opaque type Name = String
object Name {
  def apply(name: String): Option[Name] = Some(name)
  def unsafe(name: String): Name = name
  extension (n: Name)
    def value: String = n
}

case class Character(name: Name, age: Age)
