hw8 run steps :   
Build images :   


When you are in CSCIE88A-FP-2023-Spring
To start the kafka containers :
Run `docker-compose -f docker/docker-compose-kafka-min.yaml up -d` to run kafka and zookeeper containers

To start producer of sensor data into input_topic :
Run `./gradlew runMessageProducer -Dkafka_url=localhost:9092 -Dkafka_topic=input_topic -Dno_of_events=100 -Dstreaming=y -Dstreaming_interval_sec=20 --no-daemon`

To view posted messages in input_topic :
Run `docker exec -it broker /bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic input_topic`

^^ should show messages getting into `input_topic` every 20 seconds like :
`{"eventId":"c5f726d4-af4e-4ee3-bd70-7abd3a0a79a7","sensorId":"sensor-id-675","sensorType":"D","windDirection":"E","eventTimestamp":1585944518005,"zipCode":"82443","humidityPercentage":73.78018,"windSpeedInMPH":13,"pressureInAtm":0.0,"temperatureInCelcius":-3.0}
 {"eventId":"192e0517-8002-46eb-b53c-bdc403dc701c","sensorId":"sensor-id-803","sensorType":"A","windDirection":"W","eventTimestamp":1586352678305,"zipCode":"63555","humidityPercentage":81.09388,"windSpeedInMPH":66,"pressureInAtm":0.0,"temperatureInCelcius":-1.0}`


To start kakfa stream :
Run `./gradlew runConsumerStream -Dkafka_url=localhost:9092 -Dkafka_topic=input_topic --no-daemon`

To check if kafka stream is processing :
Run `docker exec -it broker /bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic sensor_type_count_topic`

^^ should show processed counts getting into `sensor_type_count_topic`  :
`sensorTypeF : 536
 sensorTypeD : 538
 sensorTypeG : 555
 sensorTypeB : 541
 sensorTypeC : 595
 sensorTypeA : 562
 sensorTypeE : 573`
