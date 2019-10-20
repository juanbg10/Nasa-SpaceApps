package Nasa.Regras.Nasarenos

import org.apache.spark._
import org.apache.spark.sql.functions as func

object Nasarenos {
  
  val f = function

  def mineracao( df: Dataframe) = Dataframe {
    return df.select(func.col("Index").alias("cd_col").type(StringType),
    	func.col("Year").alias("ds_year").type(DecimalType(3,0)),
    	func.col("Yday").alias("ds_yday").type(DecimalType(3,0)),
    	func.col("MinDay").alias("ds_minday").type(DecimalType(3,0)),
    	func.col("MaxDay").alias("ds_maxday").type(DecimalType(3,0)),
    	func.col("Month").alias("ds_month").type(IntegerType),
    	func.col("Lat").alias("ds_lat").type(StringType),
    	func.col("Lon").alias("ds_long").type(StringType),
    	func.col("MinLat").alias("ds_lat_min").type(StringType),
    	func.col("MaxLat").alias("ds_lat_max").type(StringType),
    	func.col("MinLon").alias("ds_long_min").type(StringType),
    	func.col("MaxLon").alias("ds_long_max").type(StringType),
    	func.col("Length").alias("ds_length").type(IntegerType),
    	func.col("Avg_temp").alias("ds_avgtemp").type(StringType),
    	func.col("Min_temp").alias("ds_mintemp").type(StringType),
    	func.col("Max_temp").alias("ds_maxtemp").type(StringType))
        func.withColumn("date_repart", func.lit(func.current_date()))
  }

  }
