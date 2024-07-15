import scala.io.StdIn.readLine

object InventoryManagementSystem {
  def getProductList(): List[String] = {
    def readProducts(acc: List[String]): List[String] = {
      val input = readLine("Enter a product name (or type 'done' to finish): ")
      if (input.toLowerCase == "done") acc
      else readProducts(acc :+ input)
    }
    readProducts(List())
  }

  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    val products = getProductList()
    println("\nProduct List:")
    printProductList(products)
    val totalProducts = getTotalProducts(products)
    println(s"\nTotal number of products: $totalProducts")
  }
}
