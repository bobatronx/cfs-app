package com.cfs.web

import spray.routing._
import com.cfs.web.athlete.AthleteRoute

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class CFSRouteActor extends HttpServiceActor
  with CFSRoute {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  //def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}


// this trait defines our service behavior independently from the service actor
trait CFSRoute extends HttpService
  with AthleteRoute {

  val myRoute =
      getFromResourceDirectory("web") ~
      getFromResourceDirectory("META-INF/resources/webjars") ~
      athleteRoute


}