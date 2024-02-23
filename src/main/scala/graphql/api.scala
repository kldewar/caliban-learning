package graphql

import graphql.schema.queries
import caliban.{graphQL, RootResolver}
import caliban.schema.Schema.auto._
import caliban.schema.ArgBuilder.auto._

@main
def Main(args: String*): Unit =
  val api = graphQL(RootResolver(queries))
  print(api.render)
