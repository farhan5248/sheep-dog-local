cd ..
call mvn clean
call mvn org.farhan:sheep-dog-svc-maven-plugin:uml-to-cucumber-guice -Dtags="asciidoc-api" -Dhost="dev.sheepdog.io"
cd scripts