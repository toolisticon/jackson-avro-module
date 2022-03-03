package io.toolisticon.jackson.module

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.core.util.VersionUtil
import com.fasterxml.jackson.databind.BeanDescription
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationConfig
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier
import org.apache.avro.specific.SpecificRecordBase

class JacksonAvroModule : SimpleModule(NAME, VERSION_SUPPLIER()) {
  companion object {
    const val NAME = "JacksonAvroModule"
    private val VERSION_SUPPLIER: () -> Version = { VersionUtil.versionFor(JacksonAvroModule::class.java) }

    val IGNORED_PROPERTIES = setOf<String>("schema", "specificData")

    /**
     * An [com.fasterxml.jackson.databind.ObjectMapper] configuration that copies the global visibility settings
     * from [org.apache.avro.util.internal.JacksonUtils.objectToMap].
     * With this mapper, serialization and deserialization of [SpecificRecordBase] instances works out of the box.
     *
     * Hint: usage is discouraged since this OM uses global setting that not only apply to [SpecificRecordBase].
     */
    fun configureObjectMapper(om: ObjectMapper) = om.apply {
      setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
      setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
    }

    fun isSpecificRecordBase(beanDesc: BeanDescription) = SpecificRecordBase::class.java.isAssignableFrom(beanDesc.classInfo.rawType)
  }

  init {
    this.setSerializerModifier(IgnorePropertiesBeanSerializerModifier)
  }

  override fun toString(): String = "$moduleName{version=${version()}}"

  /**
   * The implementation is copied from `com.fasterxml.jackson.dataformat.avro.AvroSerializerModifier`
   * but their implementation just excludes `schema` not `specificData`
   */
  object IgnorePropertiesBeanSerializerModifier : BeanSerializerModifier() {
    override fun changeProperties(
      config: SerializationConfig, beanDesc: BeanDescription, beanProperties: List<BeanPropertyWriter>
    ): List<BeanPropertyWriter> = if (JacksonAvroModule.isSpecificRecordBase(beanDesc))
      beanProperties.filterNot { JacksonAvroModule.IGNORED_PROPERTIES.contains(it.name) }.toList()
    else
      beanProperties
  }
}


