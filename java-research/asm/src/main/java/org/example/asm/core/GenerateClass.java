package org.example.asm.core;

import org.objectweb.asm.ClassWriter;

import java.lang.reflect.Field;

import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V1_8;

public class GenerateClass {
    public static void main(String[] args) throws Exception {
        // 生成类
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable", null,
                "java/lang/Object", null);
        cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "LESS",
                "I", null, new Integer(1)).visitEnd();
        cw.visitEnd();

        // 加载类
        byte[] data = cw.toByteArray();
        FooClassLoader classLoader = new FooClassLoader(data);
        Class<?> clazz = classLoader.loadClass("pkg.Comparable");

        // 反射获取值
        Field lessField = clazz.getField("LESS");
        int value = lessField.getInt(null);
        System.out.println(value);
    }

    static class FooClassLoader extends ClassLoader {
        private byte[] data;


        public FooClassLoader(byte[] data) {
            this.data = data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if ("pkg.Comparable".equals(name)) {
                return defineClass(name, data, 0, data.length);
            }
            return null;
        }
    }
}
