/**
 *
 * @author dParikari
 */
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.datatransfer.StringSelection;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.Transferable;   

public class trial {

    Robot robo = new Robot();
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    

    public static void main(String[] args) throws AWTException, IOException, UnsupportedFlavorException, InterruptedException {
        trial worker = new trial();
        worker.mouseMv(916, 8);
        worker.leftClick();
        worker.mouseMv(39, 187);
        worker.leftClick();
        worker.ctrlC();
        worker.delay(1000);
        System.out.println(worker.getObject());
        // worker.mouseMv(916, 8);
        // worker.leftClick();
        // int startNum = 1;
        // int endNum = 20;
        // StringBuilder toWrite = new StringBuilder();
        // double total = 0d;
        // for(int i = startNum;i<=endNum;i++){
        //     long startTime = System.nanoTime();

        //     worker.mouseMv(134, 88);
        //     worker.leftClick();
        //     worker.selectAll();
        //     worker.type(String.valueOf(i));
        //     worker.pressEnter();
        //     worker.delay(200);
        //     worker.clear();
        //     String mrn = String.valueOf(i);
        //     String fname = worker.getData(107, 164);worker.clear();worker.delay(10);
        //     String lname = worker.getData(313, 164);worker.clear();worker.delay(10);
        //     String dob = worker.getData(74, 211);worker.clear();worker.delay(10);
        //     String gender = worker.getData(194, 208);worker.clear();worker.delay(10);
        //     String ssn = worker.getData(370, 208);worker.clear();worker.delay(10);
        //     String primPhone = worker.getData(114, 411);worker.clear();worker.delay(10);
        //     String secPhone = worker.getData(217, 409);worker.clear();worker.delay(10);
        //     String email = worker.getData(375,409);worker.clear();worker.delay(10);
        //     String addr1 = worker.getData(375, 250);worker.clear();worker.delay(10);
        //     String addr2 = worker.getData(375, 275);worker.clear();worker.delay(10);
        //     String city = worker.getData(260, 321);worker.clear();worker.delay(10);
        //     String state = worker.getData(301, 321);worker.clear();worker.delay(10);
        //     String zip = worker.getData(343, 321);worker.clear();worker.delay(10);
        //     String record = mrn + "|" + fname + "|" + lname + "|" + dob + "|" + gender + "|" 
        //                     + ssn + "|" + primPhone + "|" + secPhone + "|" 
        //                     + email + "|" + addr1 + "|" + addr2 + "|" + city  + "|" 
        //                     + state + "|" + zip;
        //     toWrite.append(record); 
        //     toWrite.append("\n"); 
        //     worker.delay(100);
        //     // System.out.println(i);
        //     long elapsedTime = System.nanoTime() - startTime;
        //     double sec = elapsedTime/1000000;
        //     System.out.println(i+"->"+sec);
        //     total+=sec;
            
        // }
        // Path filePath = Path.of("String.txt");
        // Files.writeString(filePath, toWrite.toString());
        // System.out.println(total+"\n"+toWrite.toString());
        
      
    }

    public String getObject() throws UnsupportedFlavorException, IOException{
        Transferable data = clipboard.getContents(ImageIO.class);
        return (String) data.getTransferData(DataFlavor.imageFlavor);
    }
    public String getData(int x, int y) throws UnsupportedFlavorException, IOException{
        robo.mouseMove(x, y);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.delay(5);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(5);
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_A);
        robo.delay(5);
        robo.keyRelease(KeyEvent.VK_A);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_C);
        robo.delay(5);
        robo.keyRelease(KeyEvent.VK_C);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.delay(5);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(20);
        return (String) clipboard.getData(DataFlavor.stringFlavor);
        }
    
    public void delay(int s){
        robo.delay(s);
    }
    
    public trial() throws AWTException {
        robo.setAutoDelay(5);
        robo.setAutoWaitForIdle(true);
    }

    public void selectAll() {
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_A);
        robo.delay(5);
        robo.keyRelease(KeyEvent.VK_A);
        robo.keyRelease(KeyEvent.VK_CONTROL);
    }
    public void clear() {
        StringSelection stringSelection = new StringSelection("");
        clipboard.setContents(
            stringSelection, null);
    }

    public void ctrlC() throws UnsupportedFlavorException, IOException {
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_C);
        robo.delay(5);
        robo.keyRelease(KeyEvent.VK_C);
        robo.keyRelease(KeyEvent.VK_CONTROL);
    }
    
    public String getString() throws UnsupportedFlavorException, IOException{
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }
    
    public void scroll(int i) {
        robo.mouseWheel(i);
    }
    
    public void leftClick() {
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.delay(5);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(5);
    }
    
    public void winKey() {
        robo.keyPress(KeyEvent.VK_WINDOWS);
        robo.keyRelease(KeyEvent.VK_WINDOWS);
    }
   
    public void paste() {
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_CONTROL);
    }
    
    public void pressEnter() {
        robo.keyPress(KeyEvent.VK_ENTER);
    }
    
    public void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) {
                code = code - 32;
            }
            robo.keyPress(code);
            robo.keyRelease(code);
        }
        
    }
    
    public void mouseMv(int x,int y)
    {
        robo.mouseMove(x, y);
    }
}