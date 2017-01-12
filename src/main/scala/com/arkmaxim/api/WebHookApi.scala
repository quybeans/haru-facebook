package com.arkmaxim.api

import akka.http.scaladsl.server.Directives._

/**
  * Created by quybeans on 1/11/17.
  */
trait WebHookApi {

  final val haru_secret = "HaruProjectABCXYZ"

  val webhook =
    (path("webhooks") & get) {
      parameter("hub.verify_token", "hub.challenge") { (token: String, challenge: String) => {
        if (haru_secret == token)
          complete(challenge)
        else complete("Something happend ...")}
      }
    }
}
