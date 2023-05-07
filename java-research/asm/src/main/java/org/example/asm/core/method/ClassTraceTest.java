package org.example.asm.core.method;

import org.example.asm.core.clazz.utils.TraceTest;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

public class ClassTraceTest {

    public static void main(String[] args) throws Exception {
        ClassReader reader = new ClassReader(TestClass.class.getName());
        TraceClassVisitor traceVisitor = new TraceClassVisitor(new PrintWriter(System.out));
        reader.accept(traceVisitor, 0);
    }
}
