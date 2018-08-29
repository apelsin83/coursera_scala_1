/* Definite Integrals via Numerical Methods

This relates to definite integration via numerical methods.

Consider the algebraic expression given by:



For the purpose of numerical computation, the area under the curve  between the limits  and  can be computed by the Limit Definition of a Definite Integral.

Here is some background about areas and volume computation.

Using equal subintervals of length , you need to:

Evaluate the area bounded by a given polynomial function of the kind described above, between the given limits of  and .

Evaluate the volume of the solid obtained by revolving this polynomial curve around the -axis.

A relative error margin of  will be tolerated.
 */

package problems
object AreaUnderCurve {

  val step = 0.001

  def main(args: Array[String]) = {
    println { summation(f, 4, 1, List(1, 2, 3, 4, 5), List(6, 7, 8, 9, 10)) }
    println { summation(area, 4, 1, List(1,2,3,4,5), List(6, 7, 8, 9, 10)) }
    println { summation(area, 20, 2, List(1,2), List(0, 1)) }
  }
  // This function will be used while invoking "Summation" to compute
  // The area under the curve.
  def f(coefficients: List[Int], powers: List[Int], x: Double): Double =
    coefficients
      .zip(powers)
      .map(a => a._1 * math.pow(x, a._2.toDouble))
      .sum * step

  //Fill Up this function body
  // To compute the value of the function
  // For the given coefficients, powers and value of x

  // This function will be used while invoking "Summation" to compute
  // The Volume of revolution of the curve around the X-Axis
  // The 'Area' referred to here is the area of the circle obtained
  // By rotating the point on the curve (x,f(x)) around the X-Axis
  def area(coefficients: List[Int], powers: List[Int], x: Double): Double =
    math.pow(f(coefficients, powers, x), 2) * math.Pi / step
   
  //Fill Up this function body
  // To compute the area of the circle on revolving the point
  // (x,f(x)) around the X-Axis
  // For the given coefficients, powers and value of x

  // This is the part where the series is summed up
  // This function is invoked once with func = f to compute the area 	     // under the curve
  // Then it is invoked again with func = area to compute the volume
  // of revolution of the curve
  def summation(func: (List[Int], List[Int], Double) => Double,
                upperLimit: Int,
                lowerLimit: Int,
                coefficients: List[Int],
                powers: List[Int]): Double =
    // Range.BigDecimal(0.1,1,.1).map(_.toDouble).toList
    (lowerLimit.toDouble to upperLimit.toDouble by step)
      .map(x => func(coefficients, powers, x))
      .sum

}
