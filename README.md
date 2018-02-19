# swtest


the web service can do the following:
1. add two integer numbers n1 and n2 with either GET or POST request.
it will return the result in json format. The result will look like this:
{"n1":1, "n2":4, "sum": 5}
there is no authentication so far. When implemented, it will use "org.springframework.boot:spring-boot-starter-security"
2. retrieve current wait time
so far this operation has not been tested due to the external web service which requires authentication even for code yyc

Docker
the project contains a dockerfile but the deployment to docker hub did not work, I tried a gradle plugin that is supposed to 
build the image and deploy it to docker hub. the amazon docker client can pick it up from there when I deploy on EC2.




#tests


GET 
following tests should pass:
	curl -v localhost:8080/math/add?n1=1&n2=3 | json_pp
following tests should fail:
	curl -v localhost:8080/math/add?n1=1 | json_pp
	curl -v localhost:8080/math/add?n1=1&n2=baba | json_pp

POST 
following tests should pass:
curl -v -X POST -H "Content-Type: application/json" "localhost:8080/math/add?n1=1&n2=3" | json_pp	

following tests should fail:
curl -v -X POST -H "Content-Type: application/json" "localhost:8080/math/add?n1=1" | json_pp
