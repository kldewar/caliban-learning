package graphql.app.repository

import graphql.domain.types.{Character, Age, Name}

private var characters = List(
  Character(Name.unsafe("Alice"), Age.unsafe(25)),
  Character(Name.unsafe("Bob"), Age.unsafe(30)),
  Character(Name.unsafe("Charlie"), Age.unsafe(35))
)

def getCharacters: List[Character] = characters
def getCharacter(nameInput: String): Option[Character] =
  Name(nameInput).flatMap { name =>
    characters.find(_.name == name)
  }
def createCharacter(nameInput: String, ageInput: Int): Option[Character] = {
  val result =
    for
      name <- Name(nameInput)
      age  <- Age(ageInput)
    yield Character(name, age)

  result.foreach { character =>
    characters = characters :+ character
  }

  result
}
