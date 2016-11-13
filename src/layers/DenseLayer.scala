package layers

class DenseLayer(inputSize: Int, outputSize: Int) {
  var weights = Array.fill[Double](outputSize, inputSize)(0)
  var output = Array.fill[Double](outputSize)(0)
  var input = Array.fill[Double](inputSize)(0)
//  val buffer = (kernelSize - 1)/2
//  var output = Array.fill[Double](imageWidth,imageHeight,numNeurons)(0)
//  var region = Array.fill[Double](kernelSize, kernelSize)(0)
  
//  def forwardProp(volume: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = {
//    for (i <- buffer to (volume.length - buffer) by stride){
//      for (j <- buffer to (volume(0).length - buffer) by stride){
//        // convolve input pixel array (i,j) with kernel
//        for (z <- 0 to numNeurons){
//          for (x <- (i-buffer) to (i+buffer) ){
//            for (y <- (j-buffer) to (j+buffer) ){
//              region(x-i+buffer)(y-i+buffer) = volume(x)(y)(z)
//            }
//          }
//          output((i-buffer)/2)((j-buffer)/2)(z) = PoolingLayer.maxPooling(region)
//        }
//      }
//    }
//    output
//  }
  
//  CREATE TABLE FEMALE_IDS (ID INT PRIMARY KEY);
//  load data local infile '/home/ben/data/Female_Ids.csv' into table FEMALE_IDS fields terminated by ',' enclosed by '"' lines terminated by '\n' (ID)
//  
//  SELECT POSTS.BODY FROM POSTS INNER JOIN FEMALE_IDS ON POSTS.OWNERUSERID = FEMALE_IDS.ID INTO OUTFILE 'female_posts.csv' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n';
//  SELECT COMMENTS.COMMENT FROM COMMENTS INNER JOIN FEMALE_IDS ON COMMENTS.USERID = FEMALE_IDS.ID INTO OUTFILE 'female_comments.csv' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n';
//  SELECT ID, DISPLAYNAME, REPUTATION, LOCATION, ABOUTME FROM USERS WHERE REPUTATION > 5000;
  
  def forwardProp(input: Array[Double]): Array[Double] = {
    this.input = input
    var tally = 0.0
    for (outputNeuron <- 0 to outputSize){
      tally = 0
      for (inputIndex <- 0 to inputSize){
        tally += weights(outputNeuron)(inputIndex)*input(inputIndex)
      }
      output(outputNeuron) = tally
    }
    output
  }
  
  def backProp(errorSignal: Array[Double]) = {
    
  }
}