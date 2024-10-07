# Run with maven and docker-compose:

./mvnw package

docker-compose up

# Testing:

endpoint: POST http://localhost:8080/topN

curl example:

curl --request POST \
  --url http://localhost:8080/topN \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --data '{ "requiredTopPlayers":2,
"participatedPlayers" : [["Sharon", "Shalom" , "Sharon", "Ronaldo"],
["Sharon", "Shalom" , "Myke", "Ronaldo"],
["Yechiel", "Sivan" , "Messi", "Ronaldo"],
["Yechiel", "Assaf" , "Shalom", "Ronaldo"]]}'
