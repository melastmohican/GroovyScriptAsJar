import groovy.sql.Sql
import org.h2.Driver

// Create an h2 jdbc in-memory database,
// calling it what you like, here db1
def db = Sql.newInstance("jdbc:h2:mem:db1", "org.h2.Driver")

// Create a table from your csv file... 
db.execute("create table gene_names as select * from csvread('gene_names.txt',null, 'charset=UTF-8 fieldSeparator=' || CHAR(9))")

// Execute a normal sql query on this table...
db.eachRow("select * from gene_names") { row -  > 
    println row
}