package org.example.asm.core.clazz.utils;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

public class ASMifierTest {
    public static void main(String[] args) throws Exception {
        ASMifier asmifier = new ASMifier();

        ClassReader reader = new ClassReader(Runnable.class.getName());
        TraceClassVisitor traceVisitor = new TraceClassVisitor(null,
                asmifier, new PrintWriter(System.out));
        reader.accept(traceVisitor, 0);
    }
}
