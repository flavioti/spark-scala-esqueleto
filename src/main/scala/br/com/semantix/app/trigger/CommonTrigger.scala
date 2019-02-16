package br.com.semantix.app.trigger

import br.com.semantix.app.core.{CommonBase, CommonLogger}

trait CommonTrigger extends App with CommonBase with CommonLogger {

  def run(args: Array[String]): Unit = {

    Log.info("Exibindo mensagens padrão")
    standardLog()

    Log.info("Disparando pré-processo")
    beforeProcess()

    Log.info("Disparando processo")
    triggerProcess()

    Log.info("Disparando pós-processo")
    afterProcess()

  }

  def standardLog(): Unit = {

    val version: String = getClass.getPackage.getImplementationVersion
    Log.info(s"Versão: $version")

  }

  /**
    * Disparado antes do processo principal, útil para configuração
    */
  def beforeProcess(): Unit

  /**
    * Processo principal, sistema deve ser codificado aqui
    */
  def triggerProcess(): Unit

  /**
    * Disparado depois do processo principal, útil para log
    */
  def afterProcess(): Unit

}
