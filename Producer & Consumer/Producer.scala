package main

import java.util.Properties

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.{ProducerRecord, KafkaProducer}

object Producer extends App{
  val topic="MyEg1"
  val key="key2"
  val value="value4"

  val props=new Properties()
  props.put("bootstrap.servers","localhost:9092")
  props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")

  val producer=new KafkaProducer[String,String](props)
  val record=new ProducerRecord[String,String](topic,key,value)
  println("Producer"+record)
  producer.send(record)
  producer.close()




}

