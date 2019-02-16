package br.com.semantix.app.structure

object EnviromentEnum {

  sealed trait EnumVal

  case object Desenvolvimento extends EnumVal

  case object Homologacao extends EnumVal

  case object Producao extends EnumVal

  val enviroment: Seq[EnumVal] = Seq(Desenvolvimento, Homologacao, Producao)

}
