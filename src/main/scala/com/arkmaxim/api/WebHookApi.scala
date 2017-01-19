package com.arkmaxim.api

import akka.http.scaladsl.server.Directives._
import cats.syntax.either._
import com.arkmaxim.response.CommentResponse
import io.circe.Json
import io.circe.optics.JsonPath.root
import io.circe.parser._

trait WebHookApi {

  final val haru_secret = "HaruProjectABCXYZ"

  val _entries= root.entry.string

  val webhook = {
    (path("webhooks") & get) {
      parameter("hub.verify_token", "hub.challenge") { (token: String, challenge: String) =>
        if (haru_secret == token) {
          complete(challenge)
        } else {
          complete("Something happend ...")
        }
      }
    } ~
      (path("webhooks") & post) {
        entity(as[String]) { jsonResponse =>
          println(jsonResponse)
         val json = parse(jsonResponse).getOrElse(Json.Null)
//          println(json.toString())
//          println(root.`object`.string.getOption(json))
//          println(root.entry.each.id.string.getAll(json))
          println(CommentResponse.decodeReponse(json.hcursor))
          complete("OK")
        }
      }
  }
}
