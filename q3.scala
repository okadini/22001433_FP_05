object q3 {
    def main(args:Array[String]) = {

        def printFibonacci(n:Int):Unit = {
            def fibonacciHelper(a:Int,b:Int,count:Int):Unit = {
                if(count>0) {
                    print(a + " ")
                    fibonacciHelper(b,a+b,count-1)
                }
            }

            fibonacciHelper(0,1,n)
            println()            
        }

        val n = 10
        print(s"First $n Fibonacci numbers: ")
        printFibonacci(n)
    }
}