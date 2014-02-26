import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.ByteBuffer;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LifeModelTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LifeModelTest {
    ILifeModel lm;
    StringOutputStream out;
    
    private static String readFile(String path) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(encoded)).toString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test
    public void stillLifes() {
        String stillLife = readFile("boards/stillLife.txt");
        lm.readFromScanner(new Scanner(stillLife));
        lm.setIsScreenWrapped(false);
        lm.printToFile(new PrintStream(out));
        assertEquals(stillLife, out.getString());
    }
        
        
        
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        this.lm = new LifeModel(10, 10, 10);
        this.out = new StringOutputStream();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    private class StringOutputStream extends OutputStream {
        StringBuilder mBuf = new StringBuilder();

        public void write(int val) throws IOException {
            mBuf.append((char) val);
        }

        public String getString() {
            return mBuf.toString();
        }
    }
}
