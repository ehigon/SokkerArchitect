package com.estivy.sokkerarchitect.external.api.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tickaroo.tikxml.TikXml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import okio.Buffer;

public interface FileMapperUtil {

    TikXml parser = new TikXml.Builder()
            .exceptionOnUnreadXml(false)
            .build();

    ObjectMapper objectMapper = new ObjectMapper();

    static <T> T mapXmlFileToClass(String file, Class<T> clazz) throws IOException {
        try (Buffer buffer = new Buffer(); InputStream inputStream =
                Files.newInputStream(Paths.get("./src/test/res/" + file))) {

            buffer.readFrom(inputStream);
            return parser.read(buffer, clazz);
        }
    }

    static <T> T mapJsonFileToClass(String file, TypeReference<T> valueTypeRef)
            throws IOException {
        try(InputStream inputStream = Files.newInputStream(Paths.get("./src/test/res/" + file))) {
            return objectMapper.readValue(inputStream, valueTypeRef);
        }
    }

}
