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
        lm.step();
        lm.printToFile(new PrintStream(out));
        assertEquals(stillLife, out.getString());
        lm.step();
        lm.step();
        this.out = new StringOutputStream();
        lm.printToFile(new PrintStream(out));
        assertEquals(stillLife, out.getString());
    }
    
    @Test
    public void oscillators() {
        String oscillator0 = readFile("boards/oscillators0.txt");
        String oscillator1 = readFile("boards/oscillators1.txt");
        String oscillator2 = readFile("boards/oscillators2.txt");
        String oscillator3 = readFile("boards/oscillators3.txt");
        String oscillator4 = readFile("boards/oscillators4.txt");
        String oscillator5 = readFile("boards/oscillators5.txt");
        lm.readFromScanner(new Scanner(oscillator0));
        lm.setIsScreenWrapped(false);
        lm.printToFile(new PrintStream(out));
        assertEquals(oscillator0, out.getString());
        this.out = new StringOutputStream();
        lm.step();
        lm.printToFile(new PrintStream(out));
        assertEquals(oscillator1, out.getString());
        this.out = new StringOutputStream();
        lm.step();
        lm.printToFile(new PrintStream(out));
        assertEquals(oscillator2, out.getString());
        this.out = new StringOutputStream();
        lm.step();
        lm.printToFile(new PrintStream(out));
        assertEquals(oscillator3, out.getString());
        this.out = new StringOutputStream();
        lm.step();
        lm.printToFile(new PrintStream(out));
        assertEquals(oscillator4, out.getString());
        this.out = new StringOutputStream();
        lm.step();
        lm.printToFile(new PrintStream(out));
        assertEquals(oscillator5, out.getString());
    }
    
    @Test
    public void dieHard() {
        String dieHard0 = readFile("boards/dieHard0.txt");
        String dieHard10 = readFile("boards/dieHard10.txt");
        String dieHard30 = readFile("boards/dieHard30.txt");
        String dieHard50 = readFile("boards/dieHard50.txt");
        String dieHard70 = readFile("boards/dieHard70.txt");
        String dieHard90 = readFile("boards/dieHard90.txt");
        String dieHard110 = readFile("boards/dieHard110.txt");
        lm.readFromScanner(new Scanner(dieHard0));
        lm.setIsScreenWrapped(false);
        lm.printToFile(new PrintStream(out));
        assertEquals(dieHard0, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 10; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(dieHard10, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 20; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(dieHard30, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 20; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(dieHard50, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 20; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(dieHard70, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 20; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(dieHard90, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 20; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(dieHard110, out.getString());
    } 
    
    @Test
    public void wrapped() {
        String wrapped0 = readFile("boards/wrapped0.txt");
        String wrapped1 = readFile("boards/wrapped1.txt");
        lm.readFromScanner(new Scanner(wrapped0));
        lm.setIsScreenWrapped(true);
        lm.printToFile(new PrintStream(out));
        assertEquals(wrapped0, out.getString());
        this.out = new StringOutputStream();
        lm.step();
        lm.printToFile(new PrintStream(out));
        assertEquals(wrapped1, out.getString());
        this.out = new StringOutputStream();
        lm.step();
        lm.printToFile(new PrintStream(out));
        assertEquals(wrapped0, out.getString());
    }
    
    @Test
    public void lwss() {
        String lwss0 = readFile("boards/lwss0.txt");
        String lwss50 = readFile("boards/lwss50.txt");
        lm.readFromScanner(new Scanner(lwss0));
        lm.setIsScreenWrapped(true);
        lm.printToFile(new PrintStream(out));
        assertEquals(lwss0, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 50; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(lwss50, out.getString());
    }
    
    @Test
    public void gosperGliderGun() {
        String ggg0 = readFile("boards/gosperGliderGun0.txt");
        String ggg50 = readFile("boards/gosperGliderGun50.txt");
        String ggg100 = readFile("boards/gosperGliderGun100.txt");
        String ggg150 = readFile("boards/gosperGliderGun150.txt");
        lm.readFromScanner(new Scanner(ggg0));
        lm.setIsScreenWrapped(true);
        lm.printToFile(new PrintStream(out));
        assertEquals(ggg0, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 50; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(ggg50, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 50; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(ggg100, out.getString());
        this.out = new StringOutputStream();
        for (int i = 0; i < 50; i++) {
            lm.step();
        }
        lm.printToFile(new PrintStream(out));
        assertEquals(ggg150, out.getString());
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
