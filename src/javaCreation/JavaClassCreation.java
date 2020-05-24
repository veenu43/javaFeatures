package javaCreation;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.invoke.MethodHandles;
import java.net.URI;

import static java.util.Collections.singletonList;
import static javax.tools.JavaFileObject.Kind.SOURCE;

public class JavaClassCreation {

    public static void main(String[] args) {
        final String className = "HelloWorld";
        final String path = "com.bounded.buffer";
        final String fullClassName = path.replace('.', '/') + "/" + className;
        final StringBuilder source = new StringBuilder();
        source.append("package " + path + ";");
        source.append("public class " + className + " {\n");
        source.append(" public String toString() {\n");
        source.append("     return \"HelloWorld - Java Dynamic Class Creation...");
        source.append(";");
        source.append(" }\n");
        source.append("}\n");

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        final SimpleJavaFileObject simpleJavaFileObject
                = new SimpleJavaFileObject(URI.create(fullClassName + ".java"), SOURCE) {

            @Override
            public CharSequence getCharContent(boolean ignoreEncodingErrors) {
                return source;
            }

            @Override
            public OutputStream openOutputStream() throws IOException {
                return byteArrayOutputStream;
            }
        };


        final JavaFileManager javaFileManager = new ForwardingJavaFileManager(
                ToolProvider.getSystemJavaCompiler().
                        getStandardFileManager(null, null, null)) {

            @Override
            public JavaFileObject getJavaFileForOutput(
                    Location location, String className,
                    JavaFileObject.Kind kind,
                    FileObject sibling) {
                return simpleJavaFileObject;
            }
        };

        ToolProvider.getSystemJavaCompiler().getTask(null, javaFileManager, null, null, null, singletonList(simpleJavaFileObject)).call();

        //then the bytes that make up the class are loaded into the class loader :
        final byte[] bytes = byteArrayOutputStream.toByteArray();

        // use the unsafe class to load in the class bytes
        try {
            /*
                final Field f = Unsafe.class.getDeclaredField("theUnsafe");
                f.setAccessible(true);
                final Unsafe unsafe = (Unsafe) f.get(null);
                final Class aClass = unsafe.defineClass(fullClassName, bytes, 0, bytes.length);
                final Object o = aClass.newInstance();
                System.out.println(o);
            */


            MethodHandles.Lookup lookup = MethodHandles.lookup();
            Class classFile = Class.forName(fullClassName);
          //  MethodHandles.Lookup privateLookup = MethodHandles.privateLookupIn(classFile, lookup);
            final Class aClass = lookup.defineClass(bytes);
            final Object o = aClass.newInstance();
            System.out.println(o);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
