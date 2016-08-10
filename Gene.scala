package com.github.aidy1991.scala_ga

trait Gene {
  def newRandomGene: Gene
  def division: Gene
  def mutation: Gene
  def crossover(that: Gene): Gene
  def eval: Double
}


