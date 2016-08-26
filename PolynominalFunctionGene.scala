package com.github.aidy1991.scala_ga

import scala.util.Random

class PolynominalFunctionGene(func: Double => Double, val x: Double) extends Gene {
  
  def this(func: Double => Double) = this(func, (Random.nextInt(200) - 100) + Random.nextDouble())

  def newRandomGene = new PolynominalFunctionGene(func)

  def division: PolynominalFunctionGene = new PolynominalFunctionGene(func)

  def eval: Double = func(x)

  def mutation = {
    val random = new Random
    val plus = random.nextInt(4)
    val minus = random.nextInt(4)
    new PolynominalFunctionGene(func, x + plus - minus)
  }

  def crossover(that: Gene): Gene = {
    val newX =  (this.x + that.asInstanceOf[PolynominalFunctionGene].x) / 2
    new PolynominalFunctionGene(func, newX)
  }
}
