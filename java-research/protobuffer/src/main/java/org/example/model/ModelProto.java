// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: model.proto

package org.example.model;

public final class ModelProto {
  private ModelProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_example_model_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_example_model_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013model.proto\022\021org.example.model\"2\n\006Pers" +
      "on\022\014\n\004name\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\022\r\n\005email\030\003" +
      " \001(\tB!\n\021org.example.modelB\nModelProtoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_org_example_model_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_example_model_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_example_model_Person_descriptor,
        new java.lang.String[] { "Name", "Age", "Email", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
