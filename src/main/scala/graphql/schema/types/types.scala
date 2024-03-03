package graphql.schema.types

case class Character(name: String, age: Int)

def getCharacters: List[Character] = Nil
def getCharacter(name: String): Option[Character] = None