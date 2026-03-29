cd ..
call mvn clean
call mvn org.farhan:sheep-dog-dev-svc-maven-plugin:uml-to-cucumber-guice -Dtags="sheep-dog-dev" -Dhost="dev.sheepdogdev.io"
cd scripts