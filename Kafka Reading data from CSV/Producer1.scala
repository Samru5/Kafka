package main

import java.util.Properties

import org.apache.kafka.clients.producer.{ProducerRecord, KafkaProducer}

import scala.io.Source


object Producer2 extends App {
  val fileName = "data.csv"

  val topic = "Sample"

  val buff = Source.fromFile(fileName)
  val props = new Properties()

  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[String, String](props)


  for (lines <- buff.getLines()){
    val record=new ProducerRecord[String,String](topic,lines)
    producer.send(record)
    println(record)


  }


}