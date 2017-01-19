package com.arkmaxim.response

import java.sql.Timestamp

import io.circe.generic.JsonCodec

/**
  * Created by quybeans on 1/15/17.
  */

case class CommentResponse (
     entry : Seq[Entry],
     `object`: String
                           )

object CommentResponse extends JsonReponse


case class Entry (
     changes: Seq[Changes],
     id: String,
     time: Timestamp
                 )

object Entry extends JsonReponse

case class Changes (
     field: String,
     value: Value
                   )

object Changes extends JsonReponse

case class Value (
     parent_id: String,
     sender_name: String,
     comment_id:String,
     sender_id: String,
     item: String,
     verb: String,
     created_time: Timestamp,
     post_id: String,
     message: String
                 )
