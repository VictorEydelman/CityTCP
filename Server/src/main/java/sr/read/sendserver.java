package sr.read;

import Serialized.SeriMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class sendserver {
    static Logger logger = LogManager.getLogger(sendserver.class);
    public static void send(String o) throws IOException {
        //System.out.println(1);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        //System.out.println(2);
        //ObjectOutputStream out = new ObjectOutputStream(write.getc().getOutputStream());
        out.writeObject(new SeriMessage(o));
        byte[] data = bos.toByteArray();
        write.getClient().write(ByteBuffer.wrap(data));
        //System.out.println(3);
        logger.info("Команда отправлена клиенту");
    }
}
