import java.util.Properties

import org.apache.kafka.clients.producer.{ProducerRecord, KafkaProducer}

object Producer1 extends App{
val topic="MyEg"
  val key="key1"
  val value="value1"

  val props=new Properties()
  props.put("bootstrap.servers","localhost:9092")
  props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")

  val producer=new KafkaProducer[String,String](props)
  val record=new ProducerRecord[String,String](topic,key,value)
  producer.send(record)
  producer.close()




}
