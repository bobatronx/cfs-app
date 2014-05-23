package com.cfs.service

import org.anormcypher.Cypher
import com.cfs.domain.Athlete
import com.cfs.repository.AthleteRepository

/**
 * Created by James Cefaratti
 * 5/1/14.
 */
object AthleteService {

  def getAthletes: List[Athlete] = {

    // a simple query
    val athleteResponse = Cypher("match (n:Athlete) return n.id, n.firstName, n.lastName, n.email")

    // get a stream of results back
    val streamResponse = athleteResponse()

    // get the results and put them into a list
    streamResponse.map(row => {
      Athlete(row[Option[String]]("n.id"), row[String]("n.firstName"), row[String]("n.lastName"), row[String]("n.email"))
    }).toList
  }

  def getAthlete(id: String): Option[Athlete] = {
    AthleteRepository.getAthleteById(id)
  }

  def createAthlete(athlete: Athlete): Option[Athlete] = {
    AthleteRepository.createAthlete(athlete)
  }

  def addFriendOfAthlete(id: String, friendOfAthlete: Athlete): Option[Athlete] = {
    val maybeAthlete = getAthlete(id)

    maybeAthlete.map(athlete => {
      val friends: List[Athlete] = friendOfAthlete +: athlete.friends
      athlete.copy(friends = friends)
    })
  }
}
