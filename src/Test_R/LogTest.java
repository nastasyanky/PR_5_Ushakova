package Test_R;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogTest
{
    Logger logger;
    void initLog ()
    {
        try
        {
            logger = Logger.getLogger (LogTest.class.getName ());
            FileHandler xmlFile = new FileHandler ("logs.xml", true);
            logger.addHandler (xmlFile);
            FileHandler txtFile = new FileHandler ("logs.log", true);
            SimpleFormatter txtFormatter = new SimpleFormatter ();
            txtFile.setFormatter (txtFormatter);
            logger.addHandler (txtFile);
        }
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
    }
    void testMsg ()
    {
        logger.log (Level.FINEST,"Finest level!");
        logger.log (Level.WARNING,"Warning level!");
        logger.log (Level.SEVERE,"Severe level!");
    }
    public static void main (String [] args)
    {
        LogTest l = new LogTest ();
        l.initLog ();
        l.logger.setLevel (Level.SEVERE);
        l.testMsg ();
        l.logger.setLevel (Level.WARNING);
        l.testMsg ();
        l.logger.setLevel (Level.FINEST);
        l.testMsg ();
    }
}