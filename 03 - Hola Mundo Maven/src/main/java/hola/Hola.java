package hola;
public class Hola{
    public static void main(String[] args) {
        System.out.println("Hola Mundo Java SE!");
        //para ejecutar, desde consola: 
        //mvn compile
        //java hola/Hola

        //Para generar un .JAR se coloco un plugin en el pom.xml (maven-jar-plugin) para indicar la main class
        //mvn package
    }
}