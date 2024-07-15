import scala.collection.mutable

case class Book(title: String, author: String, isbn: String)

object LibraryManagement {

  var library: mutable.Set[Book] = mutable.Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "0987654321"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "1122334455")
  )

  
  def addBook(book: Book): Unit = {
    library += book
    println(s"Book '${book.title}' added to the library.")
  }

  
  def removeBook(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"Book '${book.title}' removed from the library.")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  
  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  
  def displayLibrary(): Unit = {
    println("\nCurrent Library Collection:")
    library.foreach { book =>
      println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    }
  }

  
  def searchBookByTitle(title: String): Unit = {
    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(s"\nBook found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"\nNo book found with title: $title")
    }
  }

  
  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"\nBooks by $author:")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    } else {
      println(s"\nNo books found by author: $author")
    }
  }

  
  def main(args: Array[String]): Unit = {
    displayLibrary()
    
    addBook(Book("Brave New World", "Aldous Huxley", "6677889900"))
    displayLibrary()

    removeBook("0987654321")
    displayLibrary()

    println(s"\nIs book with ISBN 1234567890 in library? ${isBookInLibrary("1234567890")}")

    searchBookByTitle("1984")

    displayBooksByAuthor("George Orwell")
  }
}
