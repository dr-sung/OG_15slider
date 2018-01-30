
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame {

    private JPanel colorPanel;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    public void initialize() {

        colorPanel = new JPanel();

        ChangeListener listener = new ColorListener();

        redSlider = new JSlider(0, 100, 100);
        redSlider.addChangeListener(listener);

        greenSlider = new JSlider(0, 100, 70);
        greenSlider.addChangeListener(listener);

        blueSlider = new JSlider(0, 100, 70);
        blueSlider.addChangeListener(listener);

        // fill content pane

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 2));
        southPanel.add(new JLabel("Red", SwingConstants.RIGHT));
        southPanel.add(redSlider);
        southPanel.add(new JLabel("Green", SwingConstants.RIGHT));
        southPanel.add(greenSlider);
        southPanel.add(new JLabel("Blue", SwingConstants.RIGHT));
        southPanel.add(blueSlider);

        Container contentPane = getContentPane();
        contentPane.add(colorPanel, BorderLayout.CENTER);
        contentPane.add(southPanel, BorderLayout.SOUTH);

        setSampleColor();
    }

    /**
     * Reads the slider values and sets the panel to the selected color.
     */
    private void setSampleColor() {  // read slider values

        float red = 0.01F * redSlider.getValue();
        float green = 0.01F * greenSlider.getValue();
        float blue = 0.01F * blueSlider.getValue();

        // set panel background to selected color

        colorPanel.setBackground(new Color(red, green, blue));
        colorPanel.repaint();
    }

    private class ColorListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent event) {
            setSampleColor();
        }
    }
}
