import java.awt.Robot;
import java.awt.event.KeyEvent;
Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_WINDOWS);
robot.keyPress(KeyEvent.VK_ADD);
robot.keyRelease(KeyEvent.VK_ADD);
robot.keyRelease(KeyEvent.VK_WINDOWS);  
robot.delay(500);
robot.keyPress(KeyEvent.VK_WINDOWS);
robot.keyPress(KeyEvent.VK_ADD);
robot.keyRelease(KeyEvent.VK_ADD);
robot.keyRelease(KeyEvent.VK_WINDOWS);  

