# URL Shorten Project (SpringBoot)
Init

## Environment
+ Java
+ Gradle
+ SpringBoot
+ Server port: `80`

## Project Execute
```
git clone https://github.com/lemondkel/url-shorten-prj
cd url-shorten-prj
gradle clean build jar
java -jar build/libs/shortenurl-1.0-SNAPSHOT.jar
```

## API Example
+ URL -> Shorten: `http://localhost/api/shorten?url=https://en.wikipedia.org/wiki/URL_shortening`
+ Shorten -> URL: `http://localhost/aAbB`
