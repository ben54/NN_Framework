package layers

import scala.math._

class Activation (inputSize: Int){
  var input = new Array[Double](inputSize)
  var output = new Array[Double](inputSize)
  
  def forwardProp() = {
    
  }
   
  def backProp(errorSignal: Array[Double]) = {
    
  }
  
}

object Activation {
  def reluActivation(previousLayer: Array[Double]) = {
    previousLayer.map(x => max(0,x))
  }
  
  def tanhActivation(previousLayer: Array[Double]): Array[Double] = {
    previousLayer.map(x => tanh(x)) 
  }
  
  def sigmoidActivation(previousLayer: Array[Double]) = {
    previousLayer.map(x => 1 / ( 1 + math.exp(-x) ) )
  }
}