package com.charleyskills.mafiaprojectpro;

import android.os.Environment;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class IO
{
    public static final String STATISTICSplayers = ".STATISTICSplayers";
    public static final String GAMEPRESETconfig = ".GAMEPRESETconfig";
    public static final String THEMEconfig = ".THEMEconfig";
    public static final String LWPstate = ".LWPstate";
    public static final String LWPvotepos = ".LWPvotepos";
    public static final String CUSTOMIZEGAMEstate = ".CUSTOMIZEGAMEstate";
    public static final String SNARitems = ".SNARitems";
    public static final String SNARadapterrole = ".SNARadapterrole";
    public static final String GAMERitems = ".GAMERitems";

    public static void writeToSD(Object writeObject, String filename, String log_id)
    {
        PrintStream toTextFile = null;
        Writer writer = new StringWriter();
        Serializer serializer = new Persister();
        try
        {
            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            {
                Logger.i("SD:" + log_id, "SD-карта не доступна: " + Environment.getExternalStorageState());
                write(writeObject, filename, log_id);
                return;
            }

            File sdPath = Environment.getExternalStorageDirectory();
            sdPath = new File(sdPath.getAbsolutePath() + "/" + "MafiaProject");
            if (sdPath.mkdirs())
            {
                Logger.i("SD:" + log_id, "Create dir.");
            }
            File sdFile = new File(sdPath, filename);
            toTextFile = new PrintStream(sdFile);
            serializer.write(writeObject, writer);
            String xml = writer.toString();
            toTextFile.print(xml);

            Logger.i("SD:" + log_id, "File was written.");
        }
        catch (Exception e)
        {
            Logger.e("SD:" + log_id, e.toString());
            e.printStackTrace();
        }
        finally
        {
            if (toTextFile != null)
            {
                toTextFile.close();
            }
        }
    }

    private static boolean write(Object writeObject, String filename, String log_id)
    {
        PrintStream toTextFile = null;
        Writer writer = new StringWriter();
        Serializer serializer = new Persister();
        try
        {
            File sdPath = new File(MafiaProjectProApp.getContext().getFilesDir() + "/" + "MafiaProject");
            if (sdPath.mkdirs())
            {
                Logger.i(log_id, "Create dir.");
            }
            File sdFile = new File(sdPath, filename);
            toTextFile = new PrintStream(sdFile);
            serializer.write(writeObject, writer);
            String xml = writer.toString();
            toTextFile.print(xml);

            Logger.i(log_id, "File was written.");
            return true;
        }
        catch (Exception e)
        {
            Logger.e(log_id, e.toString());
            e.printStackTrace();
            return false;
        }
        finally
        {
            if (toTextFile != null)
            {
                toTextFile.close();
            }
        }
    }

    public static Object readFromSD(Class readClass, String filename, String log_id) throws Exception
    {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            Logger.i("SD:" + log_id, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return read(readClass, filename, log_id);
        }

        File sdFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "MafiaProject", filename);

        Reader reader = new StringReader(getStringFromFile(sdFile.getAbsolutePath()));
        Persister serializer = new Persister();

        Object writeObject = serializer.read(readClass, reader, false);
        Logger.i("SD:" + log_id, "File was read.");
        return writeObject;
    }

    private static Object read(Class readClass, String filename, String log_id) throws Exception
    {
        File sdPath = new File(MafiaProjectProApp.getContext().getFilesDir() + "/" + "MafiaProject");
        if (sdPath.mkdirs())
        {
            Logger.i(log_id, "Create dir.");
        }
        File sdFile = new File(sdPath, filename);

        Reader reader = new StringReader(getStringFromFile(sdFile.getAbsolutePath()));
        Persister serializer = new Persister();

        Object containerObj = serializer.read(readClass, reader, false);
        Logger.i(log_id, "File was read.");
        return containerObj;
    }

    public static void deleteFromSD(String filename, String log_id)
    {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            Logger.i("SD:" + log_id, "SD-карта не доступна: " + Environment.getExternalStorageState());
            delete(filename, log_id);
            return;
        }

        File sdFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "MafiaProject", filename);
        Logger.i("SD:" + log_id, String.valueOf(sdFile.delete()));
    }

    private static boolean delete(String filename, String log_id)
    {
        File sdPath = new File(MafiaProjectProApp.getContext().getFilesDir() + "/" + "MafiaProject");
        if (sdPath.mkdirs())
        {
            Logger.i(log_id, "Create dir.");
        }
        File sdFile = new File(sdPath, filename);
        Logger.i(log_id, String.valueOf(sdFile.delete()));

        return true;
    }

    private static String getStringFromFile(String filePath) throws Exception
    {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        fin.close();
        return ret;
    }

    private static String convertStreamToString(InputStream is) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null)
        {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}