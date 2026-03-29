cd ..
call mvn clean
call mvn org.farhan:sheep-dog-dev-svc-maven-plugin:uml-to-cucumber-guice -Dtags="api" -Dhost="dev.sheepdog.io"
cd scripts