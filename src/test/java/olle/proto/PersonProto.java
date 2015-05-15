// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/test/protobuf/person.proto

package olle.proto;

public final class PersonProto {
  private PersonProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PersonMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:olle.PersonMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string firstName = 1;</code>
     */
    boolean hasFirstName();
    /**
     * <code>optional string firstName = 1;</code>
     */
    java.lang.String getFirstName();
    /**
     * <code>optional string firstName = 1;</code>
     */
    com.google.protobuf.ByteString
        getFirstNameBytes();

    /**
     * <code>optional string lastName = 2;</code>
     */
    boolean hasLastName();
    /**
     * <code>optional string lastName = 2;</code>
     */
    java.lang.String getLastName();
    /**
     * <code>optional string lastName = 2;</code>
     */
    com.google.protobuf.ByteString
        getLastNameBytes();

    /**
     * <code>repeated string middleName = 3;</code>
     */
    com.google.protobuf.ProtocolStringList
        getMiddleNameList();
    /**
     * <code>repeated string middleName = 3;</code>
     */
    int getMiddleNameCount();
    /**
     * <code>repeated string middleName = 3;</code>
     */
    java.lang.String getMiddleName(int index);
    /**
     * <code>repeated string middleName = 3;</code>
     */
    com.google.protobuf.ByteString
        getMiddleNameBytes(int index);

    /**
     * <code>optional int32 age = 4;</code>
     */
    boolean hasAge();
    /**
     * <code>optional int32 age = 4;</code>
     */
    int getAge();

    /**
     * <code>optional string emailAddress = 5;</code>
     */
    boolean hasEmailAddress();
    /**
     * <code>optional string emailAddress = 5;</code>
     */
    java.lang.String getEmailAddress();
    /**
     * <code>optional string emailAddress = 5;</code>
     */
    com.google.protobuf.ByteString
        getEmailAddressBytes();

    /**
     * <code>optional bytes password = 6;</code>
     */
    boolean hasPassword();
    /**
     * <code>optional bytes password = 6;</code>
     */
    com.google.protobuf.ByteString getPassword();
  }
  /**
   * Protobuf type {@code olle.PersonMessage}
   */
  public static final class PersonMessage extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:olle.PersonMessage)
      PersonMessageOrBuilder {
    // Use PersonMessage.newBuilder() to construct.
    private PersonMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private PersonMessage(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final PersonMessage defaultInstance;
    public static PersonMessage getDefaultInstance() {
      return defaultInstance;
    }

    public PersonMessage getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private PersonMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              firstName_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              lastName_ = bs;
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                middleName_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000004;
              }
              middleName_.add(bs);
              break;
            }
            case 32: {
              bitField0_ |= 0x00000004;
              age_ = input.readInt32();
              break;
            }
            case 42: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000008;
              emailAddress_ = bs;
              break;
            }
            case 50: {
              bitField0_ |= 0x00000010;
              password_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          middleName_ = middleName_.getUnmodifiableView();
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return olle.proto.PersonProto.internal_static_olle_PersonMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return olle.proto.PersonProto.internal_static_olle_PersonMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              olle.proto.PersonProto.PersonMessage.class, olle.proto.PersonProto.PersonMessage.Builder.class);
    }

    public static com.google.protobuf.Parser<PersonMessage> PARSER =
        new com.google.protobuf.AbstractParser<PersonMessage>() {
      public PersonMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PersonMessage(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<PersonMessage> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int FIRSTNAME_FIELD_NUMBER = 1;
    private java.lang.Object firstName_;
    /**
     * <code>optional string firstName = 1;</code>
     */
    public boolean hasFirstName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string firstName = 1;</code>
     */
    public java.lang.String getFirstName() {
      java.lang.Object ref = firstName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          firstName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string firstName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFirstNameBytes() {
      java.lang.Object ref = firstName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firstName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LASTNAME_FIELD_NUMBER = 2;
    private java.lang.Object lastName_;
    /**
     * <code>optional string lastName = 2;</code>
     */
    public boolean hasLastName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string lastName = 2;</code>
     */
    public java.lang.String getLastName() {
      java.lang.Object ref = lastName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          lastName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string lastName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      java.lang.Object ref = lastName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MIDDLENAME_FIELD_NUMBER = 3;
    private com.google.protobuf.LazyStringList middleName_;
    /**
     * <code>repeated string middleName = 3;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getMiddleNameList() {
      return middleName_;
    }
    /**
     * <code>repeated string middleName = 3;</code>
     */
    public int getMiddleNameCount() {
      return middleName_.size();
    }
    /**
     * <code>repeated string middleName = 3;</code>
     */
    public java.lang.String getMiddleName(int index) {
      return middleName_.get(index);
    }
    /**
     * <code>repeated string middleName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getMiddleNameBytes(int index) {
      return middleName_.getByteString(index);
    }

    public static final int AGE_FIELD_NUMBER = 4;
    private int age_;
    /**
     * <code>optional int32 age = 4;</code>
     */
    public boolean hasAge() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 age = 4;</code>
     */
    public int getAge() {
      return age_;
    }

    public static final int EMAILADDRESS_FIELD_NUMBER = 5;
    private java.lang.Object emailAddress_;
    /**
     * <code>optional string emailAddress = 5;</code>
     */
    public boolean hasEmailAddress() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional string emailAddress = 5;</code>
     */
    public java.lang.String getEmailAddress() {
      java.lang.Object ref = emailAddress_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          emailAddress_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string emailAddress = 5;</code>
     */
    public com.google.protobuf.ByteString
        getEmailAddressBytes() {
      java.lang.Object ref = emailAddress_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        emailAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PASSWORD_FIELD_NUMBER = 6;
    private com.google.protobuf.ByteString password_;
    /**
     * <code>optional bytes password = 6;</code>
     */
    public boolean hasPassword() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional bytes password = 6;</code>
     */
    public com.google.protobuf.ByteString getPassword() {
      return password_;
    }

    private void initFields() {
      firstName_ = "";
      lastName_ = "";
      middleName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      age_ = 0;
      emailAddress_ = "";
      password_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getFirstNameBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getLastNameBytes());
      }
      for (int i = 0; i < middleName_.size(); i++) {
        output.writeBytes(3, middleName_.getByteString(i));
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(4, age_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(5, getEmailAddressBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(6, password_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getFirstNameBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getLastNameBytes());
      }
      {
        int dataSize = 0;
        for (int i = 0; i < middleName_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(middleName_.getByteString(i));
        }
        size += dataSize;
        size += 1 * getMiddleNameList().size();
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, age_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, getEmailAddressBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(6, password_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static olle.proto.PersonProto.PersonMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static olle.proto.PersonProto.PersonMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static olle.proto.PersonProto.PersonMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static olle.proto.PersonProto.PersonMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static olle.proto.PersonProto.PersonMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static olle.proto.PersonProto.PersonMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static olle.proto.PersonProto.PersonMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static olle.proto.PersonProto.PersonMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static olle.proto.PersonProto.PersonMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static olle.proto.PersonProto.PersonMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(olle.proto.PersonProto.PersonMessage prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code olle.PersonMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:olle.PersonMessage)
        olle.proto.PersonProto.PersonMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return olle.proto.PersonProto.internal_static_olle_PersonMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return olle.proto.PersonProto.internal_static_olle_PersonMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                olle.proto.PersonProto.PersonMessage.class, olle.proto.PersonProto.PersonMessage.Builder.class);
      }

      // Construct using olle.proto.PersonProto.PersonMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        firstName_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        lastName_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        middleName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
        age_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        emailAddress_ = "";
        bitField0_ = (bitField0_ & ~0x00000010);
        password_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000020);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return olle.proto.PersonProto.internal_static_olle_PersonMessage_descriptor;
      }

      public olle.proto.PersonProto.PersonMessage getDefaultInstanceForType() {
        return olle.proto.PersonProto.PersonMessage.getDefaultInstance();
      }

      public olle.proto.PersonProto.PersonMessage build() {
        olle.proto.PersonProto.PersonMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public olle.proto.PersonProto.PersonMessage buildPartial() {
        olle.proto.PersonProto.PersonMessage result = new olle.proto.PersonProto.PersonMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.firstName_ = firstName_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.lastName_ = lastName_;
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          middleName_ = middleName_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.middleName_ = middleName_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000004;
        }
        result.age_ = age_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000008;
        }
        result.emailAddress_ = emailAddress_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000010;
        }
        result.password_ = password_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof olle.proto.PersonProto.PersonMessage) {
          return mergeFrom((olle.proto.PersonProto.PersonMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(olle.proto.PersonProto.PersonMessage other) {
        if (other == olle.proto.PersonProto.PersonMessage.getDefaultInstance()) return this;
        if (other.hasFirstName()) {
          bitField0_ |= 0x00000001;
          firstName_ = other.firstName_;
          onChanged();
        }
        if (other.hasLastName()) {
          bitField0_ |= 0x00000002;
          lastName_ = other.lastName_;
          onChanged();
        }
        if (!other.middleName_.isEmpty()) {
          if (middleName_.isEmpty()) {
            middleName_ = other.middleName_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureMiddleNameIsMutable();
            middleName_.addAll(other.middleName_);
          }
          onChanged();
        }
        if (other.hasAge()) {
          setAge(other.getAge());
        }
        if (other.hasEmailAddress()) {
          bitField0_ |= 0x00000010;
          emailAddress_ = other.emailAddress_;
          onChanged();
        }
        if (other.hasPassword()) {
          setPassword(other.getPassword());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        olle.proto.PersonProto.PersonMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (olle.proto.PersonProto.PersonMessage) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object firstName_ = "";
      /**
       * <code>optional string firstName = 1;</code>
       */
      public boolean hasFirstName() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional string firstName = 1;</code>
       */
      public java.lang.String getFirstName() {
        java.lang.Object ref = firstName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            firstName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string firstName = 1;</code>
       */
      public com.google.protobuf.ByteString
          getFirstNameBytes() {
        java.lang.Object ref = firstName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          firstName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string firstName = 1;</code>
       */
      public Builder setFirstName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        firstName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string firstName = 1;</code>
       */
      public Builder clearFirstName() {
        bitField0_ = (bitField0_ & ~0x00000001);
        firstName_ = getDefaultInstance().getFirstName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string firstName = 1;</code>
       */
      public Builder setFirstNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        firstName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object lastName_ = "";
      /**
       * <code>optional string lastName = 2;</code>
       */
      public boolean hasLastName() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string lastName = 2;</code>
       */
      public java.lang.String getLastName() {
        java.lang.Object ref = lastName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            lastName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string lastName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getLastNameBytes() {
        java.lang.Object ref = lastName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          lastName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string lastName = 2;</code>
       */
      public Builder setLastName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        lastName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string lastName = 2;</code>
       */
      public Builder clearLastName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        lastName_ = getDefaultInstance().getLastName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string lastName = 2;</code>
       */
      public Builder setLastNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        lastName_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringList middleName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureMiddleNameIsMutable() {
        if (!((bitField0_ & 0x00000004) == 0x00000004)) {
          middleName_ = new com.google.protobuf.LazyStringArrayList(middleName_);
          bitField0_ |= 0x00000004;
         }
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public com.google.protobuf.ProtocolStringList
          getMiddleNameList() {
        return middleName_.getUnmodifiableView();
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public int getMiddleNameCount() {
        return middleName_.size();
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public java.lang.String getMiddleName(int index) {
        return middleName_.get(index);
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public com.google.protobuf.ByteString
          getMiddleNameBytes(int index) {
        return middleName_.getByteString(index);
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public Builder setMiddleName(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureMiddleNameIsMutable();
        middleName_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public Builder addMiddleName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureMiddleNameIsMutable();
        middleName_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public Builder addAllMiddleName(
          java.lang.Iterable<java.lang.String> values) {
        ensureMiddleNameIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, middleName_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public Builder clearMiddleName() {
        middleName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string middleName = 3;</code>
       */
      public Builder addMiddleNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureMiddleNameIsMutable();
        middleName_.add(value);
        onChanged();
        return this;
      }

      private int age_ ;
      /**
       * <code>optional int32 age = 4;</code>
       */
      public boolean hasAge() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional int32 age = 4;</code>
       */
      public int getAge() {
        return age_;
      }
      /**
       * <code>optional int32 age = 4;</code>
       */
      public Builder setAge(int value) {
        bitField0_ |= 0x00000008;
        age_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 age = 4;</code>
       */
      public Builder clearAge() {
        bitField0_ = (bitField0_ & ~0x00000008);
        age_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object emailAddress_ = "";
      /**
       * <code>optional string emailAddress = 5;</code>
       */
      public boolean hasEmailAddress() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional string emailAddress = 5;</code>
       */
      public java.lang.String getEmailAddress() {
        java.lang.Object ref = emailAddress_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            emailAddress_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string emailAddress = 5;</code>
       */
      public com.google.protobuf.ByteString
          getEmailAddressBytes() {
        java.lang.Object ref = emailAddress_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          emailAddress_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string emailAddress = 5;</code>
       */
      public Builder setEmailAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        emailAddress_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string emailAddress = 5;</code>
       */
      public Builder clearEmailAddress() {
        bitField0_ = (bitField0_ & ~0x00000010);
        emailAddress_ = getDefaultInstance().getEmailAddress();
        onChanged();
        return this;
      }
      /**
       * <code>optional string emailAddress = 5;</code>
       */
      public Builder setEmailAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        emailAddress_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString password_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes password = 6;</code>
       */
      public boolean hasPassword() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      /**
       * <code>optional bytes password = 6;</code>
       */
      public com.google.protobuf.ByteString getPassword() {
        return password_;
      }
      /**
       * <code>optional bytes password = 6;</code>
       */
      public Builder setPassword(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
        password_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes password = 6;</code>
       */
      public Builder clearPassword() {
        bitField0_ = (bitField0_ & ~0x00000020);
        password_ = getDefaultInstance().getPassword();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:olle.PersonMessage)
    }

    static {
      defaultInstance = new PersonMessage(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:olle.PersonMessage)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_olle_PersonMessage_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_olle_PersonMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036src/test/protobuf/person.proto\022\004olle\"}" +
      "\n\rPersonMessage\022\021\n\tfirstName\030\001 \001(\t\022\020\n\010la" +
      "stName\030\002 \001(\t\022\022\n\nmiddleName\030\003 \003(\t\022\013\n\003age\030" +
      "\004 \001(\005\022\024\n\014emailAddress\030\005 \001(\t\022\020\n\010password\030" +
      "\006 \001(\014B\033\n\nolle.protoB\013PersonProtoH\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_olle_PersonMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_olle_PersonMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_olle_PersonMessage_descriptor,
        new java.lang.String[] { "FirstName", "LastName", "MiddleName", "Age", "EmailAddress", "Password", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}