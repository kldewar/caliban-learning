package graphql

import graphql.schema.queries
import caliban.{graphQL, GraphQL, RootResolver}
import caliban.schema.Schema.auto._
import caliban.schema.ArgBuilder.auto._
import zio._

object MainApp extends ZIOAppDefault {
  val query = """
    {
      characters {
        name
      }
    }
  """
  val api = graphQL(RootResolver(queries))
  def run = runGraphQL

  val runGraphQL = 
    for {
      interpreter <- api.interpreter
      result      <- interpreter.execute(query)
      _           <- ZIO.debug(result.data.toString)
    } yield ()
  }
