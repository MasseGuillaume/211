```
sbt
server/reStart prod
open http://localhost:8080/
unzip -l server/target/scala-2.12/server_2.12-0.1-SNAPSHOT.jar


sbt
server/packageBin
unzip -l server/target/scala-2.12/server_2.12-0.1-SNAPSHOT.jar
META-INF/resources/webjars/server/0.1-SNAPSHOT/client-opt.js
```
