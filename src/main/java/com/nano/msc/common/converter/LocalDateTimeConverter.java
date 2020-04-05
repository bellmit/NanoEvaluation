package com.nano.msc.common.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 日期转换器
 *
 * @author luoxin
 * @version V1.0
 * @date 2019/10/29
 * Description:
 */
public class LocalDateTimeConverter extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000L);
    }
}