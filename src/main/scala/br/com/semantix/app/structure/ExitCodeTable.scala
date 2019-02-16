package br.com.semantix.app.structure

object ExitCodeTable {

  val START: Int = 1000

  sealed trait EnumVal {
    val value: Int
  }

  case object INVALID_ARGUMENTS extends EnumVal {
    override val value: Int = START + 1
  }

  case object DATE_OUT_OF_BOUNDS extends EnumVal {
    override val value: Int = START + 2
  }

  case object DATA_NOT_FOUND extends EnumVal {
    override val value: Int = START + 3
  }

  case object ENVIROMENT_UNDEFINED extends EnumVal {
    override val value: Int = START + 3
  }

  val enviroment: Seq[EnumVal] = Seq(INVALID_ARGUMENTS, DATE_OUT_OF_BOUNDS, DATA_NOT_FOUND)

}
