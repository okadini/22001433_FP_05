import scala.collection.mutable.Set

object q2 {
    def main(args:Array[String]) = {
        case class Book(title:String,author:String,isbn:String)

        object LibraryManagement {
            var library:Set[Book] = Set(
                Book("Book One","Author A","ISBN001"),
                Book("Book Two","Author B","ISBN002"),
                Book("Book Three","Author C","ISBN003")
            )

            def addBook(book:Book):Unit = {
                library += book
            }

            def removeBook(isbn:String):Unit = {
                library = library.filterNot(_.isbn == isbn)
            }

            def isBookInLibrary(isbn:String):Boolean = {
                library.exists(_.isbn == isbn)
            }

            def displayLibrary():Unit = {
                library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
            }

            def searchBookByTitle(title:String):Option[Book] = {
                library.find(_.title == title)
            }

            def displayBooksByAuthor(author:String):Unit = {
                library.filter(_.author == author).foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
            }
        }

        LibraryManagement.addBook(Book("New Book","Author A","ISBN004"))

        LibraryManagement.removeBook("ISBN002")

        println(s"Is 'ISBN001' in the library? ${LibraryManagement.isBookInLibrary("ISBN001")}")

        println("\nLibrary Collection:")
        LibraryManagement.displayLibrary()

        val searchResult = LibraryManagement.searchBookByTitle("New Book")
        searchResult match {
            case Some(book) => println(s"\nFound book: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
            case None => println("\nBook not found")
        }

        println("\nBooks by Author A:")
        LibraryManagement.displayBooksByAuthor("Author A")
    }
}