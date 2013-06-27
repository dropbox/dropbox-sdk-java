package com.dropbox.core.util;

public class DumpWriter
{
    private int currentIndent;
    private int indentAmount;
    private StringBuilder buf;

    public DumpWriter(StringBuilder buf, int currentIndent, int indentAmount)
    {
        this.currentIndent = currentIndent;
        this.indentAmount = indentAmount;
        this.buf = buf;
    }

    public DumpWriter()
    {
        this(new StringBuilder(), 0, 2);
    }

    // --------------------------------------------------------------
    // Formatting code.

    // Whether we're the beginning of a line.
    private boolean nl = false;

    private void maybeIndent()
    {
        if (nl) {
            indent();
        }
    }

    private void indent()
    {
        if (!nl) {
            throw new IllegalStateException("Calling indent() but we're not at the beginning of a line.  Perhaps somebody forgot to call writeln() or nl() after their value?");
        }
        for (int i = 0; i < currentIndent; i++) {
            buf.append(' ');
        }
        nl = false;
    }

    public void nl()
    {
        buf.append('\n');
        nl = true;
    }

    public DumpWriter write(String s)
    {
        maybeIndent();
        buf.append(s);
        return this;
    }

    public void writeln(String s)
    {
        write(s).nl();
    }

    public void startIndent(String marker)
    {
        maybeIndent();
        buf.append(marker);
        currentIndent += indentAmount;
        nl();
    }

    public void endIndent(String marker)
    {
        currentIndent -= indentAmount;
        indent();
        buf.append(marker);
        nl();
    }

    public void structStart()
    {
        startIndent("{");
    }

    public void field(String name)
    {
        indent();
        buf.append(name).append(" = ");
    }

    public void structEnd()
    {
        endIndent("}");
    }
}
