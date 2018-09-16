package myrobot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

class myFrame extends JFrame
{
    private Robot robot;
    public myFrame()
    {
        setTitle("iRobot"); // имя заголовка нашего окна
        JPanel panel = new JPanel(); // создаем контейнер
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen=env.getDefaultScreenDevice(); // GraphicsDevice класс описывает графические устройства, которые могут быть доступны в определенной среде графики.
        try {
            robot=new Robot(screen);
        } catch (AWTException ex) { }
        JButton bt1 = new JButton("Start"); // создаем кнопку
        panel.add(bt1); // добавляем нашу кнопку на панель
        bt1.addActionListener(new ActionListener(){ // добавляем обработчик на нашу кнопку

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<4; i++) // здесь и происходят все действие с нашим роботом
                {
                    System.out.println("size screen : " + width + " + " + height);
                    robot.mouseMove(500, 700 + 15 * i); // двигаем мышку на заданную координату x,y
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // нажимаем левую кнопку мыши
                    robot.delay(300); // 300 миллисекундная пауза
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // отжимаем левую кнопку мыши
                    robot.delay(300);
                    robot.keyPress('1'); // нажимаем кнопу 'O' с клавиатуры
                    robot.keyRelease('1'); // отжимаем кнопу 'O' с клавиатуры
                    robot.delay(300);

                }
            }
        });
        Container pane = getContentPane(); // создаем контейнер
        pane.add(panel); // добавляем нашу панель в контейнер
        pack(); // задает размер нашему фрейму исходя из размеров нашей кнопки
    }
}

public class MyRobot {
    public static void main(String[] args) {
        myFrame frame = new myFrame(); // создаем объект класса myFrame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задаем действие обработчику на кнопку "крестик"
        frame.show(); // выводим на экран нашу форму
    }
}

/*public class MyRobot {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // Creates the delay of 5 sec so that you can open notepad before

            // Robot start writting

            robot.delay(5000);

            robot.keyPress(KeyEvent.VK_H);

            robot.keyPress(KeyEvent.VK_I);

            robot.keyPress(KeyEvent.VK_SPACE);

            robot.keyPress(KeyEvent.VK_M);

            robot.keyPress(KeyEvent.VK_E);

            robot.keyPress(KeyEvent.VK_N);

        } catch (AWTException e) {

            e.printStackTrace();

        }

    }

}*/
