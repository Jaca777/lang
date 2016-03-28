package  pl.jaca.lang.compiler.backend.`type`

/**
  * @author Jaca777
  *         Created 2016-03-27 at 15
  */
object TypeResolver {

  //parser checks type names, therefore it has to be valid
  def forName(name: String): Type = name match {
    case "int" => IntType
    case any => new ObjectType(name)
  }
}
