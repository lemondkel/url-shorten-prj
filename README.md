# URL Shorten Project (SpringBoot)
데이터베이스를 사용하지 않고, WAS에 Map형식으로 저장하는 단축URL 생성용 웹서비스입니다.

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
