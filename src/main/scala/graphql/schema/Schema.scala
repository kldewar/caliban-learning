package graphql.schema

import graphql.schema.types.{Character, getCharacter, getCharacters}

case class CharacterName(name: String)
case class Queries(characters: List[Character], character: CharacterName => Option[Character])

val queries = Queries(getCharacters, args => getCharacter(args.name))
