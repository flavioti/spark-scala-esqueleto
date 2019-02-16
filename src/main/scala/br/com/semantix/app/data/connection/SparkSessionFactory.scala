package br.com.semantix.app.data.connection

import java.io.File

import br.com.semantix.app.core.{CommonConfig, CommonLogger}
import br.com.semantix.app.customException.EnviromentUndefinedException
import br.com.semantix.app.structure.EnviromentEnum
import br.com.semantix.app.structure.EnviromentEnum.{Desenvolvimento, Homologacao, Producao}
import org.apache.spark.sql.SparkSession

object SparkSessionFactory extends CommonLogger with CommonConfig {
  def apply(env: EnviromentEnum.EnumVal): SparkSession = env match {
    case Desenvolvimento =>
      Log.warn("Aplicação configurada para ambiente de desenvolvimento")
      SparkSession
        .builder()
        .enableHiveSupport()
        .appName("spark-scala-exemplo")
        .master("local[*]")
        .config("spark.sql.warehouse.dir", new File("spark-warehouse").getAbsolutePath)
        .config("spark.ui.showConsoleProgress", "true")
        .config("spark.debug.maxToStringFields", 500)
        .getOrCreate()
    case Homologacao =>
      Log.warn("Aplicação configurada para ambiente de homologação")
      SparkSession
        .builder()
        .enableHiveSupport()
        .getOrCreate()
    case Producao =>
      Log.warn("Aplicação configurada para ambiente de produção")
      SparkSession
        .builder()
        .enableHiveSupport()
        .getOrCreate()
    case _ => {
      throw EnviromentUndefinedException("Ambiente não foi definido")
    }
  }
}
