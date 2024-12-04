/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.wandrillecorp.avro.message;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** A view over all messages */
@org.apache.avro.specific.AvroGenerated
public class MessageAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8833395312118001067L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MessageAvro\",\"namespace\":\"com.wandrillecorp.avro.message\",\"doc\":\"A view over all messages\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"text\",\"type\":\"string\"},{\"name\":\"userId\",\"type\":\"string\"},{\"name\":\"userName\",\"type\":\"string\"},{\"name\":\"roomId\",\"type\":\"string\"},{\"name\":\"createdDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<MessageAvro> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MessageAvro> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<MessageAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<MessageAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<MessageAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this MessageAvro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a MessageAvro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a MessageAvro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static MessageAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private java.lang.CharSequence text;
  private java.lang.CharSequence userId;
  private java.lang.CharSequence userName;
  private java.lang.CharSequence roomId;
  private java.time.Instant createdDate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MessageAvro() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param text The new value for text
   * @param userId The new value for userId
   * @param userName The new value for userName
   * @param roomId The new value for roomId
   * @param createdDate The new value for createdDate
   */
  public MessageAvro(java.lang.CharSequence id, java.lang.CharSequence text, java.lang.CharSequence userId, java.lang.CharSequence userName, java.lang.CharSequence roomId, java.time.Instant createdDate) {
    this.id = id;
    this.text = text;
    this.userId = userId;
    this.userName = userName;
    this.roomId = roomId;
    this.createdDate = createdDate.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return text;
    case 2: return userId;
    case 3: return userName;
    case 4: return roomId;
    case 5: return createdDate;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: text = (java.lang.CharSequence)value$; break;
    case 2: userId = (java.lang.CharSequence)value$; break;
    case 3: userName = (java.lang.CharSequence)value$; break;
    case 4: roomId = (java.lang.CharSequence)value$; break;
    case 5: createdDate = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'text' field.
   * @return The value of the 'text' field.
   */
  public java.lang.CharSequence getText() {
    return text;
  }


  /**
   * Sets the value of the 'text' field.
   * @param value the value to set.
   */
  public void setText(java.lang.CharSequence value) {
    this.text = value;
  }

  /**
   * Gets the value of the 'userId' field.
   * @return The value of the 'userId' field.
   */
  public java.lang.CharSequence getUserId() {
    return userId;
  }


  /**
   * Sets the value of the 'userId' field.
   * @param value the value to set.
   */
  public void setUserId(java.lang.CharSequence value) {
    this.userId = value;
  }

  /**
   * Gets the value of the 'userName' field.
   * @return The value of the 'userName' field.
   */
  public java.lang.CharSequence getUserName() {
    return userName;
  }


  /**
   * Sets the value of the 'userName' field.
   * @param value the value to set.
   */
  public void setUserName(java.lang.CharSequence value) {
    this.userName = value;
  }

  /**
   * Gets the value of the 'roomId' field.
   * @return The value of the 'roomId' field.
   */
  public java.lang.CharSequence getRoomId() {
    return roomId;
  }


  /**
   * Sets the value of the 'roomId' field.
   * @param value the value to set.
   */
  public void setRoomId(java.lang.CharSequence value) {
    this.roomId = value;
  }

  /**
   * Gets the value of the 'createdDate' field.
   * @return The value of the 'createdDate' field.
   */
  public java.time.Instant getCreatedDate() {
    return createdDate;
  }


  /**
   * Sets the value of the 'createdDate' field.
   * @param value the value to set.
   */
  public void setCreatedDate(java.time.Instant value) {
    this.createdDate = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new MessageAvro RecordBuilder.
   * @return A new MessageAvro RecordBuilder
   */
  public static com.wandrillecorp.avro.message.MessageAvro.Builder newBuilder() {
    return new com.wandrillecorp.avro.message.MessageAvro.Builder();
  }

  /**
   * Creates a new MessageAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MessageAvro RecordBuilder
   */
  public static com.wandrillecorp.avro.message.MessageAvro.Builder newBuilder(com.wandrillecorp.avro.message.MessageAvro.Builder other) {
    if (other == null) {
      return new com.wandrillecorp.avro.message.MessageAvro.Builder();
    } else {
      return new com.wandrillecorp.avro.message.MessageAvro.Builder(other);
    }
  }

  /**
   * Creates a new MessageAvro RecordBuilder by copying an existing MessageAvro instance.
   * @param other The existing instance to copy.
   * @return A new MessageAvro RecordBuilder
   */
  public static com.wandrillecorp.avro.message.MessageAvro.Builder newBuilder(com.wandrillecorp.avro.message.MessageAvro other) {
    if (other == null) {
      return new com.wandrillecorp.avro.message.MessageAvro.Builder();
    } else {
      return new com.wandrillecorp.avro.message.MessageAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for MessageAvro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MessageAvro>
    implements org.apache.avro.data.RecordBuilder<MessageAvro> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence text;
    private java.lang.CharSequence userId;
    private java.lang.CharSequence userName;
    private java.lang.CharSequence roomId;
    private java.time.Instant createdDate;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.wandrillecorp.avro.message.MessageAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.text)) {
        this.text = data().deepCopy(fields()[1].schema(), other.text);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.userId)) {
        this.userId = data().deepCopy(fields()[2].schema(), other.userId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.userName)) {
        this.userName = data().deepCopy(fields()[3].schema(), other.userName);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.roomId)) {
        this.roomId = data().deepCopy(fields()[4].schema(), other.roomId);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.createdDate)) {
        this.createdDate = data().deepCopy(fields()[5].schema(), other.createdDate);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing MessageAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(com.wandrillecorp.avro.message.MessageAvro other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.text)) {
        this.text = data().deepCopy(fields()[1].schema(), other.text);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.userId)) {
        this.userId = data().deepCopy(fields()[2].schema(), other.userId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.userName)) {
        this.userName = data().deepCopy(fields()[3].schema(), other.userName);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.roomId)) {
        this.roomId = data().deepCopy(fields()[4].schema(), other.roomId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.createdDate)) {
        this.createdDate = data().deepCopy(fields()[5].schema(), other.createdDate);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'text' field.
      * @return The value.
      */
    public java.lang.CharSequence getText() {
      return text;
    }


    /**
      * Sets the value of the 'text' field.
      * @param value The value of 'text'.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder setText(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.text = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'text' field has been set.
      * @return True if the 'text' field has been set, false otherwise.
      */
    public boolean hasText() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'text' field.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder clearText() {
      text = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'userId' field.
      * @return The value.
      */
    public java.lang.CharSequence getUserId() {
      return userId;
    }


    /**
      * Sets the value of the 'userId' field.
      * @param value The value of 'userId'.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder setUserId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.userId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'userId' field has been set.
      * @return True if the 'userId' field has been set, false otherwise.
      */
    public boolean hasUserId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'userId' field.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder clearUserId() {
      userId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'userName' field.
      * @return The value.
      */
    public java.lang.CharSequence getUserName() {
      return userName;
    }


    /**
      * Sets the value of the 'userName' field.
      * @param value The value of 'userName'.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder setUserName(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.userName = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'userName' field has been set.
      * @return True if the 'userName' field has been set, false otherwise.
      */
    public boolean hasUserName() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'userName' field.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder clearUserName() {
      userName = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'roomId' field.
      * @return The value.
      */
    public java.lang.CharSequence getRoomId() {
      return roomId;
    }


    /**
      * Sets the value of the 'roomId' field.
      * @param value The value of 'roomId'.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder setRoomId(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.roomId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'roomId' field has been set.
      * @return True if the 'roomId' field has been set, false otherwise.
      */
    public boolean hasRoomId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'roomId' field.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder clearRoomId() {
      roomId = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdDate' field.
      * @return The value.
      */
    public java.time.Instant getCreatedDate() {
      return createdDate;
    }


    /**
      * Sets the value of the 'createdDate' field.
      * @param value The value of 'createdDate'.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder setCreatedDate(java.time.Instant value) {
      validate(fields()[5], value);
      this.createdDate = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'createdDate' field has been set.
      * @return True if the 'createdDate' field has been set, false otherwise.
      */
    public boolean hasCreatedDate() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'createdDate' field.
      * @return This builder.
      */
    public com.wandrillecorp.avro.message.MessageAvro.Builder clearCreatedDate() {
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MessageAvro build() {
      try {
        MessageAvro record = new MessageAvro();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.text = fieldSetFlags()[1] ? this.text : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.userId = fieldSetFlags()[2] ? this.userId : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.userName = fieldSetFlags()[3] ? this.userName : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.roomId = fieldSetFlags()[4] ? this.roomId : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.createdDate = fieldSetFlags()[5] ? this.createdDate : (java.time.Instant) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MessageAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<MessageAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MessageAvro>
    READER$ = (org.apache.avro.io.DatumReader<MessageAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}









