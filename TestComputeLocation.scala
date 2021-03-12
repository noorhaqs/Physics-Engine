package tests
import org.scalatest._
import physics.Physics

class  TestComputeLocation extends FunSuite {
    test("Random Test") {
      var velocity1 = new physics.PhysicsVector(5.0, 7.0, 8.0)
      var location1 = new physics.PhysicsVector(6.0, 8.0, 9.0)
      var phob1: physics.PhysicalObject = new physics.PhysicalObject(velocity1, location1)
      var velocity2 = new physics.PhysicsVector(23.0, 73.0, 83.0)
      var location2 = new physics.PhysicsVector(62.0, 82.0, -92.0)
      var phob2: physics.PhysicalObject = new physics.PhysicalObject(velocity2, location2)
      val vdelta: Double = 2.00

      assert(physics.Physics.computePotentialLocation(phob1, vdelta).x == 17.0, "fail1")
      assert(physics.Physics.computePotentialLocation(phob1, vdelta).y == 23.0, "fail2")
      assert(physics.Physics.computePotentialLocation(phob1, vdelta).z == 26.0, "fail3")

      assert(physics.Physics.computePotentialLocation(phob2, vdelta).x == 147.0, "fail1")
      assert(physics.Physics.computePotentialLocation(phob2, vdelta).y == 237.0, "fail1")
      assert(physics.Physics.computePotentialLocation(phob2, vdelta).z == 0.0, "fail1")
    }
}
