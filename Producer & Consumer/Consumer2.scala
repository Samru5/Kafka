import java.util
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties
import org.apache.log4j.{BasicConfigurator, Logger}

import scala.collection.JavaConverters._

object Consumer {
  val log = Logger.getLogger("Producer.class")

  def main(args: Array[String]): Unit = {
    BasicConfigurator.configure();
    log.info("This is Logger Info");
    consumeFromKafka("quick-start")
  }
  def consumeFromKafka(topic: String) = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9094")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("auto.offset.reset", "latest")
    props.put("group.id", "consumer-group")
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Arrays.asList(topic))
    while (true) {
      val record = consumer.poll(1000).asScala
      for (data <- record.iterator)
        println(data.value())
    }
  }
}

