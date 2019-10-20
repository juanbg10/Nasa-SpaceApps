package Nasa.Initializer

import Nasa.Regras.Nasareno
import Nasa.Dados.Dados
import Nasa.Config.Conf 
import org.apache.spark._

object Initializer extends App {

  val sparkConf = new SparkConf().setAppName(Config.sparkName)
  
  val enviromentFlag = ssc.sparkContext.broadcast(flag)
  
  val inform = Dados.dadosMock
   
  var dadoFim = None

    try {

     dadoFim = Nasareno.mineracao(inform)	

    } catch {
      case e: Exception => print(e.getMessage)
    }

     dadoFim.save(Config.scyllaTable,Config.scyllaKey)

  ssc.start()
  ssc.awaitTermination()
  }
