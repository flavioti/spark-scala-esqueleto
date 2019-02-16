package br.com.semantix.app.trigger

object sparkScalaEsqueletoTrigger extends CommonTrigger {
  /**
    * Disparado antes do processo principal, útil para configuração
    */
  override def beforeProcess(): Unit = {
    Log.info("ok")
  }

  /**
    * Processo principal, sistema deve ser codificado aqui
    */
  override def triggerProcess(): Unit = {

  }

  /**
    * Disparado depois do processo principal, útil para log
    */
  override def afterProcess(): Unit = {

  }
}
