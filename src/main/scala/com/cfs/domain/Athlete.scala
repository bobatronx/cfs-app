package com.cfs.domain

import spray.json.{RootJsonFormat, DefaultJsonProtocol}


/**
 * Created by James Cefaratti
 * 5/1/14.
 */
case class Athlete( id: Option[String],
                    firstName: String,
                    lastName: String,
                    email: String,
                    friends: List[Athlete] = List())

object AthleteJsonProtocol extends DefaultJsonProtocol {
  implicit val AthleteFormat: RootJsonFormat[Athlete] = jsonFormat(Athlete.apply, "id", "firstName", "lastName", "email", "friends")
}
