package com.cscie88a.week8

final case class SensorEvent(
  eventId: String,
  sensorId: String,
  sensorType: String,
  windDirection: String,
  eventTimestamp: Long,
  zipCode: String,
  humidityPercentage: Double,
  windSpeedInMPH: Int,
  pressureInAtm: Double,
  temperatureInCelcius: Double
)
