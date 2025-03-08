package com.methods.required.classes.Implementations;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.methods.required.classes.fileCompression;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream;
import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;


public class fileCompressionImpl implements fileCompression {
    @Override
    public byte[] compress(byte[] inputData) throws IOException {
        return null;
    }

    public static class ZipCompression implements fileCompression {
        @Override
        public byte[] compress(byte[] inputData) throws IOException {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 ZipOutputStream zos = new ZipOutputStream(baos))
            {
                ZipEntry zipEntry = new ZipEntry("file.txt");
                zos.putNextEntry(zipEntry);
                zos.write(inputData);
                zos.closeEntry();
                zos.finish();

                return baos.toByteArray();
            }
        }
    }

    public static class GzCompression implements fileCompression {
        @Override
        public byte[] compress(byte[] inputData)throws IOException{
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 GZIPOutputStream gos = new GZIPOutputStream(baos))
            {
                gos.write(inputData);
                gos.finish();

                return baos.toByteArray();
            }
            catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static class Bzip2Compress implements fileCompression {
        @Override
        public byte[] compress(byte[] inputData)throws IOException{

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 BZip2CompressorOutputStream bzos = new BZip2CompressorOutputStream(baos)){

                bzos.write(inputData);
                bzos.finish();

                return baos.toByteArray();
            }
            catch (IOException e){
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static class XZCompress implements fileCompression {
        @Override
        public byte[] compress(byte[] inputData) throws IOException{

            try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ByteArrayInputStream bais = new ByteArrayInputStream(inputData);
                XZOutputStream xzOut = new XZOutputStream(baos, new LZMA2Options()))
            {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = bais.read(buffer)) != -1) {
                    xzOut.write(buffer, 0, length);
                }
                xzOut.finish();
                return baos.toByteArray();
            }
            catch (IOException e){
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static class TarCompress implements fileCompression {
        @Override
        public byte[] compress(byte[] inputData) throws IOException {

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 TarArchiveOutputStream taros = new TarArchiveOutputStream(baos))
            {
                TarArchiveEntry TarEntry = new TarArchiveEntry("compressedData");
                TarEntry.setSize(inputData.length);
                taros.putArchiveEntry(TarEntry);
                taros.write(inputData);
                taros.closeArchiveEntry();
                taros.finish();

                return baos.toByteArray();
            }
            catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static class lz4Compress implements fileCompression {
        @Override
        public byte[] compress(byte[] inputData) throws IOException{

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 BlockLZ4CompressorOutputStream lz4os = new BlockLZ4CompressorOutputStream(baos))
            {
                lz4os.write(inputData);

                return baos.toByteArray();
            }
            catch (IOException e){
                e.printStackTrace();
                throw e ;
            }
        }
    }

    public static class lzmaCompress implements fileCompression {
        @Override
        public byte[] compress(byte[] inputData) throws IOException{

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 LZMACompressorOutputStream lzmaos = new LZMACompressorOutputStream(baos))
            {
                lzmaos.write(inputData);

                return baos.toByteArray();
            }
            catch (IOException e){
                e.printStackTrace();
                throw e ;
            }
        }
    }
}



