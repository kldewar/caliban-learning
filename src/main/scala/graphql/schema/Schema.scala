package graphql.schema

import graphql.app.types.{Character}
import graphql.app.repository.{getCharacters, getCharacter}

case class CharacterName(name: String)
case class Queries(characters: List[Character], character: CharacterName => Option[Character])

val queries = Queries(getCharacters, args => getCharacter(args.name))
