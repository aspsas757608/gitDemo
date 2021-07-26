package com.saxena.learn;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.text.*;
import java.util.HashMap;

public class ArabicDigits extends Applet {
    ArabicDigitsPanel panel;

    static final String defaultFontName = "Lucida Sans";

    public ArabicDigits() {
        panel = new ArabicDigitsPanel(defaultFontName);
    }

    public ArabicDigits(String fontname) {
        panel = new ArabicDigitsPanel(fontname);
    }

    public void init() {
        setLayout(new BorderLayout());
        add("Center", panel);
    }

    public void destroy() {
        remove(panel);
    }

    public static void main(String args[]) {
        String fontname = defaultFontName;
        if (args.length > 0) {
            fontname = args[0];
        }
        ArabicDigits arabicDigits = new ArabicDigits(fontname);
        arabicDigits.init();
        arabicDigits.start();

        Frame f = new Frame("ArabicDigits");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add("Center", arabicDigits);
        f.setSize(600, 250);
        f.setVisible(true);
    }

    public String getAppletInfo() {
        return "Arabic Digits Example";
    }

    static class ArabicDigitsPanel extends Panel {
        String fontname;
	TextLayout layout;

	private static final String text = "0 1 2 3 4 5 6 7 8 9";

        void dumpChars(char[] chars) {
            for (int i = 0; i < chars.length; ++i) {
                char c = chars[i];
                if (c < 0x7f) {
                    System.out.print(c);
                } else {
                    String n = Integer.toHexString(c);
                    n = "0000".substring(n.length()) + n;
                    System.out.print("0x" + n);
                }
            }
            System.out.println();
        }

        ArabicDigitsPanel(String fontname) {
	    HashMap map = new HashMap();
	    Font font = new Font(fontname, Font.PLAIN, 60);
	    map.put(TextAttribute.FONT, font);
	    map.put(TextAttribute.NUMERIC_SHAPING,
	        NumericShaper.getShaper(NumericShaper.ARABIC));
	    FontRenderContext frc = new FontRenderContext(null, false, false);
	    layout = new TextLayout(text, map, frc);
        }

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;

            layout.draw(g2d, 10, 50);
        }
    }
}
