package layers

class PoolingLayer (numNeurons: Int, kernelSize: Int, stride: Int, imageWidth: Int, imageHeight: Int) {
  val buffer = (kernelSize - 1)/2
  var output = Array.fill[Double](imageWidth,imageHeight,numNeurons)(0)
  var region = Array.fill[Double](kernelSize, kernelSize)(0)
  
  def apply(volume: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = {
    for (i <- buffer to (volume.length - buffer) by stride){
      for (j <- buffer to (volume(0).length - buffer) by stride){
        // convolve input pixel array (i,j) with kernel
        for (z <- 0 to numNeurons){
          for (x <- (i-buffer) to (i+buffer) ){
            for (y <- (j-buffer) to (j+buffer) ){
              region(x-i+buffer)(y-i+buffer) = volume(x)(y)(z)
            }
          }
          output((i-buffer)/2)((j-buffer)/2)(z) = PoolingLayer.maxPooling(region)
        }
      }
    }
    output
  }
}

object PoolingLayer {
  def maxPooling(region: Array[Array[Double]]) = {
    var maxVal = region(0)(0)
    for (i <- 0 to region.length){
      for (j <- 0 to region(0).length){
        maxVal = math.max(maxVal, region(i)(j))
      }
    }
    maxVal
  }
  def meanPooling(region: Array[Array[Double]]) = {
    var sum: Double = 0
    for (i <- 0 to region.length){
      for (j <- 0 to region(0).length){
        sum = sum + region(i)(j)
      }
    }
    val size: Double = region.length*region(0).length
    sum/size
  }
}