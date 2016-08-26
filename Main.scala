import com.github.aidy1991.scala_ga._

object Main {
  def main(args: Array[String]):Unit = {
    val p1 = new PolynominalFunctionGene(x => - (x - 10) * (x - 10) + 20)
    println(GASolver.solve(p1));
    
    val p2 = new PolynominalFunctionGene(x => - (x * x * x * x - 2 * x * x * x + 1))
    println(GASolver.solve(p2));
  }
}
