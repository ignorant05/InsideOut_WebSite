package com.methods.required.classes;

import java.io.IOException;

public interface fileCompression {
    byte[] compress(byte[] inputData) throws IOException;
}
