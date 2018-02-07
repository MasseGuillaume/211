## Dev mode:
```
sbt
server/reStart
open http://localhost:8080/
```

## Prod mode:

```
sbt server/universal:packageBin
rm -rf server-0.1-SNAPSHOT
unzip server/target/universal/server-0.1-SNAPSHOT.zip
server-0.1-SNAPSHOT/bin/server prod
open http://localhost:8080/
```
