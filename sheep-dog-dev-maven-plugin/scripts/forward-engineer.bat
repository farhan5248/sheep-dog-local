cd ..
call mvn clean
call mvn org.farhan:sheep-dog-dev-maven-plugin:uml-to-cucumber-guice -DrepoDir=../../sheep-dog-qa/sheep-dog-specs/ -Dtags="round-trip"
cd scripts 