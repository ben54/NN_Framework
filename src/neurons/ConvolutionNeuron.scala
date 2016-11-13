package neurons

import util.Random

class ConvolutionNeuron (kernelSize: Int, kernelDepth: Int, stride: Int, imageWidth: Int, imageHeight: Int){
  val buffer = (kernelSize - 1)/2
  var output = Array.fill[Double](imageWidth, imageHeight)(0)
  //var kernel: Array[Array[Array[Double]]] <-
  var kernel = Array.fill[Double](kernelSize, kernelSize, kernelDepth)(.01*(2*Random.nextDouble-1))
  
  def getKernel(): Array[Array[Array[Double]]] = {
    kernel
  }
  
  def forwardProp(volume: Array[Array[Array[Double]]]): Array[Array[Double]] = { //convolve with kernel
    var sum = 0.0
    for (i <- buffer to (volume.length - buffer) by stride){
      for (j <- buffer to (volume(0).length - buffer) by stride){
        // convolve input pixel array (i,j) with kernel
        sum = 0
        for (x <- (i-buffer) to (i+buffer) ){
          for (y <- (j-buffer) to (j+buffer) ){
            for (z <- 0 to kernelDepth){
              sum = sum + kernel(x)(y)(z)*volume(i)(j)(z)
            }
          }
        }
        output((i-buffer)/2)((j-buffer)/2) = sum
      }
    }
    output
  }
  
  def backProp(errorSignal: Array[Double]) = {
    
  }
}