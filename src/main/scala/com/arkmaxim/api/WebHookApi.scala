package com.arkmaxim.api

import akka.http.scaladsl.server.Directives._

/**
  * Created by quybeans on 1/11/17.
  */
trait WebHookApi{

  val webhook =
    (path("verifyname?cat="/String/) & get) { token:String =>
      complete("PONG")
    }
}
