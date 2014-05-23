package com.cfs.domain

import spray.json.DefaultJsonProtocol

/**
 * Created by James Cefaratti
 * 5/20/14.
 */
case class AthleteFriend(name: String)

object AthleteFriendJsonProtocol extends DefaultJsonProtocol {
  implicit val AthleteFriendFormat = jsonFormat1(AthleteFriend)
}