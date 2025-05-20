import scala.collection.mutable.Map

val counts = Map[Int, Long]()

for {
  line <- scala.io.Source.stdin.getLines()
  split = line.split("\t")
  level = split(3)
  if level.startsWith("S") //== S
  aggregate = split(1).toLong
  taxon = split(4).toInt
} {
  counts(taxon) = counts.getOrElse(taxon, 0L) + aggregate
}

for { (taxon, count) <- counts } {
  println(s"$taxon\t$count")
}