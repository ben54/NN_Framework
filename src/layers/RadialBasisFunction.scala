package layers

import scala.math._

class RadialBasisFunction (centers: Array[Double], sigmas: Array[Double]){
  var input = new Array[Double](centers.length)
  var output = new Array[Double](centers.length)
  
  def getOutput(previousLayer: Array[Double]) = {
    var results = 0.0
    for (i <- 0 to centers.length){
      results = 0
      for (j <- 0 to output.length){
           results = results + math.pow(centers(j)-previousLayer(i),2)
      }
      output(i) = math.exp(-results/(2*math.pow(sigmas(i),2)))
    }    
  }
}