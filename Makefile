all: build

build:
	./mvnw clean compile package -DskipTests
	mv target/util.jar .

run: build
	java -jar util.jar -f -p pre_ in1.txt in2.txt
