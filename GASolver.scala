package com.github.aidy1991.scala_ga

import scala.util.Random

object GASolver {
  def solve(
      gene: Gene,
      generationSize: Int = 1000,
      geneSize: Int = 100,
      crossoverRate: Double = 0.3,
      mutationRate: Double = 0.05,
      tournamentSizeRate: Double = 0.1): Double = {

    def isTrue(rate: Double) = (rate >= Random.nextDouble)
    def isCrossover = isTrue(crossoverRate)
    def isMutation = isTrue(mutationRate)

    def alternation(genes: Seq[Gene], generation: Int): Seq[Gene] = {
      if(generation == 0) return genes
      
      val nextGeneration = for(_ <- 1 to genes.size) yield {
        if(isMutation) {
          mutation(genes)
        } else if(isCrossover) {
          crossover(genes)
        } else {
          selection(genes)
        }
      }
      alternation(nextGeneration, generation - 1)
    }
    
    def mutation(genes: Seq[Gene]): Gene = genes(Random.nextInt(genes.size)).mutation
    def crossover(genes: Seq[Gene]): Gene = {
      val gene1 = genes(Random.nextInt(genes.size))
      val gene2 = genes(Random.nextInt(genes.size))
      gene1.crossover(gene2)
    }
    def selection(genes: Seq[Gene]): Gene = {
      val selectedTounament = Random.shuffle(genes).take((genes.size * tournamentSizeRate).toInt)
      selectTopGene(selectedTounament)
    }
    def selectTopGene(genes: Seq[Gene]): Gene = genes.sortWith((g1, g2) => g1.eval > g2.eval)(0)
    
    
    // Solver start
    val genes = for(_ <- 1 to geneSize) yield gene.newRandomGene
    val lastGenerationGene = alternation(genes, generationSize)
    
    return selectTopGene(lastGenerationGene).eval
  }
}
