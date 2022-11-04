import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

class GUI {
    static void createAndDisplay() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Weekly Calendar");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(screenSize.width, screenSize.height);

        LocalDate[] week = Calendar.GetDates();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));

        for (LocalDate now : week) {
            JPanel panels = new JPanel();
            panels.setLayout(new BoxLayout(panels, BoxLayout.PAGE_AXIS));



            JPanel dateArea = new JPanel();

            JLabel dates = new JLabel(now.toString());
            dateArea.add(dates);

            JPanel eventsText = new JPanel();

            JTextField events = new JTextField("Write an event");
            eventsText.add(events);

            JPanel buttonArea = new JPanel();

            JButton buttons = new JButton("Add event");
            buttonArea.add(buttons);


            JPanel eventsArea = new JPanel();
            eventsArea.setLayout(new BoxLayout(eventsArea, BoxLayout.PAGE_AXIS));

            buttons.addActionListener(e -> {
                System.out.println(events.getText());

                eventsArea.add(new JLabel(events.getText()));
                eventsArea.updateUI();
            });

            if (Calendar.CompareDate(now)) {
                panels.setBackground(Color.blue);
                eventsArea.setBackground(Color.blue);
                eventsText.setBackground(Color.blue);
                buttonArea.setBackground(Color.blue);
            }
            panels.add(dates);
            panels.add(eventsText);
            panels.add(buttonArea);
            panels.add(Box.createVerticalGlue());
            panels.add(eventsArea);

            container.add(panels);
        }

        frame.add(container);
        frame.pack();
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setVisible(true);
    }
}
