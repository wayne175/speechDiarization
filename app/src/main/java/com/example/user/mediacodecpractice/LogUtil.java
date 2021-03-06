package com.example.user.mediacodecpractice;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by USER on 2017-11-01.
 */

public class LogUtil {
    public static int count = 0;

    public static void log(float[] array, String msg) {
        StringBuffer buffer = new StringBuffer();
        for (float a : array) {
            buffer.append("\t" + String.valueOf(a));
        }
        Log.d(msg, buffer.toString());
    }

    public static void logSize(float[] array, String msg, int size) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            Log.d(msg, "java.append(" + array[i] + ")");
        }
        Log.d(msg, buffer.toString());
    }

    public static void log(int[] array, String msg) {
        StringBuffer buffer = new StringBuffer();
        for (int a : array) {
            buffer.append("\t" + String.valueOf(a));
        }
        Log.d(msg, buffer.toString());
    }


    public static void log(double[] array, String msg) {
        StringBuffer buffer = new StringBuffer();
        for (double a : array) {
            buffer.append("\t" + String.valueOf(a));
        }
        Log.d(msg, buffer.toString());
    }

    public static void logPy(double[] array, String msg) {
        for (double a : array) {
            Log.d(msg, "\tjava.append(" + a + ")");
        }
    }

    public static void logPy(float[] array, String msg) {
//        StringBuffer buffer = new StringBuffer();
        for (float a : array) {
            Log.d(msg, "java.append(" + a + ")");
        }
//        Log.d(msg,buffer.toString());
    }

    public static void writeToFile(float[] a, String filename) {
        // Get the directory for the user's public pictures directory.
        String filepath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filepath, "Music");


        file = new File(file.getAbsolutePath(), filename + count++ + ".txt");


        // Save your stream, don't forget to flush() it before closing it.

        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append("[");
            int count = 0;
            for (float aa : a) {
                if (count == 0) {

                    myOutWriter.append(String.valueOf(aa));
                    count++;
                } else {

                    myOutWriter.append("," + aa);
                }
            }
            myOutWriter.append("]");
            myOutWriter.close();

            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static void maxInArray(float[] a, String log) {
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;


        for (float aa : a) {
            if (aa > max) max = aa;
            if (aa < min) min = aa;
        }
        Log.d("maxmin", log + ":" + max + "/" + min);
    }

    public static void maxInArray(double[] a, String log) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;


        for (double aa : a) {
            if (aa > max) max = aa;
            if (aa < min) min = aa;
        }
        Log.d("maxmin", log + ":" + max + "/" + min);
    }


    public static void writeToFile(double[] a, String filename) {
        // Get the directory for the user's public pictures directory.
        String filepath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filepath, "Music");


        file = new File(file.getAbsolutePath(), filename + count++ + ".txt");


        // Save your stream, don't forget to flush() it before closing it.
        if (count <20) {
            try {
                file.createNewFile();
                FileOutputStream fOut = new FileOutputStream(file);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                myOutWriter.append("java+=[");
                int count = 0;
                for (double aa : a) {
                    if (count == 0) {
                        myOutWriter.append(String.valueOf(aa));
                        count++;
                    } else {
                        myOutWriter.append("," + aa);
                    }
                }
                myOutWriter.append("]");
                myOutWriter.close();

                fOut.flush();
                fOut.close();
            } catch (IOException e) {
                Log.e("Exception", "File write failed: " + e.toString());
            }
        }

    }

    public static void writeToFileAsWhole(double[][] a, String filename) {
        // Get the directory for the user's public pictures directory.
        String filepath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filepath, "Music");


        file = new File(file.getAbsolutePath(), filename + count++ + ".txt");


        // Save your stream, don't forget to flush() it before closing it.
        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append("java=[");
//                int count = 0;
//                for (double aa : a) {
//                    if (count == 0) {
//                        myOutWriter.append(String.valueOf(aa));
//                        count++;
//                    } else {
//                        myOutWriter.append("," + aa);
//                    }
//                }
            int count=0;
            for (double[] dd : a) {
                if(count==0){
                    myOutWriter.append("[");
                    count++;
                }else{
                    myOutWriter.append(",[");
                }
                int count2=0;
                for (double d : dd) {
                    if(count2==0){
                        myOutWriter.append(String.valueOf(d));
                        count2++;
                    }else{
                        myOutWriter.append(","+d);
                    }
                }
                myOutWriter.append("]");
            }
            myOutWriter.append("]");
            myOutWriter.close();

            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


}
