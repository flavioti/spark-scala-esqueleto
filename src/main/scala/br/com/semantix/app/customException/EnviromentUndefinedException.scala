package br.com.semantix.app.customException

import br.com.semantix.app.structure.ExitCodeTable

sealed case class EnviromentUndefinedException(private val message: String = "",
                                               private val cause: Throwable = None.orNull)
  extends Exception(message, cause) {
  val exitCode: Int = ExitCodeTable.ENVIROMENT_UNDEFINED.value
}
