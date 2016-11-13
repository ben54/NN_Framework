package network

import layers._
import neurons._
import neurons.ConvolutionNeuron
import org.json4s._

object Network {
  def main(args: Array[String]) = {
    
    val x = Array(-1.0,2,3,4)
    val activationFunction = new Activation(4)
//    val output = activationFunction.sigmoidActivation(x)
    val output = Activation.sigmoidActivation(x)
    for (i <- 0 to 3){
      println(output(i))
    }
    val myKernel = new ConvolutionNeuron(3,5,1,255,255).getKernel()
    for (i<- 0 to 2){
      for (j <- 0 to 2){
        for (k <- 0 to 4){
          println(myKernel(i)(j)(k))
        }
      }
    }
    
//    println("Hello from the image object")
//    val img = ImageIO.read(new File("/Users/bendutton/Data/ImageNet/ILSVRC2013_DET_val/ILSVRC2012_val_00032371.JPEG"))
//    val image = new Image(ImageIO.read(new File("/Users/bendutton/Data/ImageNet/ILSVRC2013_DET_val/ILSVRC2012_val_00032371.JPEG")))
//    
//    image.printPixelValues()
//    image.display()
//    val x = Scalr.resize(img, 256)
//    println("Image should be displayed")
//    
//    val y = img.getRGB(1, 1,10,10,new Array[Int](100),0,0)
//    println("image length" + y.length)
//    println("y length: " + y.length)
//    
//    //read all files in a directory
//    //val files = new java.io.File("/Users/bendutton/Data/MNIST/").listFiles.filter(_.getName.endsWith(".pdf"))
//    val files = new java.io.File("/Users/bendutton//Data/ImageNet/ILSVRC2013_DET_bbox_val/").listFiles.filter(_.getName.endsWith(".xml"))
//    
//    //files.foreach(println)
//    //files.foreach { x => println(x) }
//    files.foreach {
//      x => println(x)
//    }
//    //println(files.head)
//    //val x = files.head
//    //image.applyFilter(new Array[Array[Double]](3)(3))
//    println("Should be done")
  }
}

class Network {
  //learning rate
}