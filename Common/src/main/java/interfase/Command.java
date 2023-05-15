package interfase;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.NoSuchElementException;

/**
 * Interface containing execute and Information
 */
public interface Command extends Serializable {
    /**
     * Fild
     * @param args arg
     * @throws ParseException mistake
     * @throws IOException mistake
     * @throws NoSuchElementException mistake
     */
    void execute(String[] args) throws ParseException, IOException, NoSuchElementException, ClassNotFoundException;

    /**
     * Fild for Information
     */
    String Information() throws IOException;
}