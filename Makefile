run: compile 
	java --module-path JavaFXForLinux/ --add-modules javafx.controls FrontEnd

compile: Data.txt MapADT.java HashTableMap.java Song.java Loader.java BackEndADT.java BackEnd.java FrontEnd.java 
	javac MapADT.java
	javac HashTableMap.java
	javac Song.java
	javac Loader.java
	javac BackEndADT.java
	javac BackEnd.java
	javac --module-path JavaFXForLinux/ --add-modules javafx.controls FrontEnd.java

test: compile TestBackEnd.java TestHashTable.java
	javac -cp .:junit5.jar TestBackEnd.java
	java -jar junit5.jar --cp . --scan-classpath
	
test2: compile TestHashTable.java
	javac -cp .:junit5.jar TestHashTable.java
	java -jar junit5.jar --cp . --scan-classpath
	
test3: compile Data.txt TestData.java
	javac -cp .:junit5.jar TestData.java
	java -jar junit5.jar --cp . --scan-classpath
	
test4: compile TestFrontEndAndLoad.java
	javac -cp .:junit5.jar --module-path JavaFXForLinux/ --add-modules java>
        javac --module-path JavaFXForLinux/ --add-modules javafx.controls Front>
        java -jar junit5.jar --cp . --scan-classpath


clean:
	$(RM) *.class
