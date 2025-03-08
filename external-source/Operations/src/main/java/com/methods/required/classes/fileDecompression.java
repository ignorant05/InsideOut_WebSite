package com.methods.required.classes;

import java.io.File;
import java.io.IOException;

public interface fileDecompression {
    File decompress(byte[] compressedData, String output) throws IOException;
}