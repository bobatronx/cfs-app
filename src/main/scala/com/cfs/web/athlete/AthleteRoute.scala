package com.cfs.web.athlete

import spray.routing.HttpService
import spray.http.MediaTypes._
import com.cfs.domain.Athlete
import com.cfs.service.AthleteService
import com.cfs.domain.AthleteJsonProtocol._
import spray.httpx.SprayJsonSupport._

/**
 * Created by James Cefaratti
 * 4/30/14.
 */
trait AthleteRoute extends HttpService {

  val athleteRoute = path("athletes") {
    get {
      respondWithMediaType(`application/json`) {
        complete  {
          AthleteService.getAthletes
        }
      }
    } ~
    post {
      entity(as[Athlete]) { athlete =>
        complete {
          AthleteService.createAthlete(athlete)
        }
      }

    }
  } ~
  path("athletes" / Rest) { id =>
    get {
      respondWithMediaType(`application/json`) {
        complete {
          AthleteService.getAthlete(id)
        }
      }
    }
  }
}
