package io.toolisticon.jackson.module

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import global.event.OrderImportedEvent
import global.model.Address
import global.model.Customer
import global.model.OrderPosition
import mu.KLogging
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class JacksonAvroModuleTest {
  companion object : KLogging()

  private val addressBuilder: Address.Builder = Address.newBuilder()
    .setCity("Hamburg")
    .setCountry("Deutschland")
    .setNumber("23a")
    .setStreet("Musterstrasse")
    .setZip("22049")

  private val customerBuilder: Customer.Builder = Customer.newBuilder()
    .setBillingAddressBuilder(addressBuilder)
    .setDeliveryAddressBuilder(addressBuilder)
    .setMailAddress("bla@blub.com")
    .setPhoneNumber("+492103987")

  private val eventBuilder: OrderImportedEvent.Builder = OrderImportedEvent.newBuilder()
    .setOrderId("testOrderId")
    .setComment("testComment")
    .setCustomerBuilder(customerBuilder)
    .setOrderPositions(
      listOf(
        OrderPosition.newBuilder()
          .setName("pos1")
          .setItemNumber("item1").build()
      )
    )

  @Test
  internal fun `can serialize and deserialize with the global config`() {
    val event = eventBuilder.build()
    val om = JacksonAvroModule.configureObjectMapper(jacksonObjectMapper())

    val json = om.writeValueAsString(event)
    val fromJson = om.readValue<OrderImportedEvent>(json)

    assertThat(fromJson).isEqualTo(event)
  }

  @Test
  fun `can serialize and deserialize using avro module`() {
    val avroModule = JacksonAvroModule()
    val om = jacksonObjectMapper().registerModule(avroModule)

    val event = eventBuilder.build()

    val json = om.writeValueAsString(event)

    logger.info { "json: $json" }

    val fromJson = om.readValue<OrderImportedEvent>(json)

    assertThat(fromJson).isEqualTo(event)
  }

  @Test
  internal fun `does not remove property from regular class`() {
    val avroModule = JacksonAvroModule()
    val om = jacksonObjectMapper().registerModule(avroModule)

    val foo = Foo(schema = "hello", specificData = "world")

    assertThat(om.writeValueAsString(foo)).isEqualTo("""{"schema":"hello","specificData":"world"}""")
  }


}

internal data class Foo(val schema:String, val specificData:String)
