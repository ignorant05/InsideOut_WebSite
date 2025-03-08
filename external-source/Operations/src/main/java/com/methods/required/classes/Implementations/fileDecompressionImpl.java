package com.methods.required.classes.Implementations;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

import com.methods.required.classes.fileDecompression ;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;

public class fileDecompressionImpl implements fileDecompression  {
    static final int BUFFER_SIZE = 8192;
    @Override
    public File decompress(byte[] compressedData, String output) throws IOException {
        return null;
    }

    public static class UnZip implements fileDecompression  {
        File firstExtractedFile = null;
        @Override
        public File decompress(byte[] compressedData, String output) throws IOException {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
                 ZipInputStream zis = new ZipInputStream(bais)) {
                File outputFile = new File(output);
                byte[] buffer = new byte[BUFFER_SIZE];

                try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                    int length;
                    while ((length = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                }

                zis.closeEntry();
                return outputFile;

            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static class GunZip implements fileDecompression  {
        @Override
        public File decompress(byte[] compressedData, String output) throws IOException {

            File outputFile = new File(output);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
                 FileOutputStream fos= new FileOutputStream(output);
                 GzipCompressorInputStream gzis = new GzipCompressorInputStream(bais)) {
                byte[] buffer = new byte[BUFFER_SIZE];
                int length ;

                while((length=gzis.read(buffer))>0){
                    fos.write(buffer, 0, length);
                }
            }
            catch (IOException e){
                e.printStackTrace();
                throw e ;
            }
            return outputFile ;
        }
    }

    public static class UnBzip2 implements fileDecompression  {
        @Override
        public File decompress(byte[] compressedData, String output) throws IOException {

            File outputFile = new File(output);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
                 FileOutputStream fos = new FileOutputStream(output);
                 BZip2CompressorInputStream bz2is = new BZip2CompressorInputStream(bais)){

                if (!outputFile.exists()){
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int length;

                    while((length=bz2is.read(buffer))>0){
                        fos.write(buffer,0,length);
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
                throw e ;
            }
            return outputFile;
        }
    }

    public static class UnXZ implements fileDecompression  {
        @Override
        public File decompress(byte[] compressedData, String output ) throws IOException {

            File outputFile = new File(output);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
                 FileOutputStream fos= new FileOutputStream(output);
                 XZCompressorInputStream xzis = new XZCompressorInputStream (bais)) {

                if (!outputFile.exists()){
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int length ;

                    while((length=xzis.read(buffer))>0){
                        fos.write(buffer, 0, length);
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
                throw e ;
            }
            return outputFile ;
        }
    }

    public static class UnLz4 implements fileDecompression  {
        @Override
        public File decompress(byte[] compressedData, String output ) throws IOException {

            File outputFile = new File(output);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
                 FileOutputStream fos= new FileOutputStream(output);
                 BlockLZ4CompressorInputStream lz4is = new BlockLZ4CompressorInputStream (bais)) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int length ;

                while((length=lz4is.read(buffer))>0){
                    fos.write(buffer, 0, length);
                }
            } catch (IOException e){
                e.printStackTrace();
                throw e ;
            }
            return outputFile ;
        }
    }

    public static class UnLzma implements fileDecompression  {
        @Override
        public File decompress(byte[] compressedData, String output ) throws IOException {

            File outputFile = new File(output);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
                 FileOutputStream fos= new FileOutputStream(output);
                 LZMACompressorInputStream lzmais = new LZMACompressorInputStream (bais)) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int length ;

                while((length=lzmais.read(buffer))>0){
                    fos.write(buffer, 0, length);
                }
            } catch (IOException e){
                e.printStackTrace();
                throw e ;
            }
            return outputFile ;
        }
    }

    public static class UnTar implements fileDecompression  {
        @Override
        public File decompress(byte[] inputData, String output) throws IOException{

            try (ByteArrayInputStream bais = new ByteArrayInputStream(inputData);
                 TarArchiveInputStream tais = new TarArchiveInputStream(bais)){
                File outputFile = new File(output);
                byte[] buffer = new byte[BUFFER_SIZE];
                TarArchiveEntry entry;
                while((entry = tais.getNextEntry())!=null) {
                    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                        int length;
                        while ((length = tais.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                    return outputFile;
                }
                return null;

            } catch (IOException e){
                e.printStackTrace();
                throw e ;
            }
        }
    }

}







