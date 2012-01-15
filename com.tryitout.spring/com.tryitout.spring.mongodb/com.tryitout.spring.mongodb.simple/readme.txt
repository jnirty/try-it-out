HOWTO

1) download mondodb and unzip
http://www.mongodb.org/display/DOCS/Quickstart+Windows#QuickstartWindows-Download

2) read manual
http://www.mongodb.org/display/DOCS/Quickstart+Windows
http://www.mongodb.org/display/DOCS/Tutorial

-----------------------------------------------------------------------------------------------------------------
Quick start commands:
---------------------
1. start database
MONGODB_HOME/bin/mongod --dbpath <path where to store db files>

e.g.: mongod --dbpath database


run mongod with --rest enabled, and then go to http://localhost:28017/_commands
e.g.: mongod --dbpath database --rest

2. connect with mongo shell
MONGODB_HOME/bin/mongo

3. mongo shell commands:

> show dbs
local   (empty)
mydb    0.078125GB
> show collections
> help
        db.help()                    help on db methods
        db.mycoll.help()             help on collection methods
        rs.help()                    help on replica set methods
        help admin                   administrative help
        help connect                 connecting to a db help
        help keys                    key shortcuts
        help misc                    misc things to know
        help mr                      mapreduce

        show dbs                     show database names
        show collections             show collections in current database
        show users                   show users in current database
        show profile                 show most recent system.profile entries with time >= 1ms
        show logs                    show the accessible logger names
        show log [name]              prints out the last segment of log in memory, 'global' is default
        use <db_name>                set current database
        db.foo.find()                list objects in collection foo
        db.foo.find( { a : 1 } )     list objects in foo where a == 1
        it                           result of the last line evaluated; use to further iterate
        DBQuery.shellBatchSize = x   set default number of items to display on shell
        exit                         quit the mongo shell

> use mydb
switched to db mydb

> show collections
system.indexes
user

> db.user.find()
{ "_class" : "com.tryitout.spring.user.User", "_id" : "1001", "age" : 30, "firstname" : "yong", "lastname" : "new lastname" }

> db.user.find({_id : "1001"})
{ "_class" : "com.tryitout.spring.user.User", "_id" : "1001", "age" : 30, "firstname" : "yong", "lastname" : "new lastname" }

> db.user.find({firstname : "yong"})
{ "_class" : "com.tryitout.spring.user.User", "_id" : "1001", "age" : 30, "firstname" : "yong", "lastname" : "new lastname" }

> help admin
        ls([path])                      list files
        pwd()                           returns current directory
        listFiles([path])               returns file list
        hostname()                      returns name of this host
        cat(fname)                      returns contents of text file as a string
        removeFile(f)                   delete a file or directory
        load(jsfilename)                load and execute a .js file
        run(program[, args...])         spawn a program and wait for its completion
        runProgram(program[, args...])  same as run(), above
        sleep(m)                        sleep m milliseconds
        getMemInfo()                    diagnostic

> db.user.help()
DBCollection help
        db.user.find().help() - show DBCursor help
        db.user.count()
        db.user.dataSize()
        db.user.distinct( key ) - eg. db.user.distinct( 'x' )
        db.user.drop() drop the collection
        db.user.dropIndex(name)
        db.user.dropIndexes()
        db.user.ensureIndex(keypattern[,options]) - options is an object with these possible fields: name, unique, dropDups
        db.user.reIndex()
        db.user.find([query],[fields]) - query is an optional query filter. fields is optional set of fields to return.
                                                      e.g. db.user.find( {x:77} , {name:1, x:1} )
        db.user.find(...).count()
        db.user.find(...).limit(n)
        db.user.find(...).skip(n)
        db.user.find(...).sort(...)
        db.user.findOne([query])
        db.user.findAndModify( { update : ... , remove : bool [, query: {}, sort: {}, 'new': false] } )
        db.user.getDB() get DB object associated with collection
        db.user.getIndexes()
        db.user.group( { key : ..., initial: ..., reduce : ...[, cond: ...] } )
        db.user.mapReduce( mapFunction , reduceFunction , <optional params> )
        db.user.remove(query)
        db.user.renameCollection( newName , <dropTarget> ) renames the collection.
        db.user.runCommand( name , <options> ) runs a db command with the given name where the first param is the collection name
        db.user.save(obj)
        db.user.stats()
        db.user.storageSize() - includes free space allocated to this collection
        db.user.totalIndexSize() - size in bytes of all the indexes
        db.user.totalSize() - storage allocated for all data and indexes
        db.user.update(query, object[, upsert_bool, multi_bool])
        db.user.validate( <full> ) - SLOW
        db.user.getShardVersion() - only for use with sharding
> db.user.remove()
> db.user.find()

-----------------------------------------------------------------------------------------------------------------
Resources:

http://www.mongodb.org/display/DOCS/Quickstart+Windows
http://www.mkyong.com/mongodb/spring-data-mongodb-hello-world-example/

http://static.springsource.org/spring-data/data-document/docs/1.0.0.M4/reference/html/

