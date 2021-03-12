package physics
import java.awt.geom.Line2D


object Physics {
  def computePotentialLocation(physicalObject: PhysicalObject, deltaT: Double): PhysicsVector = {
    val vector = new PhysicsVector(0.0, 0.0, 0.0)
    vector.x = physicalObject.location.x + physicalObject.velocity.x * deltaT
    vector.y = physicalObject.location.y + physicalObject.velocity.y * deltaT
    vector.z = physicalObject.location.z + physicalObject.velocity.z * deltaT
    if (vector.z < 0) {
      vector.z = 0.0
    }
    vector
  }

  def updateVelocity(physicalObject2: PhysicalObject, world: World, deltaT2: Double): Unit = {
    if (physicalObject2.location.z == 0 && physicalObject2.velocity.z < 0){
      physicalObject2.velocity.z = 0
    }else{
      physicalObject2.velocity.z = physicalObject2.velocity.z - world.gravity * deltaT2
    }
  }
  def detectCollision(physicalObject3: PhysicalObject, physicsVector2: PhysicsVector, boundary: Boundary): Boolean ={
    Line2D.linesIntersect(physicalObject3.location.x, physicalObject3.location.y, physicsVector2.x, physicsVector2.y, boundary.start.x, boundary.start.y, boundary.end.x, boundary.end.y)
  }

    def updateWorld(world2: World, deltaT3: Double): Unit = {
      var numb: Int = 0
      for (i <- world2.objects){
        numb = 0
        updateVelocity(i, world2, deltaT3)
         for (x <- world2.boundaries){
           if(detectCollision(i, computePotentialLocation(i, deltaT3), x)) {
             i.location.z = computePotentialLocation(i, deltaT3).z
             numb = 1
           }


        }
        if(numb == 0)
             i.location = computePotentialLocation(i, deltaT3)

      }
    }
  def main(args: Array[String]): Unit = {
    // Create a new simulation of Earth with metric units
    val earth: World = new World(9.81)
    // Add a ball to the world that is throw straight up at a velocity of 10 m/s
    val ball: PhysicalObject = new PhysicalObject(new PhysicsVector(0.0, 0.0, 0.0), new PhysicsVector(0.0, 0.0, 10.0))
    earth.objects = List(ball)
    var time: Double = 0.0
    var endOfTime: Double = 2.5
    var deltaTime: Double = 1.0
    var times = List(time)
    var zVelocity = List(ball.velocity.z)
    var height = List(ball.location.z)
    // Simulate the physics of Earth
    while(time < endOfTime){
      Physics.updateWorld(earth, deltaTime)
      time += deltaTime
      times = times :+ time
      zVelocity = zVelocity :+ ball.velocity.z
      height = height :+ ball.location.z
    }
    println(times.mkString("\t"))
    println(zVelocity.mkString("\t"))
    println(height.mkString("\t"))
  }

}

