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
import java.awt.datatransfer.DataFlavor;    

public class myClass {

    Robot robo = new Robot();
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    

    public static void main(String[] args) throws AWTException, IOException, UnsupportedFlavorException, InterruptedException {
        myClass worker = new myClass();
        worker.winKey();
        worker.delay(1000);
        worker.type("Excel");
        worker.delay(1000);
        worker.pressEnter();worker.delay(2000);
        worker.mouseMv(270, 200);
        worker.delay(100);
        worker.leftClick();
        worker.delay(2000);
        worker.mouseMv(56, 256);
        worker.leftClick();
        int num = 3;
        for(int i=0;i<10;i++){
            worker.type(num+"/11/2022");worker.delay(50);
            worker.pressEnter();worker.delay(50);
            num++;
        }
        worker.mouseMv(56, 256);
        worker.leftClick();
        worker.delay(50);
        for(int j=0;j<10;j++){
            worker.ctrlC();
            worker.delay(50);
            String hello = worker.getString();
    
            if(hello.equals("08-11-2022")){
                worker.delay(100000);
            }else{
                worker.mouseDown();
            }
        }
        
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
public void mouseDown(){
    robo.keyPress(KeyEvent.VK_DOWN);
    robo.delay(100);
    robo.keyRelease(KeyEvent.VK_DOWN);
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
    
    public myClass() throws AWTException {
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