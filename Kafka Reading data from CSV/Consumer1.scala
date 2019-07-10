package main


import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, LocationStrategies, KafkaUtils}
import org.apache.spark.streaming.{Seconds, StreamingContext}


object Consumer1 {

  def main(args: Array[String]) {
    val zkQuorum = args(0)
    //val groupId = args(1)
    val nodeTopic = args(1)
    val groupId = "abc"//args(1) + "_" + System.currentTimeMillis()
    //val numThreads = Try(args(3).toInt).getOrElse(2)
    val streamingDuration = args(2).toInt
    val databaseServerIp = ""//args(3)



    // ConfigService.setEnv(env,hdfspath)
    //val config = ConfigService.getCurrentConfiguration()
    Consumer.consumeFromUet(s"$zkQuorum", nodeTopic,groupId,
      streamingDuration, databaseServerIp)

  }

  def consumeFromUet(zkQuorum: String, topics: String,groupId:String, streamingDuration: Int,
                     databaseServerIp: String)={


    val streamingtime =streamingDuration*1000
    val kakfkaParams = Map[String, String]("metadata.broker.list" -> zkQuorum,
      "bootstrap.servers" -> zkQuorum,
      "group.id" -> groupId,
      "client.id" -> ("ClientId-" + groupId),
      "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
      "value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
      "auto.offset.reset" -> "latest"
    )

    val conf = returnConf(false)
    val sqlContext = conf.sqlContext
    val context = conf.sparkContext
    context.setLogLevel("ERROR")
    //context.setLogLevel("INFO")
    val ssc = new StreamingContext(context, Seconds(streamingDuration))

    val topicSet = topics.split(",").toSet

    val lines =KafkaUtils.createDirectStream[String,String](
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](topicSet, kakfkaParams))

    lines.map(rec=>(rec.key(),rec.value())).foreachRDD(linesRDD => {

      linesRDD.foreach(x=>println("input data::"+x))
    }
    )

    ssc.start()
    ssc.awaitTermination()
  }


  def returnConf(conf: Boolean) = {
    conf match {
      case true => SparkSession
        .builder()
        .getOrCreate()
      // case false => new SparkConf().setAppName("healthhomestreamondemandconsumer")
      case false => SparkSession
        .builder()
        .master("local[*]")
        .getOrCreate()
    }
  }

}



