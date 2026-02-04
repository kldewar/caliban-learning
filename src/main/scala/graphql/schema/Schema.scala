package graphql.schema

import graphql.app.repository.{getCharacters, getCharacter}
import graphql.domain.types.{Character, Name}

case class CharacterGQL(
  name: String,
  age: Int
)

object CharacterGQL {
  def fromDomain(c: Character): CharacterGQL =
    CharacterGQL(
      name = c.name.value,
      age  = c.age.value
    )
}

case class CharacterName(name: String)
case class Queries(
    characters: List[CharacterGQL],
    character: CharacterName => Option[CharacterGQL]
)

val queries =
  Queries(
    getCharacters.map(CharacterGQL.fromDomain),
    args => getCharacter(args.name).map(CharacterGQL.fromDomain)
  )
