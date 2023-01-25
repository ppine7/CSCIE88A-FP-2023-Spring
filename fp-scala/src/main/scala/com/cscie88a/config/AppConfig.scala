package com.cscie88a.config

import pureconfig.generic.auto._
import scala.reflect.ClassTag

// config classes
case class CookieSettings(
    domain: String,
    path: String,
    ttl: Int
  )
case class SignatureSettings(pkfile: String, keyPairId: String)
case class AppSettings(cookie: CookieSettings, signature: SignatureSettings)

object ConfigUtils {

  /** loads a configuration case class
    */
  def loadAppConfig[A](
      path: String
    )(implicit
      ev: pureconfig.Derivation[pureconfig.ConfigReader[A]],
      tag: ClassTag[A]
    ): A =
    pureconfig.loadConfig[A](path) match {
      case Left(ex) =>
        ex.toList.foreach(println)
        throw new Exception("invalid configuration")
      case Right(c: A) => c
    }
}
