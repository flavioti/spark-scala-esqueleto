package br.com.semantix.app.service

import br.com.semantix.app.core.{CommonBase, CommonConfig}
import org.joda.time.{DateTime, Period}

object CalendarService extends CommonBase with CommonConfig {

  /**
    * Retorna o ultimo dia do mês
    *
    * @param year  Ano a ser processado
    * @param month Mês a ser processado
    * @return Ultimo dia do mês
    */
  def GetLastDayOfMonth(year: Int, month: Int): Int =
    new DateTime(year, month, 1, 0, 0, 0, brasilTimeZone)
      .dayOfMonth
      .withMaximumValue
      .getDayOfMonth

  def dateRangeIterator(from: DateTime, to: DateTime, step: Period): Iterator[DateTime] =
    Iterator.iterate(from)(_.plus(step)).takeWhile(!_.isAfter(to))

}
