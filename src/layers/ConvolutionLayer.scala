package layers

import neurons._

class ConvolutionLayer (numNeurons: Int,kernelSize: Int, kernelDepth: Int, stride: Int, imageWidth: Int, imageHeight: Int) {
  //val neurons = new Array[ConvolutionNeuron](numNeurons)
  val neurons = Array.fill[ConvolutionNeuron](numNeurons)(new ConvolutionNeuron(kernelSize,kernelDepth,stride,imageWidth,imageHeight))
  var output = Array.fill[Double](imageWidth,imageHeight,numNeurons)(0)
  
  def forwardProp(volume: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = {
    val imageArray = Array.fill[Array[Array[Array[Double]]]](numNeurons)(volume)
    output = neurons.map { x => x.forwardProp(volume) }
    output
  }
  
  def backProp(errorSignal: Array[Double]) = {
    
  }
  
}