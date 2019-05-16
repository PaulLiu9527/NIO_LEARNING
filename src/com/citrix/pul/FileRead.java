package com.citrix.pul;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

import org.junit.Before;
import org.junit.Test;

public class FileRead {

	public RandomAccessFile aFile;
	public FileChannel inChannel;
	public ByteBuffer buf;

	@Before
	public void beforeTest() throws IOException {
		aFile = new RandomAccessFile("src\\com\\citrix\\pul\\nio-data.txt", "rw");
		inChannel = aFile.getChannel();
		buf = ByteBuffer.allocate(48);
	}

	@Test
	public void useBufferToRead() throws Exception {
		/*
		 * Remind: if you forget the different between absolute-path and relative-path,
		 * try this: File file =new File("/test.txt") //F:\test.txt File file =new
		 * File("test.txt") //F:\gitProject\NIO_LEARNING\test.txt
		 * system.out.println(file.getAbsolutePath());
		 */

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}

	@Test
	public void useBufferMoreToRead() throws Exception {
		inChannel.read(buf);
		buf.flip();
		System.out.println((char) buf.get());
		System.out.println(buf.position());
		System.out.println("....................");
		buf.rewind();
		System.out.println(buf.position());
		System.out.println((char)buf.get());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
