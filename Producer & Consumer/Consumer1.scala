import java.util.Properties

import org.apache.kafka.clients.consumer.{ConsumerRecords, ConsumerRecord, KafkaConsumer}
import org.apache.kafka.clients.producer.{ProducerRecord, KafkaProducer}
import scala.collection.JavaConverters._
import java.util

object Consumer1 extends App {
  val topic = "MyEg"
  val grpName = "MyGroup"

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("group.id", "grpName");

  props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
  props.put("enable.auto.commit", "true");

  val consumer = new KafkaConsumer[String, String](props)
  consumer.subscribe(util.Collections.singletonList(topic))
  while (true) {
    val records = consumer.poll(100)
    for (record <- records.asScala) {
      println(record)
    }
  }
}