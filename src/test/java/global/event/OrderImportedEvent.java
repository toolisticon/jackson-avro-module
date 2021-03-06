/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package global.event;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

/** A new order has been imported. Order ID ... */
@org.apache.avro.specific.AvroGenerated
public class OrderImportedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5969418367624861204L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderImportedEvent\",\"namespace\":\"global.event\",\"doc\":\"A new order has been imported. Order ID ...\",\"fields\":[{\"name\":\"orderId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"customer\",\"type\":{\"type\":\"record\",\"name\":\"Customer\",\"namespace\":\"global.model\",\"doc\":\"A customer\",\"fields\":[{\"name\":\"billingAddress\",\"type\":{\"type\":\"record\",\"name\":\"Address\",\"doc\":\"An address\",\"fields\":[{\"name\":\"street\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"city\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"number\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"zip\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"country\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"}]}},{\"name\":\"deliveryAddress\",\"type\":\"Address\"},{\"name\":\"mailAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"phoneNumber\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"}]}},{\"name\":\"comment\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"orderPositions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"OrderPosition\",\"namespace\":\"global.model\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"itemNumber\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"}]}}}],\"revision\":\"1\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OrderImportedEvent> ENCODER =
      new BinaryMessageEncoder<OrderImportedEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrderImportedEvent> DECODER =
      new BinaryMessageDecoder<OrderImportedEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrderImportedEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrderImportedEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrderImportedEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OrderImportedEvent>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrderImportedEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrderImportedEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrderImportedEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrderImportedEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private String orderId;
  private global.model.Customer customer;
  private String comment;
  private java.util.List<global.model.OrderPosition> orderPositions;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrderImportedEvent() {}

  /**
   * All-args constructor.
   * @param orderId The new value for orderId
   * @param customer The new value for customer
   * @param comment The new value for comment
   * @param orderPositions The new value for orderPositions
   */
  public OrderImportedEvent(String orderId, global.model.Customer customer, String comment, java.util.List<global.model.OrderPosition> orderPositions) {
    this.orderId = orderId;
    this.customer = customer;
    this.comment = comment;
    this.orderPositions = orderPositions;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return orderId;
    case 1: return customer;
    case 2: return comment;
    case 3: return orderPositions;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: orderId = value$ != null ? value$.toString() : null; break;
    case 1: customer = (global.model.Customer)value$; break;
    case 2: comment = value$ != null ? value$.toString() : null; break;
    case 3: orderPositions = (java.util.List<global.model.OrderPosition>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'orderId' field.
   * @return The value of the 'orderId' field.
   */
  public String getOrderId() {
    return orderId;
  }


  /**
   * Sets the value of the 'orderId' field.
   * @param value the value to set.
   */
  public void setOrderId(String value) {
    this.orderId = value;
  }

  /**
   * Gets the value of the 'customer' field.
   * @return The value of the 'customer' field.
   */
  public global.model.Customer getCustomer() {
    return customer;
  }


  /**
   * Sets the value of the 'customer' field.
   * @param value the value to set.
   */
  public void setCustomer(global.model.Customer value) {
    this.customer = value;
  }

  /**
   * Gets the value of the 'comment' field.
   * @return The value of the 'comment' field.
   */
  public String getComment() {
    return comment;
  }


  /**
   * Sets the value of the 'comment' field.
   * @param value the value to set.
   */
  public void setComment(String value) {
    this.comment = value;
  }

  /**
   * Gets the value of the 'orderPositions' field.
   * @return The value of the 'orderPositions' field.
   */
  public java.util.List<global.model.OrderPosition> getOrderPositions() {
    return orderPositions;
  }


  /**
   * Sets the value of the 'orderPositions' field.
   * @param value the value to set.
   */
  public void setOrderPositions(java.util.List<global.model.OrderPosition> value) {
    this.orderPositions = value;
  }

  /**
   * Creates a new OrderImportedEvent RecordBuilder.
   * @return A new OrderImportedEvent RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new OrderImportedEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrderImportedEvent RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * Creates a new OrderImportedEvent RecordBuilder by copying an existing OrderImportedEvent instance.
   * @param other The existing instance to copy.
   * @return A new OrderImportedEvent RecordBuilder
   */
  public static Builder newBuilder(OrderImportedEvent other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * RecordBuilder for OrderImportedEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderImportedEvent>
    implements org.apache.avro.data.RecordBuilder<OrderImportedEvent> {

    private String orderId;
    private global.model.Customer customer;
    private global.model.Customer.Builder customerBuilder;
    private String comment;
    private java.util.List<global.model.OrderPosition> orderPositions;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.orderId)) {
        this.orderId = data().deepCopy(fields()[0].schema(), other.orderId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.customer)) {
        this.customer = data().deepCopy(fields()[1].schema(), other.customer);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasCustomerBuilder()) {
        this.customerBuilder = global.model.Customer.newBuilder(other.getCustomerBuilder());
      }
      if (isValidValue(fields()[2], other.comment)) {
        this.comment = data().deepCopy(fields()[2].schema(), other.comment);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.orderPositions)) {
        this.orderPositions = data().deepCopy(fields()[3].schema(), other.orderPositions);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing OrderImportedEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(OrderImportedEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.orderId)) {
        this.orderId = data().deepCopy(fields()[0].schema(), other.orderId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.customer)) {
        this.customer = data().deepCopy(fields()[1].schema(), other.customer);
        fieldSetFlags()[1] = true;
      }
      this.customerBuilder = null;
      if (isValidValue(fields()[2], other.comment)) {
        this.comment = data().deepCopy(fields()[2].schema(), other.comment);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.orderPositions)) {
        this.orderPositions = data().deepCopy(fields()[3].schema(), other.orderPositions);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'orderId' field.
      * @return The value.
      */
    public String getOrderId() {
      return orderId;
    }


    /**
      * Sets the value of the 'orderId' field.
      * @param value The value of 'orderId'.
      * @return This builder.
      */
    public Builder setOrderId(String value) {
      validate(fields()[0], value);
      this.orderId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'orderId' field has been set.
      * @return True if the 'orderId' field has been set, false otherwise.
      */
    public boolean hasOrderId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'orderId' field.
      * @return This builder.
      */
    public Builder clearOrderId() {
      orderId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'customer' field.
      * @return The value.
      */
    public global.model.Customer getCustomer() {
      return customer;
    }


    /**
      * Sets the value of the 'customer' field.
      * @param value The value of 'customer'.
      * @return This builder.
      */
    public Builder setCustomer(global.model.Customer value) {
      validate(fields()[1], value);
      this.customerBuilder = null;
      this.customer = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'customer' field has been set.
      * @return True if the 'customer' field has been set, false otherwise.
      */
    public boolean hasCustomer() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'customer' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public global.model.Customer.Builder getCustomerBuilder() {
      if (customerBuilder == null) {
        if (hasCustomer()) {
          setCustomerBuilder(global.model.Customer.newBuilder(customer));
        } else {
          setCustomerBuilder(global.model.Customer.newBuilder());
        }
      }
      return customerBuilder;
    }

    /**
     * Sets the Builder instance for the 'customer' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public Builder setCustomerBuilder(global.model.Customer.Builder value) {
      clearCustomer();
      customerBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'customer' field has an active Builder instance
     * @return True if the 'customer' field has an active Builder instance
     */
    public boolean hasCustomerBuilder() {
      return customerBuilder != null;
    }

    /**
      * Clears the value of the 'customer' field.
      * @return This builder.
      */
    public Builder clearCustomer() {
      customer = null;
      customerBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'comment' field.
      * @return The value.
      */
    public String getComment() {
      return comment;
    }


    /**
      * Sets the value of the 'comment' field.
      * @param value The value of 'comment'.
      * @return This builder.
      */
    public Builder setComment(String value) {
      validate(fields()[2], value);
      this.comment = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'comment' field has been set.
      * @return True if the 'comment' field has been set, false otherwise.
      */
    public boolean hasComment() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'comment' field.
      * @return This builder.
      */
    public Builder clearComment() {
      comment = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderPositions' field.
      * @return The value.
      */
    public java.util.List<global.model.OrderPosition> getOrderPositions() {
      return orderPositions;
    }


    /**
      * Sets the value of the 'orderPositions' field.
      * @param value The value of 'orderPositions'.
      * @return This builder.
      */
    public Builder setOrderPositions(java.util.List<global.model.OrderPosition> value) {
      validate(fields()[3], value);
      this.orderPositions = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'orderPositions' field has been set.
      * @return True if the 'orderPositions' field has been set, false otherwise.
      */
    public boolean hasOrderPositions() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'orderPositions' field.
      * @return This builder.
      */
    public Builder clearOrderPositions() {
      orderPositions = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderImportedEvent build() {
      try {
        OrderImportedEvent record = new OrderImportedEvent();
        record.orderId = fieldSetFlags()[0] ? this.orderId : (String) defaultValue(fields()[0]);
        if (customerBuilder != null) {
          try {
            record.customer = this.customerBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("customer"));
            throw e;
          }
        } else {
          record.customer = fieldSetFlags()[1] ? this.customer : (global.model.Customer) defaultValue(fields()[1]);
        }
        record.comment = fieldSetFlags()[2] ? this.comment : (String) defaultValue(fields()[2]);
        record.orderPositions = fieldSetFlags()[3] ? this.orderPositions : (java.util.List<global.model.OrderPosition>) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrderImportedEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrderImportedEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrderImportedEvent>
    READER$ = (org.apache.avro.io.DatumReader<OrderImportedEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.orderId);

    this.customer.customEncode(out);

    out.writeString(this.comment);

    long size0 = this.orderPositions.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (global.model.OrderPosition e0: this.orderPositions) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.orderId = in.readString();

      if (this.customer == null) {
        this.customer = new global.model.Customer();
      }
      this.customer.customDecode(in);

      this.comment = in.readString();

      long size0 = in.readArrayStart();
      java.util.List<global.model.OrderPosition> a0 = this.orderPositions;
      if (a0 == null) {
        a0 = new SpecificData.Array<global.model.OrderPosition>((int)size0, SCHEMA$.getField("orderPositions").schema());
        this.orderPositions = a0;
      } else a0.clear();
      SpecificData.Array<global.model.OrderPosition> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<global.model.OrderPosition>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          global.model.OrderPosition e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new global.model.OrderPosition();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.orderId = in.readString();
          break;

        case 1:
          if (this.customer == null) {
            this.customer = new global.model.Customer();
          }
          this.customer.customDecode(in);
          break;

        case 2:
          this.comment = in.readString();
          break;

        case 3:
          long size0 = in.readArrayStart();
          java.util.List<global.model.OrderPosition> a0 = this.orderPositions;
          if (a0 == null) {
            a0 = new SpecificData.Array<global.model.OrderPosition>((int)size0, SCHEMA$.getField("orderPositions").schema());
            this.orderPositions = a0;
          } else a0.clear();
          SpecificData.Array<global.model.OrderPosition> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<global.model.OrderPosition>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              global.model.OrderPosition e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new global.model.OrderPosition();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










