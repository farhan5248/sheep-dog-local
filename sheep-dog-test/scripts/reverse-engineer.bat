cd ..
call mvn clean
call mvn org.farhan:sheep-dog-dev-maven-plugin:cucumber-to-uml -Dtags="%1" -DrepoDir=../../sheep-dog-qa/sheep-dog-specs/
cd scripts 