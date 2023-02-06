package com.cscie88a.week3

// TODO complete the method definitions below
object AdoptionService {
  def tryToAdoptNoArg(
      isAdoptionFeePaid: Boolean
    )(
      readyForAdoptionNoArg: () => Boolean
    ): Boolean = ???

  def tryToAdoptOneArg(
      healthCheckDone: Boolean,
      isAdoptionFeePaid: Boolean
    )(
      readyForAdoptionOneArg: Boolean => Boolean
    ): Boolean = ???

}
