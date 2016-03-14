package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Dmitry on 09.03.2016.
 */
public class Controller
{
    private View view;

    private HTMLDocument document;

    private File currentFile;

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public Controller(View view)
    {
        this.view = view;
    }

    public void init()
    {
        createNewDocument();
    }

    public void exit()
    {
        System.exit(0);
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void resetDocument()
    {
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text)
    {
        resetDocument();
        StringReader reader = new StringReader(text);

        try
        {
            new HTMLEditorKit().read(reader, document, 0);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (BadLocationException e)
        {
            e.printStackTrace();
        }


    }

    public String getPlainText()
    {
        StringWriter writer = new StringWriter();
        try
        {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (BadLocationException e)
        {
            e.printStackTrace();
        }
        return writer.toString();
    }

    public void createNewDocument()
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument()
    {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());

        int n = chooser.showOpenDialog(view);
        if (n == chooser.APPROVE_OPTION)
        {
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try
            {
                FileReader reader = new FileReader(currentFile);
                new HTMLEditorKit().read(reader, document, 0);
                view.resetUndo();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (BadLocationException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        }
    }

    public void saveDocument()
    {
        view.selectHtmlTab();
        if (currentFile == null)
            saveDocumentAs();
        else
        {
            try (FileWriter writer = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }
            catch (BadLocationException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    public void saveDocumentAs()
    {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());

        int n = chooser.showSaveDialog(view);
        if (n == chooser.APPROVE_OPTION)
        {
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());

            try (FileWriter writer = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }
            catch (BadLocationException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


}
