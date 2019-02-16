package br.com.semantix.app.core

import org.apache.log4j.Logger

trait CommonLogger {

  val Log: Logger = Logger.getLogger(getClass.getName)

}
