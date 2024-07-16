import scala.io.StdIn.readLine

object q1 {
    def main(args:Array[String]) = {

        def getProductList():List[String] = {
            var productList = List[String]()
            var input = ""

            while(input != "done") {
                input = readLine("Enter a product name(type 'done' to finish) : ")
                if(input != "done") {
                    productList = productList :+ input
                }
            }

            productList
        }

        def printProductList(productList:List[String]):Unit = {
            for((product,index) <- productList.zipWithIndex) {
                println(s"${index+1}. $product")
            }
        }

        def getTotalProducts(productList:List[String]):Int = {
            productList.length
        }

        printf("Inventory management system\n")
        var productList:List[String] = getProductList()
        
        printf("\nProduct List:\n")
        printProductList(productList)

        printf("\nTotal number of products = %d\n",getTotalProducts(productList))
    }
}