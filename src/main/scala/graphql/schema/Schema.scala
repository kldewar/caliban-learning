package graphql.schema

// types
case class Character(name: String, age: Int)

def getCharacters: List[Character] = Nil
def getCharacter(name: String): Option[Character] = None 


// schema
case class CharacterName(name: String)
case class Queries(characters: List[Character], character: CharacterName => Option[Character])


// resolver
val queries = Queries(getCharacters, args => getCharacter(args.name))
