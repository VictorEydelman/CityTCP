package Server.src.main.java.read;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class sendserver {
    static Logger logger = LogManager.getLogger(sendserver.class);
    public static void send(Object o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        //ObjectOutputStream out = new ObjectOutputStream(write.getc().getOutputStream());
        out.writeObject(o);
        byte[] data = bos.toByteArray();
        write.getClient().write(ByteBuffer.wrap(data));
        logger.info("Команда отправлена клиенту");
    }
}
