package com.arkmaxim.response


import io.circe._

/**
  * Created by quybeans on 1/15/17.
  */
trait JsonReponse {
    implicit lazy val decodeReponse: Decoder[JsonReponse] = new Decoder[JsonReponse] {
      override def apply(c: HCursor):Decoder.Result[JsonReponse] = Left(DecodingFailure("Not yet implemented",c.history))
    }


  implicit lazy val encodeFoo: Encoder[JsonReponse] = new Encoder[JsonReponse] {
    final def apply(a: JsonReponse): Json = ??? // your implementation goes here
  }
}
