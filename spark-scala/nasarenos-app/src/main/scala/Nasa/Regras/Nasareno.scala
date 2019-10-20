package Nasa.Regras.Nasarenos

import org.apache.spark._
import org.apache.spark.sql.functions as func

object Nasarenos {
  
  val f = function

  def mineracaoTemperatura( df: Dataframe) = Dataframe {
    return df.select(func.col("Index").alias("cd_local").cast(IntegerType()),
			func.col("Lat").alias("ds_lat").cast(StringType()),
			func.col("Lon").alias("ds_long").cast(StringType()),
			func.col("Avg_temp").alias("ds_temperatura").cast(StringType())
		)
			.withColumn("dt_repar", func.lit(func.concat(df("ds_year"), "-", df("ds_month"), "-", df("ds_yday")))).cast(DateType())
			.withColumn("dt_local", func.lit(func.current_date())).cast(DateType())
			.withColumn("ds_vegetacao", func.lit(null))StringType()
			.withColumn("ds_plurometrico", func.lit(null)).cast(StringType())

  }

	def mineracaoVegetacao( df: Dataframe) = Dataframe {
		return df.select(func.col("Index").alias("cd_local").cast(IntegerType()),
			func.col("Lat").alias("ds_lat").cast(StringType()),
			func.col("Lon").alias("ds_long").cast(StringType()),
			func.col("ercent").alias("ds_vegetacao").cast(StringType())
		)
			.withColumn("dt_repar", func.lit(func.concat(df("ds_year"), "-", df("ds_month"), "-", df("ds_yday")))).cast(DateType())
			.withColumn("dt_local", func.lit(func.current_date())).cast(DateType())
			.withColumn("ds_temperatura", func.lit(null))StringType()
			.withColumn("ds_plurometrico", func.lit(null)).cast(StringType())

	}

	def VegeTemp (veg: Dataframe, temp:Dataframe) = Dataframe{
		return veg.unionAll(temp)
	}

  }
