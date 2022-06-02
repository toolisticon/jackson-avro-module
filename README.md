# jackson-avro-module

A jackson-module that allows serializing and deserializing generated avro specific record instances with the jackson ObjectMapper. 

[![stable](https://img.shields.io/badge/lifecycle-STABLE-green.svg)](https://github.com/holisticon#open-source-lifecycle)
[![Build Status](https://github.com/toolisticon/jackson-avro-module/workflows/Development%20branches/badge.svg)](https://github.com/toolisticon/jackson-avro-module/actions)
[![sponsored](https://img.shields.io/badge/sponsoredBy-Holisticon-RED.svg)](https://holisticon.de/)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.toolisticon.jackson.module/jackson-avro-module/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.toolisticon.jackson.module/jackson-avro-module)

## The problem

If you define your schema in avro and generate a class using the avro generator, the generated class contains fields (`schema`, `specificData`)
that can not be serialized by the default jackson ObjectMapper.

## Non working workarounds

* avro itself provides a `JacksonUtils` class that can ignore fields based on visibility. Problem: The feature is hidden and modifies the global `ObjectMapper`, so a change only required for `SpecificRecordBase` classes will affect all.
* jackson on the other hand provides the `com.fasterxml.jackson.dataformat.avro.AvroSerializerModifier`, but this one just ignores (current version 2.13.1) just one of the two needed properties.

## The solution

This library provides a single [`JacksonAvroModule`](./src/main/kotlin/JacksonAvroModule.kt) that uses a modified version of the `jackson-databind-avro` modifier to exclude bean properties from serialization. 

## How to use

It is as simple as adding any other jackson-module to your `ObjectMapper` configuration:

```
ObjectMapper om = new ObjectMapper()
                      .registerModule(new JacksonAvroModule());
```
