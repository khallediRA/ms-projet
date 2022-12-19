java -jar "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/configserver/target/configserver-0.0.1-SNAPSHOT.jar" > configserver.out & 
sleep 30 
java -jar "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/eurakaserver/target/eurekaserver-0.0.1-SNAPSHOT.jar" > eurakaserver.out &
sleep 30 
java -jar "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/laons/loans/target/loans-0.0.1-SNAPSHOT.war" > loans.out &
sleep 30 
java -jar "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/cards/cards/target/cards-0.0.1-SNAPSHOT.jar" > cards.out &
sleep 30 
java -jar "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/accounts/accounts/target/accounts-0.0.1-SNAPSHOT.jar" > accounts.out &
sleep 30 
java -jar "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/gatewayserver/target/gatewayserver-0.0.1-SNAPSHOT.war" >gateway.out &





