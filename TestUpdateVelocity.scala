package tests
import org.scalatest._
import physics.Physics


class TestUpdateVelocity extends FunSuite {
  test("Velocity") {
    var velocity = new physics.PhysicsVector(5.0, 6.0, 9.81)
    var location = new physics.PhysicsVector(12.0, 7.0, -9.0)
    var phob1: physics.PhysicalObject = new physics.PhysicalObject(location, velocity)
    var acceleration = new physics.World(-9.81)
    physics.Physics.updateVelocity(phob1, acceleration, 1)

    assert(phob1.velocity.z == 19.62, "fail1")

    var acceleration2 = new physics.World(11)
    var velocity2 = new physics.PhysicsVector(34.0, 65.0, -3.0 )
    var location2 = new physics.PhysicsVector(43.0, 75.0, 0.0)
    var phob2: physics.PhysicalObject = new physics.PhysicalObject(location2, velocity2)
    physics.Physics.updateVelocity(phob2, acceleration2, 3)

    assert(phob2.velocity.z == 0.0, "fail2")

    var acceleration1 = new physics.World(9.81)
    var velocity3 = new physics.PhysicsVector(45.0, 55.0, 10.0)
    var location3 = new physics.PhysicsVector(89.0, 56.0, 34.0)
    var phob3: physics.PhysicalObject = new physics.PhysicalObject(location3, velocity3)
    physics.Physics.updateVelocity(phob3, acceleration1, 1)

    assert(phob3.velocity.z == 0.1899999999999995, "fail3")

    var acceleration5 = new physics.World(20)
    var velocity4 = new physics.PhysicsVector(2.0, 5.0, 6.0)
    var location4 = new physics.PhysicsVector(8.0, 9.0, 42.0)
    var phob4: physics.PhysicalObject = new physics.PhysicalObject(location4, velocity4)
    physics.Physics.updateVelocity(phob4, acceleration5, 1)

    assert(phob4.velocity.z == -14.0, "fail4")

    var acceleration6 = new physics.World(20)
    var velocity5 = new physics.PhysicsVector(2.0, 5.0, 900.0)
    var location5 = new physics.PhysicsVector(8.0, 9.0, 120.0)
    var phob5: physics.PhysicalObject = new physics.PhysicalObject(location5, velocity5)
    physics.Physics.updateVelocity(phob5, acceleration6, 8)

    assert(phob5.velocity.z == 740.0, "fail5")
  }
}