//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.github.gumtreediff.gen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public abstract class ExternalProcessTreeGenerator extends TreeGenerator {
    public ExternalProcessTreeGenerator() {
    }

    public String readStandardOutput(Reader r) throws IOException {
        File f = this.dumpReaderInTempFile(r);
        ProcessBuilder b = new ProcessBuilder(this.getCommandLine(f.getAbsolutePath()));
        b.directory(f.getParentFile());
        Process p = b.start();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
            Throwable var6 = null;

            try {
                StringBuilder buf = new StringBuilder();
                String line = null;

                while((line = br.readLine()) != null) {
                    buf.append(line + System.lineSeparator());
                }

                p.waitFor();
                if (p.exitValue() != 0) {
                    throw new RuntimeException(buf.toString());
                } else {
                    r.close();
                    p.destroy();
                    String var9 = buf.toString();
                    return var9;
                }
            } catch (Throwable var20) {
                var6 = var20;
                throw var20;
            } finally {
                $closeResource(var6, br);
            }
        } catch (InterruptedException var22) {
            InterruptedException e = var22;
            throw new RuntimeException(e);
        } finally {
            f.delete();
        }
    }

    private File dumpReaderInTempFile(Reader r) throws IOException {
        File f = File.createTempFile("gumtree", "");
        Writer w = Files.newBufferedWriter(f.toPath(), Charset.forName("UTF-8"));
        Throwable var4 = null;

        try {
            char[] buf = new char[8192];

            while(true) {
                int length = r.read(buf);
                if (length < 0) {
                    return f;
                }

                ((Writer)w).write(buf, 0, length);
            }
        } catch (Throwable var10) {
            var4 = var10;
            throw var10;
        } finally {
            if (w != null) {
                $closeResource(var4, w);
            }

        }
    }

    protected abstract String[] getCommandLine(String var1);
}
