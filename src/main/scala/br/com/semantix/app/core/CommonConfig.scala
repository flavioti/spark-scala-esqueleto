package br.com.semantix.app.core

import com.typesafe.config.Config
import org.joda.time.DateTimeZone

trait CommonConfig {

  lazy val config: Config = com.typesafe.config.ConfigFactory.load()

  lazy val brasilTimeZone: DateTimeZone = DateTimeZone.forID("America/Sao_Paulo")

}
