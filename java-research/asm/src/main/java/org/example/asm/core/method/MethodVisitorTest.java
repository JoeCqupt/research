package org.example.asm.core.method;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.IADD;
import static org.objectweb.asm.Opcodes.ICONST_0;

public class MethodVisitorTest {
    public static void main(String[] args) {
        MethodVisitor mv = null;
        mv.visitInsn(ICONST_0);
        mv.visitInsn(IADD);
    }
}
