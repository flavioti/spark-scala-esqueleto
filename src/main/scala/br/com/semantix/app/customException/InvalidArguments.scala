package br.com.semantix.app.customException

import br.com.semantix.app.structure.ExitCodeTable

/**
  * Classe customizada para tratamento de erro
  *
  * @param message Mensagem de erro a se exibida
  * @param cause   Classe do erro ocorrido
  */
sealed case class InvalidArguments(private val message: String = "",
                                   private val cause: Throwable = None.orNull)
  extends CommonException {
  val exitCode: Int = ExitCodeTable.INVALID_ARGUMENTS.value
}
