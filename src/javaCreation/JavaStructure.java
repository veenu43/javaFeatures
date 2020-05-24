package javaCreation;

public class JavaStructure {

    public StringBuilder getJavaStructure(){
        final String className = "HelloWorld";
        final String path = "javaCreation.buffer";
        final String fullClassName = path.replace('.', '/') + "/" + className;
        final StringBuilder source = new StringBuilder();
        source.append("package " + path+";");
        source.append("public class " + className + " {\n");
        source.append(" public String toString() {\n");
    //    source.append("     return \"HelloWorld - Java Dynamic Class Creation...";");
        source.append(" }\n");
        source.append("}\n");
        return source;
    }
}
