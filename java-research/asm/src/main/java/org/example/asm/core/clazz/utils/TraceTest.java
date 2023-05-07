package org.example.asm.core.clazz.utils;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

public class TraceTest {

    public static void main(String[] args) throws Exception {

        ClassReader reader = new ClassReader(String.class.getName());
        TraceClassVisitor traceVisitor = new TraceClassVisitor(new PrintWriter(System.out));
        RemoveMethodVisitor removeMethodVisitor = new RemoveMethodVisitor(traceVisitor);
        reader.accept(removeMethodVisitor, 0);

    }


    static class RemoveMethodVisitor extends ClassVisitor {

        public RemoveMethodVisitor(ClassVisitor cv) {
            super(Opcodes.ASM5, cv);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            return null;
        }
    }
}
