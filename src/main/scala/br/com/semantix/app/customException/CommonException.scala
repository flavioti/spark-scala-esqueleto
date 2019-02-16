package br.com.semantix.app.customException

trait CommonException extends Exception {

  val exitCode: Int

}
