package com.methods.required.classes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import com.methods.required.classes.Implementations.fileCompressionImpl;
import com.methods.required.classes.Implementations.fileDecompressionImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Operations {
    private static final Logger log = LoggerFactory.getLogger(Operations.class);

    public static void checkValidCompressedData(byte[] compressedData) {
        if (compressedData.length == 0) log.error("[-] Compression failed: no data was returned.");
    }

    public static void checkValidInputFileForDecompression(String fileName) {
        if (fileName.lastIndexOf(".")==-1) log.error("[-] Invalid file name: " + fileName);
    }

    public static void checkValidDecompressedFile(long len){
        if (len==0) log.error("[-] Decompression failed: no data was returned.");
    }

    public static File compressToZip (File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();
        String outputFileName = inputFile.getName() + ".zip";
        File outputFile = new File(outputFileName);

        byte[] inputFileData = Files.readAllBytes(inputPath);

        fileCompressionImpl.ZipCompression zipCompression = new fileCompressionImpl.ZipCompression();
        byte[] compressedData = zipCompression.compress(inputFileData);

        checkValidCompressedData(compressedData);

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(compressedData);
        }

        return outputFile;
    }

    public static File compressToTar(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();
        String outputFileName = inputFile.getName() + ".tar";
        File outputFile = new File(outputFileName);

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileCompressionImpl.TarCompress tarCompress = new fileCompressionImpl.TarCompress();
        byte[] compressedData = tarCompress.compress(inputFileData);

        checkValidCompressedData(compressedData);

        try(FileOutputStream fos=new FileOutputStream(outputFile)){
            fos.write(compressedData);
        }

        return outputFile;
    }

    public static File compressToXZ(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();
        String outputFileName= inputFile.getName() + ".xz";
        File outPutFile = new File(outputFileName);

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileCompressionImpl.XZCompress XZCompress = new fileCompressionImpl.XZCompress();
        byte[] compressedData = XZCompress.compress(inputFileData);

        checkValidCompressedData(compressedData);

        try(FileOutputStream fos = new FileOutputStream(outPutFile)){
            fos.write(compressedData);
        }

        return outPutFile;
    }

    public static File compressToGzip(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();
        String outputFileName = inputFile.getName() + ".gz";
        File outPutFile = new File(outputFileName);

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileCompressionImpl.GzCompression gzCompress = new fileCompressionImpl.GzCompression();
        byte[] compressedData = gzCompress.compress(inputFileData);

        checkValidCompressedData(compressedData);

        try(FileOutputStream fos=new FileOutputStream(outPutFile)){
            fos.write(compressedData);
        }

        return outPutFile;
    }

    public static File compressToBzip2(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();
        String outputFileName = inputFile.getName() + ".bz2";
        File outPutFile = new File(outputFileName);

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileCompressionImpl.Bzip2Compress bzip2Comp = new fileCompressionImpl.Bzip2Compress();
        byte[] compressedData = bzip2Comp.compress(inputFileData);

        checkValidCompressedData(compressedData);

        try(FileOutputStream fos=new FileOutputStream(outPutFile)){
            fos.write(compressedData);
        }

        return outPutFile;
    }

    public static File compressToLz4(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();
        String outputFileName = inputFile.getName() + ".lz4";
        File outPutFile = new File(outputFileName);

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileCompressionImpl.lz4Compress lz4Comp = new fileCompressionImpl.lz4Compress();
        byte[] compressedData = lz4Comp.compress(inputFileData);

        checkValidCompressedData(compressedData);

        try(FileOutputStream fos=new FileOutputStream(outPutFile)){
            fos.write(compressedData);
        }

        return outPutFile;
    }

    public static File compressToLzma(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();
        String outputFileName = inputFile.getName() + ".lzma";
        File outPutFile = new File(outputFileName);

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileCompressionImpl.lzmaCompress lzmaComp = new fileCompressionImpl.lzmaCompress();
        byte[] compressedData = lzmaComp.compress(inputFileData);

        checkValidCompressedData(compressedData);

        try(FileOutputStream fos=new FileOutputStream(outPutFile)){
            fos.write(compressedData);
        }

        return outPutFile;
    }

    public static File decompressFromZip(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();

        checkValidInputFileForDecompression(inputFile.getName());

        String outputFileName = inputFile.getName().substring(0,inputFile.getName().lastIndexOf("."));

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileDecompressionImpl.UnZip unzip = new fileDecompressionImpl.UnZip();
        File outputFile = unzip.decompress(inputFileData, outputFileName);

        checkValidDecompressedFile(outputFile.length());

        return outputFile;
    }

    public static File decompressFromGzip(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();

        checkValidInputFileForDecompression(inputFile.getName());
        
        String outputFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf("."));

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileDecompressionImpl.GunZip gunzip = new fileDecompressionImpl.GunZip();
        File outputFile = gunzip.decompress(inputFileData, outputFileName);

        checkValidDecompressedFile(outputFile.length());

        return outputFile;
    }

    public static File decompressFromBzip2(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();

        checkValidInputFileForDecompression(inputFile.getName());
        
        String outputFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf("."));

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileDecompressionImpl.UnBzip2 unbz2 = new fileDecompressionImpl.UnBzip2();
        File outputFile = unbz2.decompress(inputFileData, outputFileName);

        checkValidDecompressedFile(outputFile.length());
        
        return outputFile;
    }

    public static File decompressFromTar(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();

        checkValidInputFileForDecompression(inputFile.getName());

        String outputFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf("."));

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileDecompressionImpl.UnTar untar = new fileDecompressionImpl.UnTar();
        File outputFile = untar.decompress(inputFileData, outputFileName);

        checkValidDecompressedFile(outputFile.length());

        return outputFile;
    }

    public static File decompressFromXZ(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();

        checkValidInputFileForDecompression(inputFile.getName());

        String outputFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf("."));

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileDecompressionImpl.UnXZ unxz = new fileDecompressionImpl.UnXZ();
        File outputFile = unxz.decompress(inputFileData, outputFileName);

        checkValidDecompressedFile(outputFile.length());

        return outputFile;
    }

    public static File decompressFromLz4(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();

        checkValidInputFileForDecompression(inputFile.getName());

        String outputFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf("."));

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileDecompressionImpl.UnLz4 unlz4 = new fileDecompressionImpl.UnLz4();
        File outputFile = unlz4.decompress(inputFileData, outputFileName);

        checkValidDecompressedFile(outputFile.length());

        return outputFile;
    }

    public static File decompressFromLzma(File inputFile) throws Exception {
        Path inputPath = inputFile.toPath();

        checkValidInputFileForDecompression(inputFile.getName());

        String outputFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf("."));

        byte[] inputFileData = Files.readAllBytes(inputPath);
        fileDecompressionImpl.UnLzma unzlma = new fileDecompressionImpl.UnLzma();
        File outputFile = unzlma.decompress(inputFileData, outputFileName);

        checkValidDecompressedFile(outputFile.length());

        return outputFile;
    }

    public static void main(String[] args) {}
}

