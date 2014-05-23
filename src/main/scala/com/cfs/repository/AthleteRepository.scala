package com.cfs.repository

import com.cfs.domain.Athlete
import com.cfs.domain.AthleteJsonProtocol._
import java.util.UUID
import org.anormcypher.Cypher

/**
 * Created by James Cefaratti
 * 5/4/14.
 */
object AthleteRepository {

  def getAthleteById(id: String): Option[Athlete] = {
    val athleteResponse = Cypher(
    """
      |match (n: Athlete)
      |where n.id = {id}
      |return n.id, n.firstName, n.lastName, n.email
    """.stripMargin).on("id" -> id)

    val streamResponse = athleteResponse()

    streamResponse.map(row => {
      Athlete(row[Option[String]]("n.id"), row[String]("n.firstName"), row[String]("n.lastName"), row[String]("n.email"))
    }).headOption
  }

  def createAthlete(athlete: Athlete): Option[Athlete] = {

    val newAthlete = athlete.copy(id = Some(UUID.randomUUID().toString))
    val athleteJson = AthleteFormat.write(newAthlete).compactPrint
    val saved = Cypher(s"""create (n: Athlete $athleteJson)""").execute()

    saved match {
      case true => Some(newAthlete)
      case false => None
    }
  }

  def updateAthlete(id: String): Option[Athlete] = {

  }
}
