package graphql.schema

// types
case class Character(name: String, age: Int)



// schema
case class CharacterName(name: String)
case class Queries(characters: List[Character], character: CharacterName => Option[Character])


// resolvers
def getCharacters: List[Character] = Nil
def getCharacter(name: String): Option[Character] = None

val queries = Queries(getCharacters, args => getCharacter(args.name))
