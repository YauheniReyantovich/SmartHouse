#### Build the project

In order to build the project install the node.js.

Then run:

```
npm install -g bower
```
```
npm install -g gulp-cli
```

In order to build the project itself run:

```
bower install
```
```
npm install
```
```
gulp build
```
```
./gradlew build
```

#### Run the project:

```
./gradlew build
```
```
./gradlew bootRun
```

Access http://localhost:8080

Or you can simply run:

```
java -jar ./build/libs/sample-0.0.1-SNAPSHOT.jar
```

By default the application uses embedded in-memory database H2. So you don't need to setup anything else for it.
In order to use PostgreSQL create a database sampledb.
It's assumed that it has postgres/postgres credentials. Otherwise, correct the configuration in application.yml.

Then run the application as described above but with _-Dspring.profiles.active=production_ option. It will create automatically all necessary tables and data.
 
#### Run the project in dev mode:

Start the backend part. Then run:
 
```
gulp
```

It will run the project in dev mode with active browser sync extension which automatically reload the browser upon any change. 
When you need to do a release after this you can run again:

```
./gradlew build
```

