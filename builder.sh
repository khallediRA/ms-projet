mvn -f "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/configserver/pom.xml" clean package -DskipTests  & sleep 3 &
mvn -f "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/eurakaserver/pom.xml" clean package -DskipTests  & sleep 3 &
mvn -f "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/accounts/accounts/pom.xml" clean package -DskipTests  & sleep 3 &
mvn -f "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/laons/loans/pom.xml" clean package -DskipTests  & sleep 3 &
mvn -f  "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/cards/cards/pom.xml" clean package -DskipTests & sleep 3 &

mvn -f  "/c/Users/HP/Desktop/SpringBootProjects/udemy cours reworked/gatewayserver/pom.xml" clean package -DskipTests &





