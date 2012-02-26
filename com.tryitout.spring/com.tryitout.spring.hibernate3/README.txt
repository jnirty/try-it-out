This is an example project on how to use Spring 3 with Hibernate 3.
For the purpose of exercises we will use the following domain mode.

Bookshelf is an organizer space for Books. Each Bookshelf can have multiple books. 
Late on bookshelf can get additional properties, like keeping the books depending on the reader's status e.g.: TO_READ, READ, READING 
so we could map Bookshelf to Book with a link having additional attribute 'status', or create 3 different collections of Book in Bookshelf object(booksToRead, 
booksReading, booksRead). First approach seems to be better one.
Each book can have one or more authors.
An author can have one or more books. Each of this objects will have additional attributes, e.g. Book can have ISBN no, Author -name, surname, etc.
These one-to-many and many-to-many relationships are for the purpose of exercising Hibernate mappings.

Tutorials:
http://www.antoniogoncalves.org/xwiki/bin/view/Article/TestingJPA
http://trapo.posterous.com/maven-hibernate-spring-hsqldb-your-tests-runn