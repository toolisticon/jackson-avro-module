package io.toolisticon.jackson.module;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import global.event.OrderImportedEvent;
import global.model.Address;
import global.model.Customer;
import global.model.OrderPosition;
import java.util.List;
import org.junit.jupiter.api.Test;

class JacksonAvroModuleJavaTest {

  private final Address.Builder addressBuilder = Address.newBuilder()
    .setCity("Hamburg")
    .setCountry("Deutschland")
    .setNumber("23a")
    .setStreet("Musterstrasse")
    .setZip("22049");

  private final Customer.Builder customerBuilder = Customer.newBuilder()
    .setBillingAddressBuilder(addressBuilder)
    .setDeliveryAddressBuilder(addressBuilder)
    .setMailAddress("bla@blub.com")
    .setPhoneNumber("+492103987");

  private final OrderImportedEvent.Builder eventBuilder = OrderImportedEvent.newBuilder()
    .setOrderId("testOrderId")
    .setComment("testComment")
    .setCustomerBuilder(customerBuilder)
    .setOrderPositions(
      List.of(
        OrderPosition.newBuilder()
          .setName("pos1")
          .setItemNumber("item1").build()
      )
    );


  @Test
  void serializing_using_module() throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper().registerModule(new JacksonAvroModule());

    OrderImportedEvent event = eventBuilder.build();

    String json = om.writeValueAsString(event);

    assertThat(om.readValue(json, OrderImportedEvent.class)).isEqualTo(event);
  }
}
