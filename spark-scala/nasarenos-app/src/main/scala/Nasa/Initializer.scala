package Nasa.Initializer

import Nasa.Regras.Nasareno
import Nasa.Dados.Dados
import Nasa.Config.Conf 
import org.apache.spark._

object Initializer extends App {

  val spark = SparkSession.builder.appName(Conf.sparkName).getOrCreate()
  val sparkConf = new SparkConf(false).setAppName(Conf.sparkName).setMaster("local")
  
  val enviromentFlag = ssc.sparkContext.broadcast(flag)
  
  val mockado = Dados.dadosMock
  val informacaoNasa = Dados.dadosNasa

  var dadoFim = None

    try {

     dadoFim = Nasareno.mineracaoTemperatura(mockado)

    } catch {
      case e: Exception => print(e.getMessage)
    }

  val sparkReader = dadoFim.save(Config.keyspace,Config.tableLocal).start()

  sparkReader.awaitTermination()
  }
