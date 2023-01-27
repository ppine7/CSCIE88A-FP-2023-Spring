/** main entry point for application
  */

package com.cscie88a

import com.cscie88a.config.{ ConfigUtils, CookieSettings }
import pureconfig.generic.auto._
import com.typesafe.scalalogging.{ LazyLogging }

object MainApp extends LazyLogging {

  val COOKIE_CONFIG_PATH = "com.cscie88a.cookie"

  def hello(name: String): String = s"Hello ${name}"

  def main(args: Array[String]): Unit = {
    val cookie = ConfigUtils.loadAppConfig[CookieSettings](COOKIE_CONFIG_PATH)
    logger.info(s"running application version with ttl: ${cookie.ttl}")

    val message = args.length match {
      case 0 => hello("Anonymous")
      case _ => hello(args(0))
    }
    println(message)
  }
}
