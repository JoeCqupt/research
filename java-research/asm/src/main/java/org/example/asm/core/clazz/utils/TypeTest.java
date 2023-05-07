package org.example.asm.core.clazz.utils;

import org.objectweb.asm.Type;

public class TypeTest {
    public static void main(String[] args) {
        String descriptor = Type.getDescriptor(String.class);
        System.out.println(descriptor);
    }
}
