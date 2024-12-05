package com.estivy.sokkerarchitect.util;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.content.res.AssetManager;

import androidx.test.platform.app.InstrumentationRegistry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface FileMapperUtil {

    ObjectMapper objectMapper = new ObjectMapper();

    static <T> T mapJsonFileToClass(String file, TypeReference<T> valueTypeRef)
            throws IOException {
        try(InputStream inputStream = getAssets().open(file)) {
            return objectMapper.readValue(inputStream, valueTypeRef);
        }
    }

    static AssetManager getAssets() {
        return getInstrumentation().getContext().getResources().getAssets();
    }


}
