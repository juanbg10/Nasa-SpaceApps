package Nasa.Dados.Dados

import org.apache.spark._

object Dados {

	def dadosMock (dados) {
	return mock.read.csv("USSUB-AN_summaries_V20160309").option("header", "true").option("sep", "|")
	}


}

