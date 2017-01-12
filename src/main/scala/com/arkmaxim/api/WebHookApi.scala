package com.arkmaxim.api

import cats.syntax.either._
import akka.http.scaladsl.server.Directives._
import io.circe._, io.circe.parser._

/**
  * Created by quybeans on 1/11/17.
  */
trait WebHookApi {

  final val haru_secret = "HaruProjectABCXYZ"

  val webhook = {
    (path("webhooks") & get) {
      parameter("hub.verify_token", "hub.challenge") { (token: String, challenge: String) => {
        if (haru_secret == token)
          complete(challenge)
        else complete("Something happend ...")
      }
      }
    } ~
      (path("webhooks") & post) {
        entity(as[String]) { jsonResponse => {
          println(jsonResponse)
          val change : Json = parse(jsonResponse).getOrElse(Json.Null)
          val cursor : HCursor = change.hcursor
          val root:String = cursor.downField("changes").as[List[String]].toString
          println(root)
          complete("OK")
        }
        }
      }
  }
}
