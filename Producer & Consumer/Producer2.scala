
import java.util.Properties
import org.apache.kafka.clients.producer._
import org.apache.log4j.{BasicConfigurator, Logger, Level}

object Producer {

     val log = Logger.getLogger("Producer.class")

    def main(args: Array[String]): Unit = {
      BasicConfigurator.configure();
      log.info("This is Logger Info");

      writeToKafka("quick-start")
    }

    def writeToKafka(topic: String): Unit = {
      val props = new Properties()
      props.put("bootstrap.servers", "localhost:9094")
      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
      val producer = new KafkaProducer[String, String](props)
      val record = new ProducerRecord[String, String](topic, "key", "value")
      producer.send(record)
      producer.close()
    }


}