package graphql.app.repository

import graphql.app.types.Character

val characters = List(
    Character("Alice", 25),
    Character("Bob", 30),
    Character("Charlie", 35),
)

def getCharacters: List[Character] = characters
def getCharacter(name: String): Option[Character] = characters.find(_.name == name)