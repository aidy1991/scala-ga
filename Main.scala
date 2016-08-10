import com.github.aidy1991.scala_ga._

object Main {
  def main(args: Array[String]):Unit = {
    val p1 = new PolynominalFunctionGene(x => - (x - 10) * (x - 10) + 20)
    println(p1.eval)
    println("---")
    println(p1.mutation.eval)
    println("---")
    println(GASolver.solve(p1));
  }
}
