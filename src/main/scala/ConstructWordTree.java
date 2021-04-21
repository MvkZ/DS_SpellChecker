import AlgoObjects.Node;
import AlgoObjects.TernarySearchTree;

import java.io.*;
import java.util.logging.Logger;

public class ConstructWordTree {
    private static Logger log = Logger.getLogger(ConstructWordTree.class.getName());

    public static Node createTree(TernarySearchTree tst) {
        long startTime = System.currentTimeMillis();

        try {
            InputStream inputStream = getWordListFile();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String token[] = null;
            while ((line = br.readLine()) != null) {
                token = line.split(" ");
                // token[0] = Word.
                // token[1] = Word Frequency.
                tst.insert(token[0], token[1]);
            }

            inputStream.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("Tree creadted in : " + ((System.currentTimeMillis() - startTime)) + " ms");
        return tst.getRoot();
    }

    private static InputStream getWordListFile() throws FileNotFoundException {
        return new FileInputStream("dict.txt");
    }
}
