package multitenant.bug

class Book {

    String title
    String author

    static constraints = {
        title blank: false
        author nullable: true
    }
}
