package main


import java.util.Properties

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.{ProducerRecord, KafkaProducer}
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source

object Producer1 extends App {

  val conf = new SparkConf().setAppName("Producer1").setMaster("local[*]")
  val sc = new SparkContext(conf)

  val topic = "Sample"
  val key = "key2"

  val fileName = "data.csv"


/*  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)
  val record = new ProducerRecord[String, String](topic, key)
  //println("Producer" + record)
  producer.send(record)
  //producer.send("MyEg1",value)
  producer.close()*/

  while(true){
    for(line <- Source.fromFile(fileName).getLines){
    println(line)

      val props = new Properties()
      props.put("bootstrap.servers", "localhost:9092")
      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

      val producer = new KafkaProducer[String, String](props)
      //val record = new ProducerRecord[String, String](topic, key)
      println("Producer" + line)

      producer.send(new ProducerRecord[String, String]("Sample", line))
      //producer.send(record)
      //producer.send("MyEg1",value)
      //producer.close()

      //val adc=producer.send(line)
      /*val producer = new KafkaProducer[String, String](props)
      val record = new ProducerRecord[String, String](topic, key)
      println("Producer" + record)
      producer.send(line)*/

    }
  }
}