cd ..
call mvn clean
call mvn org.farhan:sheep-dog-dev-svc-maven-plugin:cucumber-to-uml -Dtags="sheep-dog-test" -Dhost="dev.sheepdogdev.io"
cd scripts 