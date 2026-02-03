cd ..
call mvn clean org.farhan:sheep-dog-dev-svc-maven-plugin:uml-to-cucumber-guice -Dtags="sheep-dog-test" -Dhost="dev.sheepdogdev.io"
cd scripts 