package com.dynamic.interview.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author xinghuajian
 * @description NIO读取file
 * @date 2019/10/22 14:39
 */
public class NioTest {

    public static void nioCopyFile(String resource, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int len = readChannel.read(buffer);
            if (len == -1) {
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }

    /**
     * steps to use Buffer
     * 1.Write data into the Buffer
     * 2.Call buffer.flip()
     * 3.Read data out of the Buffer
     * 4.Call buffer.clear() or buffer.compact()
     * @throws IOException
     */
    public static void byteBufferTest() throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("data/nio.txt", "rw");

        FileChannel inChannel = randomAccessFile.getChannel();

        // create buffer with capacity of 48 bytes
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        // read into buffer from the inChannel
        int bytesRead = inChannel.read(byteBuffer);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            // make buffer ready for reading
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                // read 1 byte at a time
                System.out.println((char) byteBuffer.get());
            }
            /**
             *  make buffer ready for writing again ,call The clear() method or The compact() method
             *  The clear() method clears the whole buffer
             *  The compact() method only clears the data which you have already read.
             *  Any unread data is moved to the beginning of the buffer, and data will now be written into the buffer after the unread data
             */
            byteBuffer.clear();
            bytesRead = inChannel.read(byteBuffer);
        }
        inChannel.close();
        randomAccessFile.close();
    }
}
